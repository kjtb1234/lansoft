package com.cn.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


public interface JoinusService {


	BaseResult addJoinus(HttpServletRequest request,
			HttpServletResponse response, String content);

	Map<String,Object> getJoinusListByCondition(HttpServletRequest request,
			HttpServletResponse response);

	BaseResult getJoinusById(String id);

	BaseResult updateJoinus(HttpServletRequest request,
			HttpServletResponse response, String id,
			String content);

	BaseResult deleteJoinusById(String id);

}
