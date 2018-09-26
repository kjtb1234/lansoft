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

import com.cn.dao.TbUserInfoMapper;
import com.cn.pojo.TbUserInfo;
import com.cn.service.UserinfoService;
import com.cn.utils.ApplicationUtils;
import com.cn.utils.BaseResult;
import com.cn.utils.ResultObject;
@Service
public class UserinfoServiceImpl implements UserinfoService{
	@Resource 
	TbUserInfoMapper userinfoDao;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 新增用户
	 */
	@Override
	public BaseResult addUserinfo(HttpServletRequest request,
			HttpServletResponse response,String username, String telphone,String password) {
		BaseResult result = new BaseResult();
		TbUserInfo ts=new TbUserInfo();
		String id = ApplicationUtils.randomUUID();
		ts.setId(id);
		ts.setUsername(username);
		ts.setTelphone(telphone);
		ts.setPassword(password);
		try {
			int iResult = userinfoDao.insert(ts);
			if (iResult > 0) {
				logger.info("新增用户成功");
				result.setMessage("新增用户成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("新增用户失败！");
				result.setMessage("新增用户失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增用户失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public Map<String,Object> getUserinfoListByCondition(
			HttpServletRequest request, HttpServletResponse response) {
		Map<String,Object> map=new HashMap<String,Object>();
		BaseResult result=new BaseResult();
		try {
			List<TbUserInfo>list=userinfoDao.getUserinfoLists();
			if(list!=null&&list.size()>=0){
				logger.info("获取用户集合成功");
				result.setMessage("获取用户集合成功");
				result.setStatusCode(1);
				result.setSuccess(true);
				map.put("list",list);
				map.put("result",result);
			}else{
				logger.info("获取用户集合成功！");
				result.setMessage("获取用户集合成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
				map.put("result",result);
			}
		} catch (Exception e) {
			logger.error("网络异常，获取用户集合失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
			map.put("result",result);
		}
		return map;
	}
	@Override
	public ResultObject getUserinfoById(String id) {
		ResultObject result=new ResultObject();
		try {
			TbUserInfo ts=userinfoDao.selectByPrimaryKey(id);
			if(ts!=null){
				logger.info("获取用户成功");
				result.setObj(ts);
				result.setMessage("获取用户成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("获取用户成功！");
				result.setMessage("获取用户成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增用户失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
	@Override
	public BaseResult updateUserinfo(HttpServletRequest request,
			HttpServletResponse response, String id, String username, String telphone,String password) {
		BaseResult result = new BaseResult();
		TbUserInfo tb=userinfoDao.selectByPrimaryKey(id);
		tb.setUsername(username);
		tb.setTelphone(telphone);
		tb.setPassword(password);
		try {
			int iResult = userinfoDao.updateByPrimaryKey(tb);
			if (iResult > 0) {
				logger.info("修改用户成功");
				result.setMessage("修改用户成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			} else {
				logger.info("修改用户失败！");
				result.setMessage("修改用户失败！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，修改用户失败！", e);
			result.setMessage("网络异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return  result;
	}
	@Override
	public BaseResult deleteUserinfoById(String id) {
		ResultObject result=new ResultObject();
		try {
			int m=userinfoDao.deleteByPrimaryKey(id);
			if(m>0){
				logger.info("删除用户成功");
				result.setMessage("删除用户成功");
				result.setStatusCode(1);
				result.setSuccess(true);
			}else{
				logger.info("删除用户成功！");
				result.setMessage("删除用户成功！");
				result.setStatusCode(0);
				result.setSuccess(false);
			}
		} catch (Exception e) {
			logger.error("网络异常，新增用户失败！", e);
			result.setMessage("删除异常！请稍后重试");
			result.setStatusCode(0);
			result.setSuccess(false);
		}
		return result;
	}
	/**
	 * @Description 通过手机号和密码登录
	 * @param telPhone
	 * @param password
	 * @param request
	 * @param response
	 * @return
	 * @throws
	 */
	@Override
	public ResultObject login(String telphone, String password,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ResultObject returnValue = new ResultObject();
		try {
			TbUserInfo userinfo = userinfoDao.validateLogin(telphone);
			if (userinfo == null) {
				returnValue.setMessage("手机号不存在");
				returnValue.setStatusCode(0);
				returnValue.setSuccess(false);
				logger.info(telphone + "手机号不存在");
				return returnValue;
			}
			TbUserInfo record = new TbUserInfo();
			record.setTelphone(telphone);
			record.setPassword(password);
			record = userinfoDao.selectByPhoneAndPass(record);
			if (record != null) {
				returnValue.setMessage("登录成功");
				returnValue.setStatusCode(1);
				returnValue.setSuccess(true);
				returnValue.setObj(record);
				logger.info(telphone + ":" + password + "登录成功");
			} else {
				returnValue.setMessage("密码错误");
				returnValue.setStatusCode(0);
				returnValue.setSuccess(false);
				logger.info(telphone + ":" + password + "密码错误");
			}
		} catch (Exception e) {
			returnValue.setMessage("网络异常，请稍后再试");
			returnValue.setStatusCode(0);
			returnValue.setSuccess(false);
			logger.error("网络异常，请稍后再试", e);
		}
		return returnValue;
	}
}
