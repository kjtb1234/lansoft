package com.cn.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


public interface CallusService {


	BaseResult addCallus(HttpServletRequest request,
			HttpServletResponse response,String address, String telphone,String qq,String email);

	Map<String,Object> getCallusListByCondition(HttpServletRequest request,
			HttpServletResponse response);

	BaseResult getCallusById(String id);

	BaseResult updateCallus(HttpServletRequest request,
			HttpServletResponse response, String id,String address, String telphone,String qq,String email);

	BaseResult deleteCallusById(String id);

}
