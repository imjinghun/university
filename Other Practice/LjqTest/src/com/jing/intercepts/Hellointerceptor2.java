package com.jing.intercepts;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class Hellointerceptor2 implements Interceptor
{

	

	@Override
	public void init()
	{
		System.out.println("第2个拦截器初始化");
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception
	{
		System.out.println("第2个拦截器执行");
		return arg0.invoke();
	}
	
	@Override
	public void destroy()
	{
		System.out.println("第2个拦截器销毁");
	}

}
