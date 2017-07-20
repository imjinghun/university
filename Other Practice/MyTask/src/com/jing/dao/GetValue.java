package com.jing.dao;

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
	/*
	 * SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");//设置日期格式
	 * System.out.println(df.format(new Date()));
	 * 
	 * public String getPkey(ArrayList<String> list) { String pKey="",ch="";
	 * ch=list.get(0).substring(0,3);//获取主键的字母部分
	 * 
	 * int[] num=new int[list.size()];
	 * 
	 * //将list中元素拆分 取出每个元素的数字部分 存到数组num中 for(int i=0;i<list.size();i++) {
	 * num[i]= Integer.parseInt(list.get(i).substring(3)); } //将主键中的数字排序 找最大值
	 * int max=num[0]; for(int i=1;i<num.length;i++) { if(num[i]>max) {
	 * max=num[i]; } } //生成新主键 pKey=ch+(max+1);
	 * 
	 * return pKey; }
	 */
}
