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

import com.cn.dao.TbWorkTimeMapper;
import com.cn.pojo.TbWorkTime;
import com.cn.service.WorktimeService;
import com.cn.utils.ApplicationUtils;
import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;
@Service
public class WorktimeServiceImpl implements WorktimeService{
	@Resource 
	TbWorkTimeMapper workTimeDao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 新增工作时间
	 */
	@Override
	public BaseResult addWorktime(HttpServletRequest request,
			HttpServletResponse response,
			String content) {
		BaseResult result = new BaseResult();
		TbWorkTime tm=new TbWorkTime();
		String id = ApplicationUtils.randomUUID();
		tm.setId(id);
		tm.setContent(content);
		try {
			int iResult = workTimeDao.insertSelective(tm);
			if (iResult > 0) {
				logger.info("新增工作时间成功");
				result.setMessage("新增工作时间成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("新增工作时间失败！");
				result.setMessage("新增工作时间失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增工作时间失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public Map<String,Object> getWorktimeListByCondition(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		BaseResult result=new BaseResult();
		try {
			List<TbWorkTime>list=workTimeDao.getWorktimeLists();
			if(list!=null&&list.size()>=0){
				logger.info("获取工作时间成功");
				result.setMessage("获取工作时间成功");
				result.setStatusCode(1);
				result.setSuccess(true);
				map.put("list",list);
				map.put("result",result);
			}else{
				logger.info("获取工作时间成功！");
				result.setMessage("获取工作时间成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
				map.put("result",result);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增工作时间失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
			map.put("result",result);
		}
		return map;
	}
	@Override
	public ResultObject getWorktimeById(String id) {
		ResultObject result=new ResultObject();
		try {
			TbWorkTime tm=workTimeDao.selectByPrimaryKey(id);
			if(tm!=null){
				logger.info("获取工作时间成功");
				result.setObj(tm);
				result.setMessage("获取工作时间成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("获取工作时间成功！");
				result.setMessage("获取工作时间成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增工作时间失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
	@Override
	public BaseResult updateWorktime(HttpServletRequest request,
			HttpServletResponse response, String id,
			String content) {
		BaseResult result = new BaseResult();
		TbWorkTime tm=workTimeDao.selectByPrimaryKey(id);
		tm.setContent(content);
		try {
			int iResult = workTimeDao.updateByPrimaryKeyWithBLOBs(tm);
			if (iResult > 0) {
				logger.info("修改工作时间成功");
				result.setMessage("修改工作时间成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("修改工作时间失败！");
				result.setMessage("修改工作时间失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，修改工作时间失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public BaseResult deleteWorktimeById(String id) {
		ResultObject result=new ResultObject();
		try {
			int m=workTimeDao.deleteByPrimaryKey(id);
			if(m>0){
				logger.info("删除工作时间成功");
				result.setMessage("删除工作时间成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("删除工作时间成功！");
				result.setMessage("删除工作时间成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增工作时间失败！", e);
			result.setMessage("删除异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
}
