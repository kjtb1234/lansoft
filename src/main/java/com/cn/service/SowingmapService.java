package com.cn.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


public interface SowingmapService {


	BaseResult addSowingmap(HttpServletRequest request,
			HttpServletResponse response, String title, String stitle,
			MultipartFile file);

	Map<String,Object> getSowingmapListByCondition(HttpServletRequest request,
			HttpServletResponse response);

	BaseResult getSowingmapById(String id);

	BaseResult updateSowingmap(HttpServletRequest request,
			HttpServletResponse response, String id, String title,
			String stitle, MultipartFile file);

	BaseResult deleteSowingmapById(String id);

}
