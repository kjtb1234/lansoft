package com.cn.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.service.UserinfoService;
import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;


@Controller
@RequestMapping("userinfoController")
public class UserinfoController {
	@Resource UserinfoService userinfoService;
	/**
	 * 新增用户
	 * @param request
	 * @param response
	 * @param username
	 * @param telphone
	 * @param password
	 * @return
	 */
	@RequestMapping("addUserinfo")
	@ResponseBody
	public BaseResult addUserinfo(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("username")String username,
			@Param("telphone")String telphone,
			@Param("password")String password
			) {
		return userinfoService.addUserinfo(request,response,username,telphone,password);
	}
	/**
	 * 修改用户
	* @param request
	 * @param response
	 * @param username
	 * @param telphone
	 * @param id
	 * @param password
	 * @return
	 */
	@RequestMapping("updateUserinfo")
	@ResponseBody
	public BaseResult updateUserinfo(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("id")String id,
			@Param("username")String username,
			@Param("telphone")String telphone,
			@Param("password")String password) {
		return userinfoService.updateUserinfo(request,response,id,username,telphone,password);
	}
	/**
	 * 通过id获取用户
	 * @param id
	 * @return
	 */
	
	@RequestMapping("getUserinfoById")
	@ResponseBody
	public BaseResult getUserinfoById(
			@Param("id")String id) {
		return userinfoService.getUserinfoById(id);
	}
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteUserinfoById")
	@ResponseBody
	public BaseResult deleteUserinfoById(
			@Param("id")String id) {
		return userinfoService.deleteUserinfoById(id);
	}
	/**
	 * 获取所有用户
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getUserinfoListByCondition")
	@ResponseBody
	public Map<String,Object> getUserinfoListByCondition(
			HttpServletRequest request,
			HttpServletResponse response){
		return userinfoService.getUserinfoListByCondition(request, response);
	}
	/**
	 * @Description 通过手机号和密码登录
	 * @param telphone
	 * @param password
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping("login.do")
	public ResultObject login(@RequestParam("telphone") String telphone,
			@RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		return userinfoService.login(telphone, password, request,
				response);
	}
}
