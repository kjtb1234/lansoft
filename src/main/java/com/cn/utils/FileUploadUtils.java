package com.cn.utils;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;


public class FileUploadUtils {
	/**
	 * 文件上传处理
	 * 
	 * @param file
	 *            上传的文件
	 * @param request
	 *            请求
	 * @return
	 * @throws Exception
	 */
	private static Logger logger = LoggerFactory.getLogger(FileUploadUtils.class);
	public static String upload(MultipartFile file, HttpServletRequest request)
			throws Exception {
		// 日期，用于按日生成文件夹
		String dateStr = DateFormatUtils.format(new Date(), "yyyyMMdd");
		// 文件名
		String filename = file.getOriginalFilename();
		// 利用文件名和时间生成UUID
		UUID uuid = UUID
				.nameUUIDFromBytes((System.currentTimeMillis() + filename)
						.getBytes());
		// 文件保存位置
		String url = "uploads\\" + dateStr + "\\" + uuid.toString()
				+ filename.substring(filename.lastIndexOf("."));
		// 请求URL路径 +文件保存位置
		String realPath = request.getSession().getServletContext()
				.getRealPath("\\");
		String pathTemp = realPath;
		if(realPath.lastIndexOf("\\")+1 == realPath.length()){
			pathTemp = pathTemp.substring(0,pathTemp.lastIndexOf("\\"));
		}
		String filePath = pathTemp.substring(0,pathTemp.lastIndexOf("\\"))+"\\lansoft-images\\"
				+ url;
//		String filePath = "e:/program files/apache-tomcat-8.5.16-windows-x64/apache-tomcat/webapps/yqp-images/"+ url;
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(
				filePath));
		return url.replace("\\", "/");
	}
}