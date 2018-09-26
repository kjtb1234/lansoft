package com.cn.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


public interface CoreproductService {


	BaseResult addCoreproduct(HttpServletRequest request,
			HttpServletResponse response, String title, String content,String detial,
			MultipartFile file);

	Map<String,Object> getCoreproductListByCondition(HttpServletRequest request,
			HttpServletResponse response);

	BaseResult getCoreproductById(String id);

	BaseResult updateCoreproduct(HttpServletRequest request,
			HttpServletResponse response, String id, String title,
			String content,String detial, MultipartFile file);

	BaseResult deleteCoreproductById(String id);

}
