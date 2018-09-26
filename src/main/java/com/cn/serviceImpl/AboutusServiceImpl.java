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

import com.cn.dao.TbAboutUsMapper;
import com.cn.dao.TbSowingmapMapper;
import com.cn.pojo.TbAboutUs;
import com.cn.pojo.TbSowingmap;
import com.cn.service.AboutusService;
import com.cn.service.AboutusService;
import com.cn.service.SowingmapService;
import com.cn.utils.ApplicationUtils;
import com.cn.utils.BaseResult;
import com.cn.utils.FileUploadUtils;
import com.cn.utils.ResultObject;
@Service
public class AboutusServiceImpl implements AboutusService{
	@Resource 
	TbAboutUsMapper aboutusDao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 新增关于我们
	 */
	@Override
	public BaseResult addAboutus(HttpServletRequest request,
			HttpServletResponse response,String content) {
		BaseResult result = new BaseResult();
		TbAboutUs ts=new TbAboutUs();
		String id = ApplicationUtils.randomUUID();
		ts.setId(id);
		ts.setContent(content);
		try {
			int iResult = aboutusDao.insert(ts);
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
	public Map<String,Object> getAboutusListByCondition(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		BaseResult result=new BaseResult();
		try {
			List<TbAboutUs>list=aboutusDao.getAboutusLists();
			if(list!=null&&list.size()>=0){
				logger.info("获取关于我们集合成功");
				result.setMessage("获取关于我们集合成功");
				result.setStatusCode(1);
				result.setSuccess(true);
				map.put("list",list);
				map.put("result",result);
			}else{
				logger.info("获取关于我们集合成功！");
				result.setMessage("获取关于我们集合成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
				map.put("result",result);
			}
		} catch (Exception e) {
			logger.error("网络异常，获取关于我们集合失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
			map.put("result",result);
		}
		return map;
	}
	@Override
	public ResultObject getAboutusById(String id) {
		ResultObject result=new ResultObject();
		try {
			TbAboutUs ts=aboutusDao.selectByPrimaryKey(id);
			if(ts!=null){
				logger.info("获取关于我们成功");
				result.setObj(ts);
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
	public BaseResult updateAboutus(HttpServletRequest request,
			HttpServletResponse response, String id,
			String content) {
		BaseResult result = new BaseResult();
		TbAboutUs tb=aboutusDao.selectByPrimaryKey(id);
		tb.setContent(content);
		try {
			int iResult = aboutusDao.updateByPrimaryKey(tb);
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
	public BaseResult deleteAboutusById(String id) {
		ResultObject result=new ResultObject();
		try {
			int m=aboutusDao.deleteByPrimaryKey(id);
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
