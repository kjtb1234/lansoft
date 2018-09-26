package com.cn.controller;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.service.WorktimeService;
import com.cn.utils.BaseResult;


@Controller
@RequestMapping("worktimeController")
public class WorktimeController {
	@Resource WorktimeService worktimeService;
	/**
	 * 新增工作时间
	 * @param request
	 * @param response
	 * @param content
	 * @return
	 */
	@RequestMapping("addWorktime")
	@ResponseBody
	public BaseResult addWorktime(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("content")String content) {
		return worktimeService.addWorktime(request,response,content);
	}
	/**
	 * 修改工作时间
	 * @param request
	 * @param response
	 * @param content
	 * @param id
	 * @return
	 */
	@RequestMapping("updateWorktime")
	@ResponseBody
	public BaseResult updateWorktime(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("id")String id,
			@Param("content")String content) {
		return worktimeService.updateWorktime(request,response,id,content);
	}
	/**
	 * 通过id获取工作时间
	 * @param id
	 * @return
	 */
	
	@RequestMapping("getWorktimeById")
	@ResponseBody
	public BaseResult getWorktimeById(
			@Param("id")String id) {
		return worktimeService.getWorktimeById(id);
	}
	/**
	 * 删除工作时间
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteWorktimeById")
	@ResponseBody
	public BaseResult deleteWorktimeById(
			@Param("id")String id) {
		return worktimeService.deleteWorktimeById(id);
	}
	/**
	 * 获取所有工作时间
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getWorktimeListByCondition")
	@ResponseBody
	public Map<String,Object> getWorktimeListByCondition(
			HttpServletRequest request,
			HttpServletResponse response){
		return worktimeService.getWorktimeListByCondition(request, response);
	}
}
