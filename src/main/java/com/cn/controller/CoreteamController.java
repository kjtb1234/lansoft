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

import com.cn.service.CoreteamService;
import com.cn.utils.BaseResult;


@Controller
@RequestMapping("coreteamController")
public class CoreteamController {
	@Resource CoreteamService coreteamService;
	/**
	 * 新增核心团队
	 * @param request
	 * @param response
	 * @param content
	 * @param file
	 * @return
	 */
	@RequestMapping("addCoreteam")
	@ResponseBody
	public BaseResult addCoreteam(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("content")String content,
			@RequestParam("spicUrl") MultipartFile  file) {
		return coreteamService.addCoreteam(request,response,content,file );
	}
	/**
	 * 修改核心团队
	 * @param request
	 * @param response
	 * @param title
	 * @param stitle
	 * @param file
	 * @return
	 */
	@RequestMapping("updateCoreteam")
	@ResponseBody
	public BaseResult updateCoreteam(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("id")String id,
			@Param("content")String content,
			@RequestParam("spicUrl") MultipartFile  file) {
		return coreteamService.updateCoreteam(request,response,id,content,file );
	}
	/**
	 * 通过id获取核心团队
	 * @param id
	 * @return
	 */
	
	@RequestMapping("getCoreteamById")
	@ResponseBody
	public BaseResult getCoreteamById(
			@Param("id")String id) {
		return coreteamService.getCoreteamById(id);
	}
	/**
	 * 删除核心团队
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteCoreteamById")
	@ResponseBody
	public BaseResult deleteCoreteamById(
			@Param("id")String id) {
		return coreteamService.deleteCoreteamById(id);
	}
	/**
	 * 获取所有核心团队
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getCoreteamListByCondition")
	@ResponseBody
	public Map<String,Object> getCoreteamListByCondition(
			HttpServletRequest request,
			HttpServletResponse response){
		return coreteamService.getCoreteamListByCondition(request, response);
	}
}
