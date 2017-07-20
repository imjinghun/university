package com.jing.intercepts;

import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport
{
	public HelloAction()
	{
		System.out.println("hellOAction构造函数");
	}
	@Override
	public String execute() throws Exception
	{
		System.out.println("执行了helloaction");
		return SUCCESS;
	}
}
