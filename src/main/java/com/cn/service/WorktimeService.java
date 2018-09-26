package com.cn.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.cn.utils.BaseResult;


public interface WorktimeService {


	BaseResult addWorktime(HttpServletRequest request,
			HttpServletResponse response,  String content
			);

	Map<String,Object> getWorktimeListByCondition(HttpServletRequest request,
			HttpServletResponse response);

	BaseResult getWorktimeById(String id);

	BaseResult updateWorktime(HttpServletRequest request,
			HttpServletResponse response, String id,
			String content);

	BaseResult deleteWorktimeById(String id);

}
