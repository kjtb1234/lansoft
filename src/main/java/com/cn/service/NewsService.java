package com.cn.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.cn.utils.BaseResult;


public interface NewsService {


	BaseResult addNews(HttpServletRequest request,
			HttpServletResponse response, String title, String content,String ndate
			);

	Map<String,Object> getNewsListByCondition(HttpServletRequest request,
			HttpServletResponse response);

	BaseResult getNewsById(String id);

	BaseResult updateNews(HttpServletRequest request,
			HttpServletResponse response, String id, String title,
			String content,String detial, MultipartFile file);

	BaseResult deleteNewsById(String id);

}
