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

import com.cn.service.AttentionusService;
import com.cn.utils.BaseResult;


@Controller
@RequestMapping("attentionusController")
public class AttentionusController {
	@Resource 
	AttentionusService attentionusService;
	/**
	 * 新增图片
	 * @param request
	 * @param response
	 * @param file
	 * @return
	 */
	@RequestMapping("addAttentionus")
	@ResponseBody
	public BaseResult addAttentionus(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("spicUrl") MultipartFile  file) {
		return attentionusService.addAttentionus(request,response,file );
	}
	/**
	 * 修改图片
	 * @param request
	 * @param response
	 * @param file
	 * @return
	 */
	@RequestMapping("updateAttentionus")
	@ResponseBody
	public BaseResult updateAttentionus(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("id")String id,
			@RequestParam("spicUrl") MultipartFile  file) {
		return attentionusService.updateAttentionus(request,response,id,file );
	}
	/**
	 * 通过id获取图片
	 * @param id
	 * @return
	 */
	
	@RequestMapping("getAttentionusById")
	@ResponseBody
	public BaseResult getAttentionusById(
			@Param("id")String id) {
		return attentionusService.getAttentionusById(id);
	}
	/**
	 * 删除图片
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteAttentionusById")
	@ResponseBody
	public BaseResult deleteAttentionusById(
			@Param("id")String id) {
		return attentionusService.deleteAttentionusById(id);
	}
	/**
	 * 获取所有图片
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getAttentionusListByCondition")
	@ResponseBody
	public Map<String,Object> getAttentionusListByCondition(
			HttpServletRequest request,
			HttpServletResponse response){
		return attentionusService.getAttentionusListByCondition(request, response);
	}
}
