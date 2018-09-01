package com.ai.aso.common.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.exception.BizExInfoEnum;
import com.ai.aso.common.exception.BizValidException;
import com.ai.aso.common.utils.FileOperateUtil;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 图片上传缓存到redits
 * <p>
 * Description:
 * </p>
 *
 * @author lw
 * @date 2017年1月5日
 *
 */
@Component("reditsImageUtils")
public class ReditsImageUtils {
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	@Resource(name = "redisTemplate")
	private ValueOperations<String, Object> valueOps;
	private static final Logger log = LoggerFactory.getLogger(ReditsImageUtils.class);

	/**
	 * 图片上传是调用缓存到redits
	 * 
	 * @param uFile
	 * @param fileName上传者的ID
	 * @return 返回文件名
	 * @throws IOException
	 */
	public String saveCache(MultipartFile uFile, String fileName) throws IOException {
		String imagestr = readImage(uFile, uFile.getOriginalFilename());
		if (StringUtil.isNotEmpty(imagestr) && StringUtil.isNotEmpty(uFile.getOriginalFilename())) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			String rename = format.format(new Date()) + (int) ((Math.random() * 9 + 1) * 100) + fileName;
			String newFileName = rename
					+ uFile.getOriginalFilename().substring(uFile.getOriginalFilename().lastIndexOf("."));
			String key = "IMAGE." + newFileName;
			String value = "";
			value = new String(imagestr);
			redisTemplate.opsForValue().set(key, value, 30, TimeUnit.MINUTES);
			return newFileName;
		} else {
			throw new BizValidException(BizExInfoEnum.PAYMENT_PAYCERT_NOT_FOUND);
		}
	}

	/**
	 * 提交时调用从redits上读取缓存的图片
	 * 
	 * @param name
	 * @throws IOException
	 */
	public String saveFile(String name) throws IOException {
		byte[] byteImage = imageReturn(name);
		String path = FileOperateUtil.PAYMENT_PATH;
		File dirPath = new File(path);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
		String serverPath = path + File.separator + name;

		File uploadFile = new File(serverPath);
		FileCopyUtils.copy(byteImage, uploadFile);
		return uploadFile.getName();

	}

	/**
	 * 返回图片byte[]
	 * 
	 * @param name
	 * @return
	 */
	public byte[] imageReturn(String name) {
		if (name != null) {
			String key = "IMAGE." + name;
			String value = (String) redisTemplate.opsForValue().get(key);
			if (StringUtil.isEmpty(value)) {
				throw new BizValidException(BizExInfoEnum.PAYMENT_PAYCERT_NOT_FOUND);
			}
			byte[] byteImage = decodeToImage(value);
			return byteImage;
		} else {
			throw new BizValidException(BizExInfoEnum.PAYMENT_PAYCERT_NOT_FOUND);
		}
	}

	/**
	 * 对图片进行转码成string
	 * 
	 * @param uFile
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private  String readImage(MultipartFile uFile, String fileName) throws IOException {
		String imagestr = null;
		InputStream is = null;
		if (null != uFile) {
			try {
				is = uFile.getInputStream();
				BufferedImage img = ImageIO.read(is);
				imagestr = encodeToString(img, fileName);
			} catch (IOException ex) {
				log.error("文件流不存在异常", ex);
			}
			return imagestr;
		} else {
			throw new BizValidException(BizExInfoEnum.PAYMENT_PAYCERT_NOT_FOUND);
		}

	}

	/**
	 * 图片流转换成string
	 * 
	 * @param image
	 * @param type
	 * @return
	 */
	private  String encodeToString(BufferedImage image, String fileName) {
		String imageString = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String type = fileName.substring(fileName.lastIndexOf(".") + 1);
		try {
			ImageIO.write(image, type, bos);
			byte[] imageBytes = bos.toByteArray();

			BASE64Encoder encoder = new BASE64Encoder();
			imageString = encoder.encode(imageBytes);
			bos.close();
		} catch (IOException e) {
			log.error("文件流不存在异常", e);
		}
		return imageString;
	}

	/**
	 * 转换成byte[]
	 * 
	 * @param imageString
	 * @return
	 */
	private  byte[] decodeToImage(String imageString) {
		byte[] imageByte = new byte[] {};
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			imageByte = decoder.decodeBuffer(imageString);
			return imageByte;
		} catch (Exception e) {
			log.error("文件流不存在异常", e);
		}
		return imageByte;
	}


}
