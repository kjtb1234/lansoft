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

import com.cn.dao.TbBriefAboutUsMapper;
import com.cn.pojo.TbBriefAboutUs;
import com.cn.service.BriefaboutusService;
import com.cn.utils.ApplicationUtils;
import com.cn.utils.BaseResult;
import com.cn.utils.FileUploadUtils;
import com.cn.utils.ResultObject;
@Service
public class BriefaboutusServiceImpl implements BriefaboutusService{
	@Resource 
	TbBriefAboutUsMapper briefaboutusDao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 新增关于我们
	 */
	@Override
	public BaseResult addBriefaboutus(HttpServletRequest request,
			HttpServletResponse response,
			String content,MultipartFile file) {
		BaseResult result = new BaseResult();
		TbBriefAboutUs tm=new TbBriefAboutUs();
		String id = ApplicationUtils.randomUUID();
		tm.setId(id);
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
			int iResult = briefaboutusDao.insertSelective(tm);
			if (iResult > 0) {
				logger.info("新增关于我们成功");
				result.setMessage("新增关于我们成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("新增关于我们失败！");
				result.setMessage("新增关于我们失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增关于我们失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public Map<String,Object> getBriefaboutusListByCondition(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		BaseResult result=new BaseResult();
		try {
			List<TbBriefAboutUs>list=briefaboutusDao.getBriefaboutusLists();
			if(list!=null&&list.size()>=0){
				logger.info("获取关于我们成功");
				result.setMessage("获取关于我们成功");
				result.setStatusCode(1);
				result.setSuccess(true);
				map.put("list",list);
				map.put("result",result);
			}else{
				logger.info("获取关于我们成功！");
				result.setMessage("获取关于我们成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
				map.put("result",result);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增关于我们失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
			map.put("result",result);
		}
		return map;
	}
	@Override
	public ResultObject getBriefaboutusById(String id) {
		ResultObject result=new ResultObject();
		try {
			TbBriefAboutUs tm=briefaboutusDao.selectByPrimaryKey(id);
			if(tm!=null){
				logger.info("获取关于我们成功");
				result.setObj(tm);
				result.setMessage("获取关于我们成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("获取关于我们成功！");
				result.setMessage("获取关于我们成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增关于我们失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
	@Override
	public BaseResult updateBriefaboutus(HttpServletRequest request,
			HttpServletResponse response, String id,
			String content,MultipartFile file) {
		BaseResult result = new BaseResult();
		TbBriefAboutUs tm=briefaboutusDao.selectByPrimaryKey(id);
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
			int iResult = briefaboutusDao.updateByPrimaryKeyWithBLOBs(tm);
			if (iResult > 0) {
				logger.info("修改关于我们成功");
				result.setMessage("修改关于我们成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("修改关于我们失败！");
				result.setMessage("修改关于我们失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，修改关于我们失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public BaseResult deleteBriefaboutusById(String id) {
		ResultObject result=new ResultObject();
		try {
			int m=briefaboutusDao.deleteByPrimaryKey(id);
			if(m>0){
				logger.info("删除关于我们成功");
				result.setMessage("删除关于我们成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("删除关于我们成功！");
				result.setMessage("删除关于我们成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增关于我们失败！", e);
			result.setMessage("删除异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
}
