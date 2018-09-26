package com.cn.serviceImpl;


import java.util.Date;
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
import org.w3.x2000.x09.xmldsig.TransformType;

import com.cn.dao.TbNewsMapper;
import com.cn.dao.TbNewsMapper;
import com.cn.pojo.TbNews;
import com.cn.pojo.TbNews;
import com.cn.service.NewsService;
import com.cn.utils.ApplicationUtils;
import com.cn.utils.BaseResult;
import com.cn.utils.FileUploadUtils;
import com.cn.utils.ResultObject;
import com.cn.utils.TransType;
@Service
public class NewsServiceImpl implements NewsService{
	@Resource 
	TbNewsMapper newsDao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 新增新闻
	 */
	@Override
	public BaseResult addNews(HttpServletRequest request,
			HttpServletResponse response, String title,
			String content,String ndate) {
		BaseResult result = new BaseResult();
		TbNews tm=new TbNews();
		String id = ApplicationUtils.randomUUID();
		tm.setId(id);
		tm.setTitle(title);
		tm.setContent(content);
		tm.setNdate(TransType.getDateByString(ndate));
		try {
			int iResult = newsDao.insertSelective(tm);
			if (iResult > 0) {
				logger.info("新增新闻成功");
				result.setMessage("新增新闻成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("新增新闻失败！");
				result.setMessage("新增新闻失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增新闻失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public Map<String,Object> getNewsListByCondition(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		BaseResult result=new BaseResult();
		try {
			List<TbNews>list=newsDao.getNewsLists();
			if(list!=null&&list.size()>=0){
				logger.info("获取新闻成功");
				result.setMessage("获取新闻成功");
				result.setStatusCode(1);
				result.setSuccess(true);
				map.put("list",list);
				map.put("result",result);
			}else{
				logger.info("获取新闻成功！");
				result.setMessage("获取新闻成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
				map.put("result",result);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增新闻失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
			map.put("result",result);
		}
		return map;
	}
	@Override
	public ResultObject getNewsById(String id) {
		ResultObject result=new ResultObject();
		try {
			TbNews tm=newsDao.selectByPrimaryKey(id);
			if(tm!=null){
				logger.info("获取新闻成功");
				result.setObj(tm);
				result.setMessage("获取新闻成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("获取新闻成功！");
				result.setMessage("获取新闻成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增新闻失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
	@Override
	public BaseResult updateNews(HttpServletRequest request,
			HttpServletResponse response, String id, String title,
			String content,String ndate, MultipartFile file) {
		BaseResult result = new BaseResult();
		TbNews tm=newsDao.selectByPrimaryKey(id);
		tm.setTitle(title);
		tm.setContent(content);
		tm.setNdate(TransType.getDateByString1(ndate));
		try {
			int iResult = newsDao.updateByPrimaryKeyWithBLOBs(tm);
			if (iResult > 0) {
				logger.info("修改新闻成功");
				result.setMessage("修改新闻成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("修改新闻失败！");
				result.setMessage("修改新闻失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，修改新闻失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public BaseResult deleteNewsById(String id) {
		ResultObject result=new ResultObject();
		try {
			int m=newsDao.deleteByPrimaryKey(id);
			if(m>0){
				logger.info("删除新闻成功");
				result.setMessage("删除新闻成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("删除新闻成功！");
				result.setMessage("删除新闻成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增新闻失败！", e);
			result.setMessage("删除异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
}
