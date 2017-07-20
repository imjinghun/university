package dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetValue
{
	public String getDate()
	{
		Date dt=new Date();
		String date = "",date2="";
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 设置日期格式
		date = df.format(dt);// new Date()为获取当前系统时间
		date2 = df.format(new Date(dt.getTime()+ (long)30 * 24 * 60 * 60 * 1000));// 一个月后的时间
		return date+"#"+date2;
	}
}
