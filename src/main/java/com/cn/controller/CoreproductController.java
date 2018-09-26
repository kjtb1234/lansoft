package com.cn.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cn.service.CoreproductService;
import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


@Controller
@RequestMapping("coreproductController")
public class CoreproductController {
	@Resource CoreproductService coreproductService;
	/**
	 * 新增核心产品
	 * @param request
	 * @param response
	 * @param title
	 * @param content
	 * @param detial
	 * @param file
	 * @return
	 */
	@RequestMapping("addCoreproduct")
	@ResponseBody
	public BaseResult addCoreproduct(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("title")String title,
			@Param("content")String content,
			@Param("detial")String detial,
			@RequestParam("spicUrl") MultipartFile  file) {
		return coreproductService.addCoreproduct(request,response,title,content,detial,file );
	}
	/**
	 * 修改核心产品
	 * @param request
	 * @param response
	 * @param title
	 * @param content
	 * @param id
	 * @param detail
	 * @param file
	 * @return
	 */
	@RequestMapping("updateCoreproduct")
	@ResponseBody
	public BaseResult updateCoreproduct(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("id")String id,
			@Param("title")String title,
			@Param("content")String content,
			@Param("detial")String detial,
			@RequestParam("spicUrl") MultipartFile  file) {
		return coreproductService.updateCoreproduct(request,response,id,title,content,detial,file );
	}
	/**
	 * 通过id获取核心产品
	 * @param id
	 * @return
	 */
	
	@RequestMapping("getCoreproductById")
	@ResponseBody
	public BaseResult getCoreproductById(
			@Param("id")String id) {
		return coreproductService.getCoreproductById(id);
	}
	/**
	 * 删除核心产品
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteCoreproductById")
	@ResponseBody
	public BaseResult deleteCoreproductById(
			@Param("id")String id) {
		return coreproductService.deleteCoreproductById(id);
	}
	/**
	 * 获取所有核心产品
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getCoreproductListByCondition")
	@ResponseBody
	public Map<String,Object> getCoreproductListByCondition(
			HttpServletRequest request,
			HttpServletResponse response){
		return coreproductService.getCoreproductListByCondition(request, response);
	}
}
