package com.ai.aso.common.utils;

import static com.ai.aso.common.constants.HttpConstants.CACHE_CONTROL;
import static com.ai.aso.common.constants.HttpConstants.EXPIRES;
import static com.ai.aso.common.constants.HttpConstants.IMAGE_JPEG;
import static com.ai.aso.common.constants.HttpConstants.NO_CACHE;
import static com.ai.aso.common.constants.HttpConstants.PRAGMA;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ai.aso.common.param.GlobalParamSet;
import com.ai.aso.common.constants.BizConstants;

/**
 * 文件上传下载
 *<p>Description:</p>
 *
 *@author liuwu
 *@date 2016年9月8日
 *
 */
public class FileOperateUtil {
	
	private static final String rootPath = GlobalParamSet.getString(BizConstants.FILE_ROOT_PATH);

	public static final String PFPC_PATH = rootPath + GlobalParamSet.getString(BizConstants.FILE_UPLOAD_PFPC_PATH);
	public static final String PAYMENT_PATH = rootPath + GlobalParamSet.getString(BizConstants.FILE_UPLOAD_PAYMENT_PATH);
	public static final String CONT_PATH = rootPath + GlobalParamSet.getString(BizConstants.FILE_UPLOAD_CONTRACT_PATH);
	public static final String TEMPLAT_PATH = rootPath + GlobalParamSet.getString(BizConstants.FILE_TEMPLET_PATH);
	
	/**
	 * 流量派发文件上传
	 */
	public static String uploadDataPut(MultipartFile file) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String preName = format.format(new Date()) + (int) ((Math.random() * 9 + 1) * 100000);
		return uploadFileTo(file, preName, GlobalParamSet.getString(BizConstants.FILE_UPLOAD_PFPC_PATH));
	}

	/**
	 * 支付凭证上传
	 */
	public static String uploadPayCert(MultipartFile file, String fileRename) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String rename = format.format(new Date()) + (int) ((Math.random() * 9 + 1) * 100) + fileRename;
		
		return uploadFileTo(file, rename, GlobalParamSet.getString(BizConstants.FILE_UPLOAD_PAYMENT_PATH));
		//return uploadFileTo(file, rename, "D:/myImage");
	}
	
	public static String uploadContCopy(MultipartFile file, String accId) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String rename = accId + format.format(new Date()) + (int) ((Math.random() * 9 + 1) * 100);
		
		return uploadFileTo(file, rename, GlobalParamSet.getString(BizConstants.FILE_UPLOAD_CONTRACT_PATH));
	}
	
	/**
	 * 私有方法，用于提供文件上传功能
	 * @param file - 结构文件
	 * @param preName - 文件名前缀
	 * @param path - 存放路径
	 * @throws Exception
	 */
	private static String uploadFileTo(MultipartFile file, String preName, String path) throws Exception {  
		
		// 获得文件名：
		String realName = file.getOriginalFilename();
		// 创建文件 GlobalParamSet.getString(BizConstants.SYS_FILE_UPLOAD_ROOT) +
		String ctxPath = rootPath + path;
		//String ctxPath = path;
		File dirPath = new File(ctxPath);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
		
		String newFileName = preName + realName.substring(realName.lastIndexOf("."));
		// 用日期加上用户id替换原来的文件名
		String serverPath = ctxPath + File.separator + newFileName;
		File uploadFile = new File(serverPath);
		FileCopyUtils.copy(file.getBytes(), uploadFile);
		return newFileName;
    }
	
	public static void downloadPayCert(OutputStream out, String filename) throws FileNotFoundException, IOException {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		bis = new BufferedInputStream(new FileInputStream(new File(PAYMENT_PATH + File.separator + filename)));
		bos = new BufferedOutputStream(out);
		byte[] buff = new byte[2048];
		int bytesRead;
		while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) 
		{
			bos.write(buff, 0, bytesRead);
		}
		bis.close();
		bos.close();
	}
	
	public static void downloadContFile(ServletOutputStream out, String filename) throws FileNotFoundException, IOException {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		bis = new BufferedInputStream(new FileInputStream(new File(CONT_PATH + File.separator + filename)));
		bos = new BufferedOutputStream(out);
		byte[] buff = new byte[2048];
		int bytesRead;
		while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) 
		{
			bos.write(buff, 0, bytesRead);
		}
		bis.close();
		bos.close();
	}
	
	/**
	 * 文件下载
	 * @author wuqiang6
	 * 
	 */
	public static void download(OutputStream out, File outFile) throws Exception {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		bis = new BufferedInputStream(new FileInputStream(outFile));
		bos = new BufferedOutputStream(out);
		byte[] buff = new byte[2048];
		int bytesRead;
		while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) 
		{
			bos.write(buff, 0, bytesRead);
		}
		bis.close();
		bos.close();
	}
	
	/**
	 * 文件下载
	 * @author wuqiang6
	 * 
	 */
	public static void download(OutputStream out, FileInputStream outFile) throws Exception {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		bis = new BufferedInputStream(outFile);
		bos = new BufferedOutputStream(out);
		byte[] buff = new byte[2048];
		int bytesRead;
		while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) 
		{
			bos.write(buff, 0, bytesRead);
		}
		bis.close();
		bos.close();
	}
	
	public static void setImgHeader(HttpServletResponse response){
		response.setHeader(CACHE_CONTROL, NO_CACHE);
		response.setHeader(PRAGMA, NO_CACHE);
		response.setDateHeader(EXPIRES, 0);
		response.setContentType(IMAGE_JPEG);
	}
	
	public static void setJPGHeader(HttpServletResponse response){
		response.setHeader(CACHE_CONTROL, NO_CACHE);
		response.setHeader(PRAGMA, NO_CACHE);
		response.setDateHeader(EXPIRES, 0);
		response.setContentType(IMAGE_JPEG);
	}
	
    /**
     * 功能说明：设置让浏览器弹出下载对话框的Header
     * @author ducc
     * @created 2014年6月16日 上午9:27:04
     * @updated 
     * @param response
     * @param fileName 下载后的文件名
     */
    public static void setFileDownloadHeader(HttpServletResponse response, String fileName) {
        try {
            //中文文件名支持
            String encodedfileName = new String(fileName.getBytes(), "ISO8859-1");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedfileName + "\"");
        } catch (UnsupportedEncodingException e) {
        }
    }
    
    /**
     * 功能说明：设置让浏览器弹出下载对话框的Header
     * @author ducc
     * @created 2014年6月16日 上午9:27:04
     * @updated 
     * @param response
     * @param fileName 下载后的文件名
     * @throws UnsupportedEncodingException 
     */
    public static void setFileDownloadHeader(HttpServletResponse response, String fileName, long fileLength, String fileType) throws UnsupportedEncodingException {
            //中文文件名支持
            String encodedfileName = new String(fileName.getBytes(), "ISO8859-1");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedfileName + "\"");
            response.setHeader("Content-Length", String.valueOf(fileLength));
            response.setContentType(fileType);
    }
}
