package com.jing.action;

import java.util.List;

import com.jing.entity.Gk;
import com.jing.service.IGkService;
import com.opensymphony.xwork2.ActionSupport;

public class GkAction extends ActionSupport 
{
	private String code;
	private String title;
	
	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	private List<Gk> list;
	
	public List<Gk> getList()
	{
		return list;
	}

	public void setList(List<Gk> list)
	{
		this.list = list;
	}

	private IGkService GkService;
	public void setGkService(IGkService GkService)
	{
		this.GkService = GkService;
	}
	
	public String listGk()
	{
		list=GkService.getGk();
		String codes="";
		String titles="";
		for(int i=0;i<list.size();i++)
		{
			codes+=list.get(i).getCode()+" ";
			titles+=list.get(i).getTitle()+" ";
		}
		setCode(codes);
		setTitle(titles);
		return SUCCESS;
	}
	
}
