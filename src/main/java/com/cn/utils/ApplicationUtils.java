package com.cn.utils;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * ApplicationUtils : 程序工具类，提供大量的便捷方法
 *
 * @author StarZou
 * @since 2014-09-28 22:31
 */
public class ApplicationUtils {

	/**
	 * 产生一个36个字符的UUID
	 *
	 * @return UUID
	 */
	public static String randomUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}

	/**
	 * md5加密
	 *
	 * @param value
	 *            要加密的值
	 * @return md5加密后的值
	 */
	public static String md5Hex(String value) {
		return DigestUtils.md5Hex(value);
	}

	/**
	 * sha1加密
	 *
	 * @param value
	 *            要加密的值
	 * @return sha1加密后的值
	 */
	public static String sha1Hex(String value) {
		return DigestUtils.sha1Hex(value);
	}

	/**
	 * sha256加密
	 *
	 * @param value
	 *            要加密的值
	 * @return sha256加密后的值
	 */
	public static String sha256Hex(String value) {
		return DigestUtils.sha256Hex(value);
	}
	
	/**
	 * 手机号码中间四位变成星号
	 *
	 * @param value
	 *            要加密的值
	 * @return sha256加密后的值
	 */
	public static String PhoneToStar(String mobile) {
		String str = "";
	    for (int i = 0; i < mobile.length(); i++) {
	        if (i == mobile.length()-11) {
	            str += mobile.charAt(i);
	        }else if(i == mobile.length()-10) {
	        	str += mobile.charAt(i);
	        }else if(i == mobile.length()-9) {
	        	str += mobile.charAt(i);
	        }else if(i == mobile.length()-4) {
	            str += mobile.charAt(i);
	        }else if(i == mobile.length()-3) {
	        	str += mobile.charAt(i);
	        }else if(i == mobile.length()-2) {
	        	str += mobile.charAt(i);
	        }else if(i == mobile.length()-1) {
	        	str += mobile.charAt(i);
	        }else {
	        	str += "*";
	        }
	    } 
	    return str;   
	}
}
