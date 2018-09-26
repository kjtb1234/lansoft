package com.cn.utils;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;

import org.codehaus.jackson.map.ObjectMapper;

public class TransType {
	//获取今天的日期
	public static String getTodayDate(){
		Format fo = new SimpleDateFormat("yyyy-MM-dd");
        return fo.format(new Date());
	} 
	//获取今年
	public static String getTodayYear(){
		Format fo = new SimpleDateFormat("yyyy");
        return fo.format(new Date());
	} 
	
	// 数据库时间转化成标准时间，类型为String 年月日
		public static String dateToString(Date date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(date);
		}
	// 数据库时间转化成标准时间，类型为String 年月日时分秒
	public static String getStandardDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	// 数据库时间转化成标准时间，类型为String 年月日时分秒
	public static String getStandardDateHh(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
		return sdf.format(date);
	}
	//将String 转换成DATE 
	public static Date getDateByString(String s){
		java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = formatter.parse(s);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	//将String 转换成DATE 
	public static Date getDateByString1(String s){
		java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = formatter.parse(s);
			return date;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	//将String 转换成DATE 
		public static Date getDateByString2(String s){
			java.text.SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			try {
				Date date = formatter.parse(s);
				return date;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			
		}
	
	//获取当前时间
	public static Date getToday(){	
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dt = df.format(new Date());
		return getDateByString1(dt);
	}
	//获取当前时间String
	public static String getTodayString() {
	        Format fo = new SimpleDateFormat("yyyyMMddHHmmssms");
	        return fo.format(new Date());
	}
	//获取传入参数时间String
	public static String getParamString(Date d) {
		        Format fo = new SimpleDateFormat("yyyyMMddHHmmssms");
		        return fo.format(d);
	}
	/**
	 * 获取当前时间 年月日时分秒
	 * @return
	 */
	public static Date getCurrentTime(){		
		Date date=new Date(System.currentTimeMillis());
		return date;
	}

	public static Date StringToDate(String str){
		 try {
			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(str);
			return date;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
	
	 /** 
     * 获得指定日期的后一天 
     *  
     * @param specifiedDay 
     * @return 
     */
	public static Date getDayAfter(String specifiedDay) {  
        Calendar c = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day + 1);  
  
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd")  
                .format(c.getTime());  
        return java.sql.Date.valueOf(dayAfter);  
    }  
    
	//将List<String>转换成JSONArray
	public JSONArray getJsonByListString(List<String> lists){
		JSONArray jsonString = JSONArray.fromObject(lists);
		return jsonString;
	}
	

	// 实体类、List、Map等类型转成json类型的String
	public static String objectToJson(Object obj) throws JSONException,
			IOException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(obj);
		return jsonStr;
	}
}
