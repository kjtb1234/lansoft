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

import com.cn.service.SowingmapService;
import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


@Controller
@RequestMapping("sowingmapController")
public class SowingmapController {
	@Resource SowingmapService sowingmapService;
	/**
	 * 新增轮播图
	 * @param request
	 * @param response
	 * @param title
	 * @param stitle
	 * @param file
	 * @return
	 */
	@RequestMapping("addSowingmap")
	@ResponseBody
	public BaseResult addSowingmap(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("title")String title,
			@Param("stitle")String stitle,
			@RequestParam("spicUrl") MultipartFile  file) {
		return sowingmapService.addSowingmap(request,response,title,stitle,file );
	}
	/**
	 * 修改轮播图
	 * @param request
	 * @param response
	 * @param title
	 * @param stitle
	 * @param file
	 * @return
	 */
	@RequestMapping("updateSowingmap")
	@ResponseBody
	public BaseResult updateSowingmap(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("id")String id,
			@Param("title")String title,
			@Param("stitle")String stitle,
			@RequestParam("spicUrl") MultipartFile  file) {
		return sowingmapService.updateSowingmap(request,response,id,title,stitle,file );
	}
	/**
	 * 通过id获取轮播图
	 * @param id
	 * @return
	 */
	
	@RequestMapping("getSowingmapById")
	@ResponseBody
	public BaseResult getSowingmapById(
			@Param("id")String id) {
		return sowingmapService.getSowingmapById(id);
	}
	/**
	 * 删除轮播图
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteSowingmapById")
	@ResponseBody
	public BaseResult deleteSowingmapById(
			@Param("id")String id) {
		return sowingmapService.deleteSowingmapById(id);
	}
	/**
	 * 获取所有轮播图
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getSowingmapListByCondition")
	@ResponseBody
	public Map<String,Object> getSowingmapListByCondition(
			HttpServletRequest request,
			HttpServletResponse response){
		return sowingmapService.getSowingmapListByCondition(request, response);
	}
}
