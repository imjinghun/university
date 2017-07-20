package com.jing.action;

import java.util.List;
import java.util.Map;


import org.apache.struts2.interceptor.RequestAware;

import com.jing.entity.NeedTable;
import com.jing.service.INeedService;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class FlAction extends ActionSupport implements RequestAware
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
	
	//学科分类、国民经济行业    代码
	String type,code,rank;
	

	public String getType()
	{
		return type;
	}


	public void setType(String type)
	{
		this.type = type;
	}


	public String getCode()
	{
		return code;
	}


	public void setCode(String code)
	{
		this.code = code;
	}
	

	public String getRank()
	{
		return rank;
	}


	public void setRank(String rank)
	{
		this.rank = rank;
	}


	@Override
	public String execute() throws Exception
	{
		String type=getType();
		String code=getCode();
		String rank=getRank();
		String sql="from NeedTable ";
		
		if(type.equals("subtype")){
				if(rank.equals("one"))
				{
					sql+=" where "+type+" like '%"+code.substring(0,3)+"%'";
				}
				if(rank.equals("two"))
				{
					sql+=" where "+type+" like '%"+code.substring(0,5)+"%'";
				}
				if(rank.equals("three"))
				{
					sql+=" where "+type+" like '%"+code+"%'";
				}
		}	
		if(type.equals("needindustry")){
			if(rank.equals("one"))
			{
				sql+=" where "+type+" like '%"+code.substring(0,1)+"%'";
			}
			if(rank.equals("two"))
			{
				sql+=" where "+type+" like '%"+code.substring(0,3)+"%'";
			}
			if(rank.equals("three"))
			{
				sql+=" where "+type+" like '%"+code+"%'";
			}
		}	
		
		//System.out.println(sql);
		List<NeedTable> list=needService.getListZh(sql);
		
		request.put("listZh", list);
		
		//System.out.println(list.size());
		return SUCCESS;
	}
	
}
