package com.cn.utils;

public class UnicodeUtil {

	// 字符串转换unicode 
	public static String stringToUnicode(String string) {  
		   
	    StringBuffer unicode = new StringBuffer();  
	    for (int i = 0; i < string.length(); i++) {  
	        // 取出每一个字符  
	        char c = string.charAt(i);  
	        // 转换为unicode  
	        String temp = Integer.toHexString(c);
	        if(temp.length() ==2){
	        	temp = "00"+temp;
	        }
	        unicode.append("\\u" + temp);  
	    }  
	    return unicode.toString();  
	}
	
	//unicode 转字符串 
	public static String unicodeToString(String unicode) {  
	   
	    StringBuffer string = new StringBuffer();  
	    String[] hex = unicode.split("\\\\u");  
	    for (int i = 1; i < hex.length; i++) {  
	        // 转换出每一个代码点  
	        int data = Integer.parseInt(hex[i], 16);  
	        // 追加成string  
	        string.append((char) data);  
	    }  
	    return string.toString();  
	}
	
	public static void main(String[] args) {
		System.out.println("f56sc我是中国人！");
		String temp = UnicodeUtil.stringToUnicode("f56sc我是中国人！");
		System.out.println("编码后："+temp);
		temp =UnicodeUtil.unicodeToString(temp);
		System.out.println("解码后："+temp);
	}
}
