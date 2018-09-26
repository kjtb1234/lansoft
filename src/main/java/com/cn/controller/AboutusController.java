package com.cn.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.service.AboutusService;
import com.cn.utils.BaseResult;


@Controller
@RequestMapping("aboutusController")
public class AboutusController {
	@Resource AboutusService aboutusService;
	/**
	 * 新增关于我们
	 * @param request
	 * @param response
	 * @param title
	 * @param content
	 * @return
	 */
	@RequestMapping("addAboutus")
	@ResponseBody
	public BaseResult addAboutus(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("content")String content) {
		return aboutusService.addAboutus(request,response,content);
	}
	/**
	 * 修改关于我们
	 * @param request
	 * @param response
	 * @param title
	 * @param content
	 * @return
	 */
	@RequestMapping("updateAboutus")
	@ResponseBody
	public BaseResult updateAboutus(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("id")String id,
			@Param("stitle")String content) {
		return aboutusService.updateAboutus(request,response,id,content );
	}
	/**
	 * 通过id获取关于我们
	 * @param id
	 * @return
	 */
	
	@RequestMapping("getAboutusById")
	@ResponseBody
	public BaseResult getAboutusById(
			@Param("id")String id) {
		return aboutusService.getAboutusById(id);
	}
	/**
	 * 删除关于我们
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteAboutusById")
	@ResponseBody
	public BaseResult deleteAboutusById(
			@Param("id")String id) {
		return aboutusService.deleteAboutusById(id);
	}
	/**
	 * 获取所有关于我们
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getAboutusListByCondition")
	@ResponseBody
	public Map<String,Object> getAboutusListByCondition(
			HttpServletRequest request,
			HttpServletResponse response){
		return aboutusService.getAboutusListByCondition(request, response);
	}
}
