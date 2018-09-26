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

import com.cn.service.BriefaboutusService;
import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


@Controller
@RequestMapping("briefaboutusController")
public class BriefaboutusController {
	@Resource BriefaboutusService briefaboutusService;
	/**
	 * 新增关于我们
	 * @param request
	 * @param response
	 * @param content
	 * @param file
	 * @return
	 */
	@RequestMapping("addBriefaboutus")
	@ResponseBody
	public BaseResult addBriefaboutus(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("content")String content,
			@RequestParam("spicUrl") MultipartFile  file) {
		return briefaboutusService.addBriefaboutus(request,response,content,file );
	}
	/**
	 * 修改关于我们
	 * @param request
	 * @param response
	 * @param title
	 * @param content
	 * @param id
	 * @param detail
	 * @param file
	 * @return
	 */
	@RequestMapping("updateBriefaboutus")
	@ResponseBody
	public BaseResult updateBriefaboutus(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("id")String id,
			@Param("content")String content,
			@RequestParam("spicUrl") MultipartFile  file) {
		return briefaboutusService.updateBriefaboutus(request,response,id,content,file );
	}
	/**
	 * 通过id获取关于我们
	 * @param id
	 * @return
	 */
	
	@RequestMapping("getBriefaboutusById")
	@ResponseBody
	public BaseResult getBriefaboutusById(
			@Param("id")String id) {
		return briefaboutusService.getBriefaboutusById(id);
	}
	/**
	 * 删除关于我们
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteBriefaboutusById")
	@ResponseBody
	public BaseResult deleteBriefaboutusById(
			@Param("id")String id) {
		return briefaboutusService.deleteBriefaboutusById(id);
	}
	/**
	 * 获取所有关于我们
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getBriefaboutusListByCondition")
	@ResponseBody
	public Map<String,Object> getBriefaboutusListByCondition(
			HttpServletRequest request,
			HttpServletResponse response){
		return briefaboutusService.getBriefaboutusListByCondition(request, response);
	}
}
