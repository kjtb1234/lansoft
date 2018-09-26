package com.cn.utils;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BaseResult implements Serializable {

	/**
	 * 信息
	 */
	private String message;

	/**
	 * 状态码
	 */
	private int statusCode;

	/**
	 * 是否成功
	 */
	private boolean success;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
