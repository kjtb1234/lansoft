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

import com.cn.service.CooperateService;
import com.cn.utils.BaseResult;


@Controller
@RequestMapping("cooperateController")
public class CooperateController {
	@Resource CooperateService cooperateService;
	/**
	 * 新增合作伙伴
	 * @param request
	 * @param response
	 * @param href
	 * @param file
	 * @return
	 */
	@RequestMapping("addCooperate")
	@ResponseBody
	public BaseResult addCooperate(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("href")String href,
			@RequestParam("spicUrl") MultipartFile  file) {
		return cooperateService.addCooperate(request,response,href,file );
	}
	/**
	 * 修改合作伙伴
	 * @param request
	 * @param response
	 * @param href
	 * @param file
	 * @return
	 */
	@RequestMapping("updateCooperate")
	@ResponseBody
	public BaseResult updateCooperate(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("id")String id,
			@Param("href")String href,
			@RequestParam("spicUrl") MultipartFile  file) {
		return cooperateService.updateCooperate(request,response,id,href,file );
	}
	/**
	 * 通过id获取合作伙伴
	 * @param id
	 * @return
	 */
	
	@RequestMapping("getCooperateById")
	@ResponseBody
	public BaseResult getCooperateById(
			@Param("id")String id) {
		return cooperateService.getCooperateById(id);
	}
	/**
	 * 删除合作伙伴
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteCooperateById")
	@ResponseBody
	public BaseResult deleteCooperateById(
			@Param("id")String id) {
		return cooperateService.deleteCooperateById(id);
	}
	/**
	 * 获取所有合作伙伴
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getCooperateListByCondition")
	@ResponseBody
	public Map<String,Object> getCooperateListByCondition(
			HttpServletRequest request,
			HttpServletResponse response){
		return cooperateService.getCooperateListByCondition(request, response);
	}
}
