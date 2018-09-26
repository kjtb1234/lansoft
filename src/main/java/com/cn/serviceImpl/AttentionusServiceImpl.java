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

import com.cn.dao.TbAttentionUsMapper;
import com.cn.pojo.TbAttentionUs;
import com.cn.service.AttentionusService;
import com.cn.utils.ApplicationUtils;
import com.cn.utils.BaseResult;
import com.cn.utils.FileUploadUtils;
import com.cn.utils.ResultObject;
@Service
public class AttentionusServiceImpl implements AttentionusService{
	@Resource 
	TbAttentionUsMapper attentionusDao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 新增图片
	 */
	@Override
	public BaseResult addAttentionus(HttpServletRequest request,
			HttpServletResponse response, MultipartFile file) {
		BaseResult result = new BaseResult();
		TbAttentionUs sm=new TbAttentionUs();
		String id = ApplicationUtils.randomUUID();
		sm.setId(id);
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
			int iResult = attentionusDao.insertSelective(sm);
			if (iResult > 0) {
				logger.info("新增图片成功");
				result.setMessage("新增图片成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("新增图片失败！");
				result.setMessage("新增图片失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增图片失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public Map<String,Object> getAttentionusListByCondition(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		BaseResult result=new BaseResult();
		try {
			List<TbAttentionUs>list=attentionusDao.getAttentionusLists();
			if(list!=null&&list.size()>=0){
				logger.info("获取图片成功");
				result.setMessage("获取图片成功");
				result.setStatusCode(1);
				result.setSuccess(true);
				map.put("list",list);
				map.put("result",result);
			}else{
				logger.info("获取图片成功！");
				result.setMessage("获取图片成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
				map.put("result",result);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增图片失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
			map.put("result",result);
		}
		return map;
	}
	@Override
	public ResultObject getAttentionusById(String id) {
		ResultObject result=new ResultObject();
		try {
			TbAttentionUs tm=attentionusDao.selectByPrimaryKey(id);
			if(tm!=null){
				logger.info("获取图片成功");
				result.setObj(tm);
				result.setMessage("获取图片成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("获取图片成功！");
				result.setMessage("获取图片成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增图片失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
	@Override
	public BaseResult updateAttentionus(HttpServletRequest request,
			HttpServletResponse response, String id, MultipartFile file) {
		BaseResult result = new BaseResult();
		TbAttentionUs sm=attentionusDao.selectByPrimaryKey(id);
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
			int iResult = attentionusDao.updateByPrimaryKey(sm);
			if (iResult > 0) {
				logger.info("修改图片成功");
				result.setMessage("修改图片成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("修改图片失败！");
				result.setMessage("修改图片失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，修改图片失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public BaseResult deleteAttentionusById(String id) {
		ResultObject result=new ResultObject();
		try {
			int m=attentionusDao.deleteByPrimaryKey(id);
			if(m>0){
				logger.info("删除图片成功");
				result.setMessage("删除图片成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("删除图片成功！");
				result.setMessage("删除图片成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增图片失败！", e);
			result.setMessage("删除异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
}
