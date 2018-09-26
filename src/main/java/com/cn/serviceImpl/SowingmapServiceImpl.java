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

import com.cn.dao.TbSowingmapMapper;
import com.cn.pojo.TbSowingmap;
import com.cn.service.SowingmapService;
import com.cn.utils.ApplicationUtils;
import com.cn.utils.BaseResult;
import com.cn.utils.FileUploadUtils;
import com.cn.utils.ResultObject;
@Service
public class SowingmapServiceImpl implements SowingmapService{
	@Resource 
	TbSowingmapMapper sowingmapDao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 新增轮播图
	 */
	@Override
	public BaseResult addSowingmap(HttpServletRequest request,
			HttpServletResponse response, String title,
			String stitle, MultipartFile file) {
		BaseResult result = new BaseResult();
		TbSowingmap sm=new TbSowingmap();
		String id = ApplicationUtils.randomUUID();
		sm.setId(id);
		sm.setTitle(title);
		sm.setStitle(stitle);
		// 上传图片操作
		String picPath = null;
		if (file != null) {
			try {
				picPath = FileUploadUtils.upload(file, request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sm.setPicurl(picPath);
		try {
			int iResult = sowingmapDao.insertSelective(sm);
			if (iResult > 0) {
				logger.info("新增轮播图成功");
				result.setMessage("新增轮播图成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("新增轮播图失败！");
				result.setMessage("新增轮播图失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增轮播图失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public Map<String,Object> getSowingmapListByCondition(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		BaseResult result=new BaseResult();
		try {
			List<TbSowingmap>list=sowingmapDao.getSowingmapLists();
			if(list!=null&&list.size()>=0){
				logger.info("获取轮播图成功");
				result.setMessage("获取轮播图成功");
				result.setStatusCode(1);
				result.setSuccess(true);
				map.put("list",list);
				map.put("result",result);
			}else{
				logger.info("获取轮播图成功！");
				result.setMessage("获取轮播图成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
				map.put("result",result);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增轮播图失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
			map.put("result",result);
		}
		return map;
	}
	@Override
	public ResultObject getSowingmapById(String id) {
		ResultObject result=new ResultObject();
		try {
			TbSowingmap tm=sowingmapDao.selectByPrimaryKey(id);
			if(tm!=null){
				logger.info("获取轮播图成功");
				result.setObj(tm);
				result.setMessage("获取轮播图成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("获取轮播图成功！");
				result.setMessage("获取轮播图成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增轮播图失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
	@Override
	public BaseResult updateSowingmap(HttpServletRequest request,
			HttpServletResponse response, String id, String title,
			String stitle, MultipartFile file) {
		BaseResult result = new BaseResult();
		TbSowingmap sm=sowingmapDao.selectByPrimaryKey(id);
		sm.setTitle(title);
		sm.setStitle(stitle);
		// 上传图片操作
		String picPath = null;
		if (file != null) {
			try {
				picPath = FileUploadUtils.upload(file, request);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		sm.setPicurl(picPath);
		try {
			int iResult = sowingmapDao.updateByPrimaryKey(sm);
			if (iResult > 0) {
				logger.info("修改轮播图成功");
				result.setMessage("修改轮播图成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("修改轮播图失败！");
				result.setMessage("修改轮播图失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，修改轮播图失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public BaseResult deleteSowingmapById(String id) {
		ResultObject result=new ResultObject();
		try {
			int m=sowingmapDao.deleteByPrimaryKey(id);
			if(m>0){
				logger.info("删除轮播图成功");
				result.setMessage("删除轮播图成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("删除轮播图成功！");
				result.setMessage("删除轮播图成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增轮播图失败！", e);
			result.setMessage("删除异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
}
