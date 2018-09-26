package com.cn.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.service.JoinusService;
import com.cn.utils.BaseResult;


@Controller
@RequestMapping("joinusController")
public class JoinusController {
	@Resource JoinusService joinusService;
	/**
	 * 新增加入我们
	 * @param request
	 * @param response
	 * @param title
	 * @param content
	 * @return
	 */
	@RequestMapping("addJoinus")
	@ResponseBody
	public BaseResult addJoinus(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("content")String content) {
		return joinusService.addJoinus(request,response,content);
	}
	/**
	 * 修改加入我们
	 * @param request
	 * @param response
	 * @param title
	 * @param content
	 * @return
	 */
	@RequestMapping("updateJoinus")
	@ResponseBody
	public BaseResult updateJoinus(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("id")String id,
			@Param("stitle")String content) {
		return joinusService.updateJoinus(request,response,id,content );
	}
	/**
	 * 通过id获取加入我们
	 * @param id
	 * @return
	 */
	
	@RequestMapping("getJoinusById")
	@ResponseBody
	public BaseResult getJoinusById(
			@Param("id")String id) {
		return joinusService.getJoinusById(id);
	}
	/**
	 * 删除加入我们
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteJoinusById")
	@ResponseBody
	public BaseResult deleteJoinusById(
			@Param("id")String id) {
		return joinusService.deleteJoinusById(id);
	}
	/**
	 * 获取所有加入我们
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getJoinusListByCondition")
	@ResponseBody
	public Map<String,Object> getJoinusListByCondition(
			HttpServletRequest request,
			HttpServletResponse response){
		return joinusService.getJoinusListByCondition(request, response);
	}
}
