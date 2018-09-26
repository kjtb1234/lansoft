package com.cn.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


public interface AttentionusService {


	BaseResult addAttentionus(HttpServletRequest request,
			HttpServletResponse response,
			MultipartFile file);

	Map<String,Object> getAttentionusListByCondition(HttpServletRequest request,
			HttpServletResponse response);

	BaseResult getAttentionusById(String id);

	BaseResult updateAttentionus(HttpServletRequest request,
			HttpServletResponse response, String id, MultipartFile file);

	BaseResult deleteAttentionusById(String id);

}
