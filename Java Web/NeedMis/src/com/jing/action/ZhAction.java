package com.jing.action;

import java.util.List;
import java.util.Map;


import org.apache.struts2.interceptor.RequestAware;

import com.jing.entity.NeedTable;
import com.jing.service.INeedService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class ZhAction extends ActionSupport implements RequestAware
{
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	// 注入service
	private INeedService needService;

	public void setNeedService(INeedService needService)
	{
		this.needService = needService;
	}
	
	//and or ， 字段，精确模糊，值，通不通过
	String sel0,sel2,sel3,inputvalue,sel4;
	public String getSel0()
	{
		return sel0;
	}
	public void setSel0(String sel0)
	{
		this.sel0 = sel0;
	}
	public String getSel2()
	{
		return sel2;
	}
	public void setSel2(String sel2)
	{
		this.sel2 = sel2;
	}
	public String getSel3()
	{
		return sel3;
	}
	public void setSel3(String sel3)
	{
		this.sel3 = sel3;
	}
	public String getInputvalue()
	{
		return inputvalue;
	}
	public void setInputvalue(String inputvalue)
	{
		this.inputvalue = inputvalue;
	}
	public String getSel4()
	{
		return sel4;
	}
	public void setSel4(String sel4)
	{
		this.sel4 = sel4;
	}

	@Override
	public String execute() throws Exception
	{
		/*System.out.println(getSel0());
		System.out.println(getSel2());
		System.out.println(getSel3());
		System.out.println(getSel4());
		System.out.println(getInputvalue());*/
		
		//将字符串转换为jsonarray
		JSONArray jsel0 = JSONArray.fromObject(getSel0());
		JSONArray jsel2 = JSONArray.fromObject(getSel2());
		JSONArray jsel3 = JSONArray.fromObject(getSel3());
		JSONArray jiv = JSONArray.fromObject(getInputvalue());
		String s4=getSel4();
		
		String sql="from NeedTable";
		int length=jsel2.size();
		if(jsel3.getString(0).equals("jingque"))
		{
			sql+=" where ( "+jsel2.getString(0)+"='"+jiv.getString(0)+"'";
		}
		if(jsel3.getString(0).equals("mohu"))
		{
			sql+=" where ( "+jsel2.getString(0)+" like '%"+jiv.getString(0)+"%'";
		}
		for(int i=1;i<length;i++)
		{
			if(jsel3.getString(i).equals("jingque"))
			{
				sql+=" "+jsel0.getString(i-1)+" "+jsel2.getString(i)+"='"+jiv.getString(i)+"' ";
			}
			if(jsel3.getString(i).equals("mohu"))
			{
				sql+=" "+jsel0.getString(i-1)+" "+jsel2.getString(i)+" like '%"+jiv.getString(i)+"%' ";
			}
		}
		sql+=" ) and states like '%"+s4+"%' and states !='未提交' ";
		if(s4.equals("通过"))
		{
			sql+=" and states not like '%未通过%'";
		}
		
		//System.out.println(sql);
		List<NeedTable> list=needService.getListZh(sql);
		
		request.put("listZh", list);
		
		//System.out.println(list.size());
		return SUCCESS;
	}
	
}
