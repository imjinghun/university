package dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetValue
{
	DBBean db = new DBBean();

	// 设置作业号
	public String getHid()
	{
		String hid = "";
		hid = getPkey("zy");
		return hid;
	}

	// 设置留言号
	public String getMid()
	{
		String mid = "";
		mid = getPkey("ly");
		return mid;
	}

	// 设置课程号
	public String getCid()
	{
		String cid="";
		cid=getPkey("kc");
		return cid;
	}
	
	// 设置资料号
	public String getMtid()
	{
		String mtid="";
		mtid=getPkey("mt");
		return mtid;
	}
	/*// 设置学生资料号
	public String getSmid()
	{
		String smid="";
		smid=getPkey("sm");
		return smid;
	}
	
	// 设置老师资料号
	public String getTmid()
	{
		String tmid = "";
		tmid = getPkey("tm");
		return tmid;
	}*/
		
	// 获取系统当前时间
	public String getDate()
	{
		String date = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");// 设置日期格式
		date = df.format(new Date());// new Date()为获取当前系统时间
		return date;
	}

	// 生成各个主键 type为不同的类别
	public String getPkey(String type)
	{
		String pKey = "";
		String time = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");// 设置日期格式
		time = df.format(new Date());
		pKey = type + time;
		return pKey;
	}
}
