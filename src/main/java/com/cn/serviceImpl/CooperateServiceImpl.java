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

import com.cn.dao.TbCooperateMapper;
import com.cn.dao.TbCooperateMapper;
import com.cn.dao.TbCooperateMapper;
import com.cn.pojo.TbCooperate;
import com.cn.service.CooperateService;
import com.cn.utils.ApplicationUtils;
import com.cn.utils.BaseResult;
import com.cn.utils.FileUploadUtils;
import com.cn.utils.ResultObject;
@Service
public class CooperateServiceImpl implements CooperateService{
	@Resource 
	TbCooperateMapper cooperateDao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 新增合作伙伴
	 */
	@Override
	public BaseResult addCooperate(HttpServletRequest request,
			HttpServletResponse response, String href, MultipartFile file) {
		BaseResult result = new BaseResult();
		TbCooperate sm=new TbCooperate();
		String id = ApplicationUtils.randomUUID();
		sm.setId(id);
		sm.setHref(href);
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
			int iResult = cooperateDao.insertSelective(sm);
			if (iResult > 0) {
				logger.info("新增合作伙伴成功");
				result.setMessage("新增合作伙伴成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("新增合作伙伴失败！");
				result.setMessage("新增合作伙伴失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增合作伙伴失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public Map<String,Object> getCooperateListByCondition(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		BaseResult result=new BaseResult();
		try {
			List<TbCooperate>list=cooperateDao.getCooperateLists();
			if(list!=null&&list.size()>=0){
				logger.info("获取合作伙伴成功");
				result.setMessage("获取合作伙伴成功");
				result.setStatusCode(1);
				result.setSuccess(true);
				map.put("list",list);
				map.put("result",result);
			}else{
				logger.info("获取合作伙伴成功！");
				result.setMessage("获取合作伙伴成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
				map.put("result",result);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增合作伙伴失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
			map.put("result",result);
		}
		return map;
	}
	@Override
	public ResultObject getCooperateById(String id) {
		ResultObject result=new ResultObject();
		try {
			TbCooperate tm=cooperateDao.selectByPrimaryKey(id);
			if(tm!=null){
				logger.info("获取合作伙伴成功");
				result.setObj(tm);
				result.setMessage("获取合作伙伴成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("获取合作伙伴成功！");
				result.setMessage("获取合作伙伴成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增合作伙伴失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
	@Override
	public BaseResult updateCooperate(HttpServletRequest request,
			HttpServletResponse response, String id, String href, MultipartFile file) {
		BaseResult result = new BaseResult();
		TbCooperate sm=cooperateDao.selectByPrimaryKey(id);
		sm.setHref(href);
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
			int iResult = cooperateDao.updateByPrimaryKey(sm);
			if (iResult > 0) {
				logger.info("修改合作伙伴成功");
				result.setMessage("修改合作伙伴成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("修改合作伙伴失败！");
				result.setMessage("修改合作伙伴失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，修改合作伙伴失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public BaseResult deleteCooperateById(String id) {
		ResultObject result=new ResultObject();
		try {
			int m=cooperateDao.deleteByPrimaryKey(id);
			if(m>0){
				logger.info("删除合作伙伴成功");
				result.setMessage("删除合作伙伴成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("删除合作伙伴成功！");
				result.setMessage("删除合作伙伴成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增合作伙伴失败！", e);
			result.setMessage("删除异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
}
