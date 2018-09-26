package com.cn.serviceImpl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cn.dao.TbMainDirectionMapper;
import com.cn.dao.TbSowingmapMapper;
import com.cn.pojo.TbMainDirection;
import com.cn.pojo.TbSowingmap;
import com.cn.service.MaindirectionService;
import com.cn.service.SowingmapService;
import com.cn.utils.ApplicationUtils;
import com.cn.utils.BaseResult;
import com.cn.utils.FileUploadUtils;
import com.cn.utils.ResultObject;
@Service
public class MaindirectionServiceImpl implements MaindirectionService{
	@Resource 
	TbMainDirectionMapper maindirectionDao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 新增主要方向
	 */
	@Override
	public BaseResult addMaindirection(HttpServletRequest request,
			HttpServletResponse response, String title,
			String content, MultipartFile file) {
		BaseResult result = new BaseResult();
		TbMainDirection tm=new TbMainDirection();
		String id = ApplicationUtils.randomUUID();
		tm.setId(id);
		tm.setTitle(title);
		tm.setContent(content);
		// 上传图片操作
		String picPath = null;
		if (file != null) {
			try {
				picPath = FileUploadUtils.upload(file, request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		tm.setPicurl(picPath);
		try {
			int iResult = maindirectionDao.insertSelective(tm);
			if (iResult > 0) {
				logger.info("新增主要方向成功");
				result.setMessage("新增主要方向成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("新增主要方向失败！");
				result.setMessage("新增主要方向失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增主要方向失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public Map<String,Object> getMaindirectionListByCondition(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		BaseResult result=new BaseResult();
		try {
			List<TbMainDirection>list=maindirectionDao.getMainDirectionLists();
			if(list!=null&&list.size()>=0){
				logger.info("获取主要方向成功");
				result.setMessage("获取主要方向成功");
				result.setStatusCode(1);
				result.setSuccess(true);
				map.put("list",list);
				map.put("result",result);
			}else{
				logger.info("获取主要方向成功！");
				result.setMessage("获取主要方向成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
				map.put("result",result);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增主要方向失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
			map.put("result",result);
		}
		return map;
	}
	@Override
	public ResultObject getMaindirectionById(String id) {
		ResultObject result=new ResultObject();
		try {
			TbMainDirection tm=maindirectionDao.selectByPrimaryKey(id);
			if(tm!=null){
				logger.info("获取主要方向成功");
				result.setObj(tm);
				result.setMessage("获取主要方向成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("获取主要方向成功！");
				result.setMessage("获取主要方向成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增主要方向失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
	@Override
	public BaseResult updateMaindirection(HttpServletRequest request,
			HttpServletResponse response, String id, String title,
			String content, MultipartFile file) {
		BaseResult result = new BaseResult();
		TbMainDirection tm=maindirectionDao.selectByPrimaryKey(id);
		tm.setTitle(title);
		tm.setContent(content);
		// 上传图片操作
		String picPath = null;
		if (file != null) {
			try {
				picPath = FileUploadUtils.upload(file, request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		tm.setPicurl(picPath);
		try {
			int iResult = maindirectionDao.updateByPrimaryKey(tm);
			if (iResult > 0) {
				logger.info("修改主要方向成功");
				result.setMessage("修改主要方向成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("修改主要方向失败！");
				result.setMessage("修改主要方向失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，修改主要方向失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public BaseResult deleteMaindirectionById(String id) {
		ResultObject result=new ResultObject();
		try {
			int m=maindirectionDao.deleteByPrimaryKey(id);
			if(m>0){
				logger.info("删除主要方向成功");
				result.setMessage("删除主要方向成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("删除主要方向成功！");
				result.setMessage("删除主要方向成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增主要方向失败！", e);
			result.setMessage("删除异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
}
