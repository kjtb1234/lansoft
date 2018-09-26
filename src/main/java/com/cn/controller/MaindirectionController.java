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

import com.cn.service.MaindirectionService;
import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


@Controller
@RequestMapping("maindirectionController")
public class MaindirectionController {
	@Resource MaindirectionService maindirectionService;
	/**
	 * 新增主要方向
	 * @param request
	 * @param response
	 * @param title
	 * @param content
	 * @param file
	 * @return
	 */
	@RequestMapping("addMaindirection")
	@ResponseBody
	public BaseResult addMaindirection(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("title")String title,
			@Param("content")String content,
			@RequestParam("spicUrl") MultipartFile  file) {
		return maindirectionService.addMaindirection(request,response,title,content,file );
	}
	/**
	 * 修改主要方向
	 * @param request
	 * @param response
	 * @param title
	 * @param content
	 * @param file
	 * @return
	 */
	@RequestMapping("updateMaindirection")
	@ResponseBody
	public BaseResult updateMaindirection(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("id")String id,
			@Param("title")String title,
			@Param("content")String content,
			@RequestParam("spicUrl") MultipartFile  file) {
		return maindirectionService.updateMaindirection(request,response,id,title,content,file );
	}
	/**
	 * 通过id获取主要方向
	 * @param id
	 * @return
	 */
	
	@RequestMapping("getMaindirectionById")
	@ResponseBody
	public BaseResult getMaindirectionById(
			@Param("id")String id) {
		return maindirectionService.getMaindirectionById(id);
	}
	/**
	 * 删除主要方向
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteMaindirectionById")
	@ResponseBody
	public BaseResult deleteMaindirectionById(
			@Param("id")String id) {
		return maindirectionService.deleteMaindirectionById(id);
	}
	/**
	 * 获取所有主要方向
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getMaindirectionListByCondition")
	@ResponseBody
	public Map<String,Object> getMaindirectionListByCondition(
			HttpServletRequest request,
			HttpServletResponse response){
		return maindirectionService.getMaindirectionListByCondition(request, response);
	}
}
