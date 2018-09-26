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

import com.cn.dao.TbCallUsMapper;
import com.cn.dao.TbSowingmapMapper;
import com.cn.pojo.TbCallUs;
import com.cn.pojo.TbSowingmap;
import com.cn.service.CallusService;
import com.cn.service.SowingmapService;
import com.cn.utils.ApplicationUtils;
import com.cn.utils.BaseResult;
import com.cn.utils.FileUploadUtils;
import com.cn.utils.ResultObject;
@Service
public class CallusServiceImpl implements CallusService{
	@Resource 
	TbCallUsMapper callusDao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 新增联系我们
	 */
	@Override
	public BaseResult addCallus(HttpServletRequest request,
			HttpServletResponse response,String address, String telphone,String qq,String email) {
		BaseResult result = new BaseResult();
		TbCallUs ts=new TbCallUs();
		String id = ApplicationUtils.randomUUID();
		ts.setId(id);
		ts.setAddress(address);
		ts.setTelphone(telphone);
		ts.setQq(qq);
		ts.setEmail(email);
		try {
			int iResult = callusDao.insert(ts);
			if (iResult > 0) {
				logger.info("新增联系我们成功");
				result.setMessage("新增联系我们成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("新增联系我们失败！");
				result.setMessage("新增联系我们失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增联系我们失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public Map<String,Object> getCallusListByCondition(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		BaseResult result=new BaseResult();
		try {
			List<TbCallUs>list=callusDao.getCallusLists();
			if(list!=null&&list.size()>=0){
				logger.info("获取联系我们集合成功");
				result.setMessage("获取联系我们集合成功");
				result.setStatusCode(1);
				result.setSuccess(true);
				map.put("list",list);
				map.put("result",result);
			}else{
				logger.info("获取联系我们集合成功！");
				result.setMessage("获取联系我们集合成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
				map.put("result",result);
			}
		} catch (Exception e) {
			logger.error("网络异常，获取联系我们集合失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
			map.put("result",result);
		}
		return map;
	}
	@Override
	public ResultObject getCallusById(String id) {
		ResultObject result=new ResultObject();
		try {
			TbCallUs ts=callusDao.selectByPrimaryKey(id);
			if(ts!=null){
				logger.info("获取联系我们成功");
				result.setObj(ts);
				result.setMessage("获取联系我们成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("获取联系我们成功！");
				result.setMessage("获取联系我们成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增联系我们失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
	@Override
	public BaseResult updateCallus(HttpServletRequest request,
			HttpServletResponse response, String id, String address, String telphone,String qq,String email) {
		BaseResult result = new BaseResult();
		TbCallUs tb=callusDao.selectByPrimaryKey(id);
		tb.setAddress(address);
		tb.setTelphone(telphone);
		tb.setQq(qq);
		tb.setEmail(email);
		try {
			int iResult = callusDao.updateByPrimaryKey(tb);
			if (iResult > 0) {
				logger.info("修改联系我们成功");
				result.setMessage("修改联系我们成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("修改联系我们失败！");
				result.setMessage("修改联系我们失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，修改联系我们失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public BaseResult deleteCallusById(String id) {
		ResultObject result=new ResultObject();
		try {
			int m=callusDao.deleteByPrimaryKey(id);
			if(m>0){
				logger.info("删除联系我们成功");
				result.setMessage("删除联系我们成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("删除联系我们成功！");
				result.setMessage("删除联系我们成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增联系我们失败！", e);
			result.setMessage("删除异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
	
}
