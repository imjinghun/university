package com.jing.action;

import java.util.List;

import com.jing.entity.Xk;
import com.jing.service.IXkService;
import com.opensymphony.xwork2.ActionSupport;

public class XkAction extends ActionSupport 
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

	private List<Xk> list;
	
	public List<Xk> getList()
	{
		return list;
	}

	public void setList(List<Xk> list)
	{
		this.list = list;
	}

	private IXkService xkService;
	public void setXkService(IXkService xkService)
	{
		this.xkService = xkService;
	}
	
	public String listYi()
	{
		list=xkService.getXkYi();
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
	public String listEr()
	{
		list=xkService.getXkEr(code);
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
	public String listSan()
	{
		list=xkService.getXkSan(code);
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
