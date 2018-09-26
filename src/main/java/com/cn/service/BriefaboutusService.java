package com.cn.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


public interface BriefaboutusService {


	BaseResult addBriefaboutus(HttpServletRequest request,
			HttpServletResponse response, String content,
			MultipartFile file);

	Map<String,Object> getBriefaboutusListByCondition(HttpServletRequest request,
			HttpServletResponse response);

	BaseResult getBriefaboutusById(String id);

	BaseResult updateBriefaboutus(HttpServletRequest request,
			HttpServletResponse response, String id,
			String content,MultipartFile file);

	BaseResult deleteBriefaboutusById(String id);

}
