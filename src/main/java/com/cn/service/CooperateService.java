package com.cn.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


public interface CooperateService {


	BaseResult addCooperate(HttpServletRequest request,
			HttpServletResponse response, String href,
			MultipartFile file);

	Map<String,Object> getCooperateListByCondition(HttpServletRequest request,
			HttpServletResponse response);

	BaseResult getCooperateById(String id);

	BaseResult updateCooperate(HttpServletRequest request,
			HttpServletResponse response, String id, String href, MultipartFile file);

	BaseResult deleteCooperateById(String id);

}
