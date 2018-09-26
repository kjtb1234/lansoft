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

import com.cn.dao.TbCoreProductMapper;
import com.cn.pojo.TbCoreProduct;
import com.cn.service.CoreproductService;
import com.cn.utils.ApplicationUtils;
import com.cn.utils.BaseResult;
import com.cn.utils.FileUploadUtils;
import com.cn.utils.ResultObject;
@Service
public class CoreproductServiceImpl implements CoreproductService{
	@Resource 
	TbCoreProductMapper coreproductDao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 新增核心产品
	 */
	@Override
	public BaseResult addCoreproduct(HttpServletRequest request,
			HttpServletResponse response, String title,
			String content,String detial, MultipartFile file) {
		BaseResult result = new BaseResult();
		TbCoreProduct tm=new TbCoreProduct();
		String id = ApplicationUtils.randomUUID();
		tm.setId(id);
		tm.setTitle(title);
		tm.setContent(content);
		tm.setRetail(detial);
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
			int iResult = coreproductDao.insertSelective(tm);
			if (iResult > 0) {
				logger.info("新增核心产品成功");
				result.setMessage("新增核心产品成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("新增核心产品失败！");
				result.setMessage("新增核心产品失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增核心产品失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public Map<String,Object> getCoreproductListByCondition(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		BaseResult result=new BaseResult();
		try {
			List<TbCoreProduct>list=coreproductDao.getCoreproductLists();
			if(list!=null&&list.size()>=0){
				logger.info("获取核心产品成功");
				result.setMessage("获取核心产品成功");
				result.setStatusCode(1);
				result.setSuccess(true);
				map.put("list",list);
				map.put("result",result);
			}else{
				logger.info("获取核心产品成功！");
				result.setMessage("获取核心产品成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
				map.put("result",result);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增核心产品失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
			map.put("result",result);
		}
		return map;
	}
	@Override
	public ResultObject getCoreproductById(String id) {
		ResultObject result=new ResultObject();
		try {
			TbCoreProduct tm=coreproductDao.selectByPrimaryKey(id);
			if(tm!=null){
				logger.info("获取核心产品成功");
				result.setObj(tm);
				result.setMessage("获取核心产品成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("获取核心产品成功！");
				result.setMessage("获取核心产品成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增核心产品失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
	@Override
	public BaseResult updateCoreproduct(HttpServletRequest request,
			HttpServletResponse response, String id, String title,
			String content,String detial, MultipartFile file) {
		BaseResult result = new BaseResult();
		TbCoreProduct tm=coreproductDao.selectByPrimaryKey(id);
		tm.setTitle(title);
		tm.setContent(content);
		tm.setRetail(detial);
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
			int iResult = coreproductDao.updateByPrimaryKeyWithBLOBs(tm);
			if (iResult > 0) {
				logger.info("修改核心产品成功");
				result.setMessage("修改核心产品成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("修改核心产品失败！");
				result.setMessage("修改核心产品失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，修改核心产品失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public BaseResult deleteCoreproductById(String id) {
		ResultObject result=new ResultObject();
		try {
			int m=coreproductDao.deleteByPrimaryKey(id);
			if(m>0){
				logger.info("删除核心产品成功");
				result.setMessage("删除核心产品成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("删除核心产品成功！");
				result.setMessage("删除核心产品成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增核心产品失败！", e);
			result.setMessage("删除异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
}
