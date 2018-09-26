package com.cn.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.service.CallusService;
import com.cn.utils.BaseResult;


@Controller
@RequestMapping("callusController")
public class CallusController {
	@Resource CallusService callusService;
	/**
	 * 新增联系我们
	 * @param request
	 * @param response
	 * @param address
	 * @param telphone
	 * @param qq
	 * @param email
	 * @return
	 */
	@RequestMapping("addCallus")
	@ResponseBody
	public BaseResult addCallus(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("address")String address,
			@Param("telphone")String telphone,
			@Param("qq")String qq,
			@Param("email")String email) {
		return callusService.addCallus(request,response,address,telphone,qq,email);
	}
	/**
	 * 修改联系我们
	* @param request
	 * @param response
	 * @param address
	 * @param telphone
	 * @param qq
	 * @param email
	 * @return
	 */
	@RequestMapping("updateCallus")
	@ResponseBody
	public BaseResult updateCallus(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("id")String id,
			@Param("address")String address,
			@Param("telphone")String telphone,
			@Param("qq")String qq,
			@Param("email")String email) {
		return callusService.updateCallus(request,response,id,address,telphone,qq,email);
	}
	/**
	 * 通过id获取联系我们
	 * @param id
	 * @return
	 */
	
	@RequestMapping("getCallusById")
	@ResponseBody
	public BaseResult getCallusById(
			@Param("id")String id) {
		return callusService.getCallusById(id);
	}
	/**
	 * 删除联系我们
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteCallusById")
	@ResponseBody
	public BaseResult deleteCallusById(
			@Param("id")String id) {
		return callusService.deleteCallusById(id);
	}
	/**
	 * 获取所有联系我们
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getCallusListByCondition")
	@ResponseBody
	public Map<String,Object> getCallusListByCondition(
			HttpServletRequest request,
			HttpServletResponse response){
		return callusService.getCallusListByCondition(request, response);
	}
}
