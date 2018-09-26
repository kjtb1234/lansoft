package com.cn.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


public interface CoreteamService {


	BaseResult addCoreteam(HttpServletRequest request,
			HttpServletResponse response, String content,
			MultipartFile file);

	Map<String,Object> getCoreteamListByCondition(HttpServletRequest request,
			HttpServletResponse response);

	BaseResult getCoreteamById(String id);

	BaseResult updateCoreteam(HttpServletRequest request,
			HttpServletResponse response, String id, String content, MultipartFile file);

	BaseResult deleteCoreteamById(String id);

}
