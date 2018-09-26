package com.cn.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


public interface AboutusService {


	BaseResult addAboutus(HttpServletRequest request,
			HttpServletResponse response, String content);

	Map<String,Object> getAboutusListByCondition(HttpServletRequest request,
			HttpServletResponse response);

	BaseResult getAboutusById(String id);

	BaseResult updateAboutus(HttpServletRequest request,
			HttpServletResponse response, String id,
			String content);

	BaseResult deleteAboutusById(String id);

}
