package com.cn.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


public interface SloganService {


	BaseResult addSlogan(HttpServletRequest request,
			HttpServletResponse response,String title, String content);

	Map<String,Object> getSloganListByCondition(HttpServletRequest request,
			HttpServletResponse response);

	BaseResult getSloganById(String id);

	BaseResult updateslogan(HttpServletRequest request,
			HttpServletResponse response, String id, String title,
			String content);

	BaseResult deleteSloganById(String id);

}
