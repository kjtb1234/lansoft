package com.cn.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


public interface MaindirectionService {


	BaseResult addMaindirection(HttpServletRequest request,
			HttpServletResponse response, String title, String content,
			MultipartFile file);

	Map<String,Object> getMaindirectionListByCondition(HttpServletRequest request,
			HttpServletResponse response);

	BaseResult getMaindirectionById(String id);

	BaseResult updateMaindirection(HttpServletRequest request,
			HttpServletResponse response, String id, String title,
			String content, MultipartFile file);

	BaseResult deleteMaindirectionById(String id);

}
