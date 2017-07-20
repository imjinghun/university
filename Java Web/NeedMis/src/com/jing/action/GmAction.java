package com.jing.action;

import java.util.List;

import com.jing.entity.Gm;
import com.jing.service.IGmService;
import com.opensymphony.xwork2.ActionSupport;

public class GmAction extends ActionSupport 
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

	private List<Gm> list;
	
	public List<Gm> getList()
	{
		return list;
	}

	public void setList(List<Gm> list)
	{
		this.list = list;
	}

	private IGmService GmService;
	public void setGmService(IGmService GmService)
	{
		this.GmService = GmService;
	}
	
	public String listMen()
	{
		list=GmService.getGmMen();
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
	public String listDa()
	{
		list=GmService.getGmDa(code);
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
	public String listZhong()
	{
		list=GmService.getGmZhong(code);
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
