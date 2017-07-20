package com.jing.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import bean.MD5JM;

import com.jing.entity.UserInfo;
import com.jing.service.IUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<UserInfo>,RequestAware
{
	//封装请求数据
	private UserInfo userInfo = new UserInfo();
	
	@Override
	public UserInfo getModel()
	{
		return userInfo;
	}
	//MD5加密
	private MD5JM md5=new MD5JM();
	private String mm="";
	
	//注入Service
	private IUserService userService;
	public void setUserService(IUserService userService)
	{
		this.userService = userService;
	}
	//登录
	public String login()
	{
		//密码加密
		mm=md5.transMD5(userInfo.getPassword());
		userInfo.setPassword(mm);
		
		String result= userService.login(userInfo);
		if(result.equals("userNoExist"))
		{
			this.addFieldError("user", "用户不存在");
			userInfo.setPassword("");
			//登录失败session用 user
			ActionContext.getContext().getSession().put("user", userInfo);
		}
		if(result.equals("pwdError"))
		{
			this.addFieldError("user", "密码不正确");
			userInfo.setPassword("");
			//登录失败session用 user
			ActionContext.getContext().getSession().put("user", userInfo);
		}
		
		if(!result.equals("userNoExist")&&!result.equals("pwdError"))
		{
			//登录成功session用 user1
			//查出此用户的所有信息 存到session
			UserInfo u=userService.findUser(userInfo);
			ActionContext.getContext().getSession().put("user1", u);
		}
		return result;
	}
	//注册
	public String register()
	{
		//密码加密
		mm=md5.transMD5(userInfo.getPassword());
		userInfo.setPassword(mm);
		
		String result=userService.register(userInfo);
		return result;
	}
	//注册时 ajax判断用户是否已存在
	public String userCheck()
	{
		UserInfo u=userService.findUser(userInfo);
		if(u!=null)
		{
			userInfo.setPowers(u.getPowers());
		}
		return SUCCESS;
	}
	public String updateUser()
	{
		userService.update(userInfo);
		ActionContext.getContext().getSession().put("user1", userInfo);
		return "updateSuccess";
	}
	public String deleteUser()
	{
		String result=userService.delete(userInfo.getUsername());
		return result;
	}
	public String updatePwd()
	{
		//密码加密
		mm=md5.transMD5(userInfo.getPassword());
		userInfo.setPassword(mm);
		userService.update(userInfo);
		ActionContext.getContext().getSession().put("user1", userInfo);
		return "updatePwdS";
	}
	
	//用户列表
	public String userList()
	{
		List<UserInfo> listUser=userService.getUser();
		List<UserInfo> listMgt=userService.getMgt();
		List<UserInfo> listAssessor=userService.getAssessor();
		request.put("listUser", listUser);
		request.put("listMgt", listMgt);
		request.put("listAssessor", listAssessor);
		return "listsuccess";
	}
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
}
