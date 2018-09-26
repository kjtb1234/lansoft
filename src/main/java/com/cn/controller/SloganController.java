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

import com.cn.service.SloganService;
import com.cn.service.SowingmapService;
import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


@Controller
@RequestMapping("sloganController")
public class SloganController {
	@Resource SloganService sloganService;
	/**
	 * 新增口号
	 * @param request
	 * @param response
	 * @param title
	 * @param content
	 * @return
	 */
	@RequestMapping("addSlogan")
	@ResponseBody
	public BaseResult addSlogan(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("title")String title,
			@Param("content")String content) {
		return sloganService.addSlogan(request,response,title,content);
	}
	/**
	 * 修改口号
	 * @param request
	 * @param response
	 * @param title
	 * @param content
	 * @return
	 */
	@RequestMapping("updateslogan")
	@ResponseBody
	public BaseResult updateslogan(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("id")String id,
			@Param("title")String title,
			@Param("stitle")String content) {
		return sloganService.updateslogan(request,response,id,title,content );
	}
	/**
	 * 通过id获取口号
	 * @param id
	 * @return
	 */
	
	@RequestMapping("getSloganById")
	@ResponseBody
	public BaseResult getSloganById(
			@Param("id")String id) {
		return sloganService.getSloganById(id);
	}
	/**
	 * 删除口号
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteSloganById")
	@ResponseBody
	public BaseResult deleteSloganById(
			@Param("id")String id) {
		return sloganService.deleteSloganById(id);
	}
	/**
	 * 获取所有口号
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getSloganListByCondition")
	@ResponseBody
	public Map<String,Object> getSloganListByCondition(
			HttpServletRequest request,
			HttpServletResponse response){
		return sloganService.getSloganListByCondition(request, response);
	}
}
