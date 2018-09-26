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

import com.cn.dao.TbSloganMapper;
import com.cn.dao.TbSowingmapMapper;
import com.cn.pojo.TbSlogan;
import com.cn.pojo.TbSowingmap;
import com.cn.service.SloganService;
import com.cn.service.SowingmapService;
import com.cn.utils.ApplicationUtils;
import com.cn.utils.BaseResult;
import com.cn.utils.FileUploadUtils;
import com.cn.utils.ResultObject;
@Service
public class SloganServiceImpl implements SloganService{
	@Resource 
	TbSloganMapper sloganDao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 新增口号
	 */
	@Override
	public BaseResult addSlogan(HttpServletRequest request,
			HttpServletResponse response,String title, String content) {
		BaseResult result = new BaseResult();
		TbSlogan ts=new TbSlogan();
		String id = ApplicationUtils.randomUUID();
		ts.setId(id);
		ts.setTitle(title);
		ts.setContent(content);
		try {
			int iResult = sloganDao.insert(ts);
			if (iResult > 0) {
				logger.info("新增口号成功");
				result.setMessage("新增口号成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("新增口号失败！");
				result.setMessage("新增口号失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增口号失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public Map<String,Object> getSloganListByCondition(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		BaseResult result=new BaseResult();
		try {
			List<TbSlogan>list=sloganDao.getSloganLists();
			if(list!=null&&list.size()>=0){
				logger.info("获取口号集合成功");
				result.setMessage("获取口号集合成功");
				result.setStatusCode(1);
				result.setSuccess(true);
				map.put("list",list);
				map.put("result",result);
			}else{
				logger.info("获取口号集合成功！");
				result.setMessage("获取口号集合成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
				map.put("result",result);
			}
		} catch (Exception e) {
			logger.error("网络异常，获取口号集合失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
			map.put("result",result);
		}
		return map;
	}
	@Override
	public ResultObject getSloganById(String id) {
		ResultObject result=new ResultObject();
		try {
			TbSlogan ts=sloganDao.selectByPrimaryKey(id);
			if(ts!=null){
				logger.info("获取口号成功");
				result.setObj(ts);
				result.setMessage("获取口号成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("获取口号成功！");
				result.setMessage("获取口号成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增口号失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
	@Override
	public BaseResult updateslogan(HttpServletRequest request,
			HttpServletResponse response, String id, String title,
			String content) {
		BaseResult result = new BaseResult();
		TbSlogan tb=sloganDao.selectByPrimaryKey(id);
		tb.setTitle(title);
		tb.setContent(content);
		try {
			int iResult = sloganDao.updateByPrimaryKey(tb);
			if (iResult > 0) {
				logger.info("修改口号成功");
				result.setMessage("修改口号成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("修改口号失败！");
				result.setMessage("修改口号失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，修改口号失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public BaseResult deleteSloganById(String id) {
		ResultObject result=new ResultObject();
		try {
			int m=sloganDao.deleteByPrimaryKey(id);
			if(m>0){
				logger.info("删除口号成功");
				result.setMessage("删除口号成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("删除口号成功！");
				result.setMessage("删除口号成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增口号失败！", e);
			result.setMessage("删除异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
	
}
