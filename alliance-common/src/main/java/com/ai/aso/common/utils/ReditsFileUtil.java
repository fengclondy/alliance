package com.ai.aso.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.exception.BizExInfoEnum;
import com.ai.aso.common.exception.BizValidException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 文件上传缓存redits
 * <p>
 * Description:
 * </p>
 *
 * @author lw
 * @date 2017年1月5日
 *
 */
@Service("reditsFileUtil")
public class ReditsFileUtil {
	@Resource(name = "redisTemplate")
	private RedisTemplate<String, Object> redisTemplate;
	@Resource(name = "redisTemplate")
	private ValueOperations<String, Object> valueOps;
	private static final Logger log = LoggerFactory.getLogger(ReditsFileUtil.class);
	//private Session session = SecurityUtils.getSubject().getSession();
	/**
	 * 上传时调用缓存到redits
	 * 
	 * @param uFile
	 * @param fileName 上传者的ID
	 * @return 返回文件名
	 * @throws IOException
	 */
	public String fileCache(MultipartFile uFile, String fileName) throws IOException {
		String fileStr = transStrFile(uFile, uFile.getOriginalFilename());
		if (StringUtil.isNotEmpty(fileStr) && StringUtil.isNotEmpty(uFile.getOriginalFilename())) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			String rename = format.format(new Date()) + (int) ((Math.random() * 9 + 1) * 100)+ fileName;
			String newFileName = rename + uFile.getOriginalFilename().substring(uFile.getOriginalFilename().lastIndexOf("."));
			String key = "FILE." + newFileName;
			String value = "";
			value = new String(fileStr);
			
			//session.setAttribute(key, value);
			redisTemplate.opsForValue().set(key, value, 30, TimeUnit.MINUTES);
			return newFileName;
		} else {
			throw new BizValidException(BizExInfoEnum.CONTRACT_FILE_NOT_FOUND);
		}
	}

	/**
	 * 提交时调用从redits上读取缓存
	 * 
	 * @param name
	 * @throws IOException
	 */
	public String fileSave(String name,String path) throws IOException {
		byte[] byteFile = fileReturn(name);
		File dirPath = new File(path);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
		String serverPath = path + File.separator + name;

		File uploadFile = new File(serverPath);
		FileCopyUtils.copy(byteFile, uploadFile);
		return uploadFile.getName();

	}

	/**
	 * 返回文件byte[]
	 * 
	 * @param name
	 * @return
	 * @throws IOException
	 */
	public byte[] fileReturn(String name) throws IOException {
		byte[] fileByte = null;
		if (name != null) {
			String key = "FILE." + name;
			//String value =session.getAttribute(key);
			String value = (String) redisTemplate.opsForValue().get(key);
			if (StringUtil.isEmpty(value)) {
				throw new BizValidException(BizExInfoEnum.CONTRACT_FILE_NOT_FOUND);
			}

			fileByte = decodeTofile(value);
			return fileByte;
		} else {
			throw new BizValidException(BizExInfoEnum.CONTRACT_FILE_NOT_FOUND);
		}
	}

	/**
	 * 对文件进行转码成string
	 * 
	 * @param uFile
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private static String transStrFile(MultipartFile uFile, String fileName) throws IOException {
		String fileStr = null;
		InputStream is = null;
		if (null != uFile) {
			is = uFile.getInputStream();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			// 读取缓存
			byte[] buffer = new byte[2048];
			int length = 0;
			while ((length = is.read(buffer)) != -1) {
				bos.write(buffer, 0, length);// 写入输出流
			}
			is.close();// 读取完毕，关闭输入流
			BASE64Encoder encoder = new BASE64Encoder();
			fileStr = encoder.encode(bos.toByteArray());

		} else {
			throw new BizValidException(BizExInfoEnum.PAYMENT_PAYCERT_NOT_FOUND);
		}
		return fileStr;

	}

	/**
	 * 转换成byte[]
	 * 
	 * @param fileString
	 * @return
	 */
	private byte[] decodeTofile(String fileString) {
		byte[] fileByte = new byte[] {};
		try {
			BASE64Decoder decoder = new BASE64Decoder();
			fileByte = decoder.decodeBuffer(fileString);
			return fileByte;
		} catch (Exception e) {
			log.error("文件流不存在异常", e);
		}
		return fileByte;
	}
}
