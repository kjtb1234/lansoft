package com.cn.controller;

import java.util.Date;
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

import com.cn.service.NewsService;
import com.cn.utils.BaseResult;


@Controller
@RequestMapping("newsController")
public class NewsController {
	@Resource NewsService newsService;
	/**
	 * 新增新闻
	 * @param request
	 * @param response
	 * @param title
	 * @param content
	 * @param ndate
	 * @param file
	 * @return
	 */
	@RequestMapping("addNews")
	@ResponseBody
	public BaseResult addNews(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("title")String title,
			@Param("content")String content,
			@Param("ndate")String ndate) {
		return newsService.addNews(request,response,title,content,ndate);
	}
	/**
	 * 修改新闻
	 * @param request
	 * @param response
	 * @param title
	 * @param content
	 * @param id
	 * @param ndate
	 * @param file
	 * @return
	 */
	@RequestMapping("updateNews")
	@ResponseBody
	public BaseResult updateNews(
			HttpServletRequest request,
			HttpServletResponse response,
			@Param("id")String id,
			@Param("title")String title,
			@Param("content")String content,
			@Param("ndate")String ndate,
			@RequestParam("spicUrl") MultipartFile  file) {
		return newsService.updateNews(request,response,id,title,content,ndate,file );
	}
	/**
	 * 通过id获取新闻
	 * @param id
	 * @return
	 */
	
	@RequestMapping("getNewsById")
	@ResponseBody
	public BaseResult getNewsById(
			@Param("id")String id) {
		return newsService.getNewsById(id);
	}
	/**
	 * 删除新闻
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteNewsById")
	@ResponseBody
	public BaseResult deleteNewsById(
			@Param("id")String id) {
		return newsService.deleteNewsById(id);
	}
	/**
	 * 获取所有新闻
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getNewsListByCondition")
	@ResponseBody
	public Map<String,Object> getNewsListByCondition(
			HttpServletRequest request,
			HttpServletResponse response){
		return newsService.getNewsListByCondition(request, response);
	}
}
