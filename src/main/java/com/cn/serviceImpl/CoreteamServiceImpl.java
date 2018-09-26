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

import com.cn.dao.TbCoreTeamMapper;
import com.cn.dao.TbCoreTeamMapper;
import com.cn.pojo.TbCoreTeam;
import com.cn.service.CoreteamService;
import com.cn.utils.ApplicationUtils;
import com.cn.utils.BaseResult;
import com.cn.utils.FileUploadUtils;
import com.cn.utils.ResultObject;
@Service
public class CoreteamServiceImpl implements CoreteamService{
	@Resource 
	TbCoreTeamMapper coreteamDao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 新增核心团队
	 */
	@Override
	public BaseResult addCoreteam(HttpServletRequest request,
			HttpServletResponse response, String content, MultipartFile file) {
		BaseResult result = new BaseResult();
		TbCoreTeam sm=new TbCoreTeam();
		String id = ApplicationUtils.randomUUID();
		sm.setId(id);
		sm.setContent(content);
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
			int iResult = coreteamDao.insertSelective(sm);
			if (iResult > 0) {
				logger.info("新增核心团队成功");
				result.setMessage("新增核心团队成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("新增核心团队失败！");
				result.setMessage("新增核心团队失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增核心团队失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public Map<String,Object> getCoreteamListByCondition(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		BaseResult result=new BaseResult();
		try {
			List<TbCoreTeam>list=coreteamDao.getCoreteamLists();
			if(list!=null&&list.size()>=0){
				logger.info("获取核心团队成功");
				result.setMessage("获取核心团队成功");
				result.setStatusCode(1);
				result.setSuccess(true);
				map.put("list",list);
				map.put("result",result);
			}else{
				logger.info("获取核心团队成功！");
				result.setMessage("获取核心团队成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
				map.put("result",result);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增核心团队失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
			map.put("result",result);
		}
		return map;
	}
	@Override
	public ResultObject getCoreteamById(String id) {
		ResultObject result=new ResultObject();
		try {
			TbCoreTeam tm=coreteamDao.selectByPrimaryKey(id);
			if(tm!=null){
				logger.info("获取核心团队成功");
				result.setObj(tm);
				result.setMessage("获取核心团队成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("获取核心团队成功！");
				result.setMessage("获取核心团队成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增核心团队失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
	@Override
	public BaseResult updateCoreteam(HttpServletRequest request,
			HttpServletResponse response, String id, String content, MultipartFile file) {
		BaseResult result = new BaseResult();
		TbCoreTeam sm=coreteamDao.selectByPrimaryKey(id);
		sm.setContent(content);
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
			int iResult = coreteamDao.updateByPrimaryKey(sm);
			if (iResult > 0) {
				logger.info("修改核心团队成功");
				result.setMessage("修改核心团队成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("修改核心团队失败！");
				result.setMessage("修改核心团队失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，修改核心团队失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public BaseResult deleteCoreteamById(String id) {
		ResultObject result=new ResultObject();
		try {
			int m=coreteamDao.deleteByPrimaryKey(id);
			if(m>0){
				logger.info("删除核心团队成功");
				result.setMessage("删除核心团队成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("删除核心团队成功！");
				result.setMessage("删除核心团队成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增核心团队失败！", e);
			result.setMessage("删除异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
}
