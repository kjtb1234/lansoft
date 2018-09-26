package com.cn.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


public interface UserinfoService {


	BaseResult addUserinfo(HttpServletRequest request,
			HttpServletResponse response,String username, String telphone,String password);

	Map<String,Object> getUserinfoListByCondition(HttpServletRequest request,
			HttpServletResponse response);

	BaseResult getUserinfoById(String id);

	BaseResult updateUserinfo(HttpServletRequest request,
			HttpServletResponse response, String id,String username, String telphone,String password);

	BaseResult deleteUserinfoById(String id);
	
	ResultObject login(String telphone, String password,
			HttpServletRequest request, HttpServletResponse response);

}
