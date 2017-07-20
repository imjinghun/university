package com.jing.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.util.ValueStack;

import com.jing.entity.NeedTable;
import com.jing.entity.UserInfo;
import com.jing.service.INeedService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NeedAction extends ActionSupport implements ModelDriven<NeedTable>, RequestAware
{
	//封装数据
	private NeedTable need=new NeedTable();
	@Override
	public NeedTable getModel()
	{
		return need;
	}

	//注入service
	private INeedService needService;
	public void setNeedService(INeedService needService)
	{
		this.needService = needService;
	}
	
	public String save()
	{
		String result=needService.save(need);
		return result;
	}
	
	//需求更新 审核时 中转
	public String viewUpdate()
	{
		int id=need.getId();
		NeedTable nt=needService.findById(id);
		//获取相应需求信息 存入session
		ActionContext.getContext().getSession().put("nt", nt);
		//得到存在session中的用户
		UserInfo userInfo = (UserInfo) ActionContext.getContext().getSession().get("user1");
		
		String result="";
		if (userInfo.getPowers().equals("users"))
		{
			result = "viewupdateuser";
		} 
		if (userInfo.getPowers().equals("assessor"))
		{
			result = "viewupdateassessor";
		} 
		if (userInfo.getPowers().equals("mgt"))
		{
			result = "viewupdatemgt";
		}
		return result;
	}
	
	//所有用户查看 页面列出的需求的信息
	public String view()
	{
		int id=need.getId();
		NeedTable nt=needService.findById(id);
		ActionContext.getContext().getSession().put("nt", nt);
		return "view";
	}
	public String update()
	{
		String result=needService.update(need);
		return result;
	}
	public String delete()
	{
		String result=needService.delete(need.getId());
		return result;
	}
	
	//所有用户 需求列表 
	public String needListUser()
	{
		List<NeedTable> listNeed=new ArrayList<NeedTable>();
		String result="";
		//得到存在session中的用户
		UserInfo userInfo=(UserInfo)ActionContext.getContext().getSession().get("user1");
		
		if(userInfo.getPowers().equals("users"))
		{
			listNeed=needService.getNeedUser(userInfo.getOrganname());
			result="usersuccess";
		}
		else if(userInfo.getPowers().equals("admin"))
		{
			listNeed=needService.getListAll();
			result="adminsuccess";
		}
		else if(userInfo.getPowers().equals("assessor"))
		{
			listNeed=needService.getListXs();
			result="assessorsuccess";
		}
		else
		{
			listNeed=needService.getListBm(userInfo.getGlbm());
			result="mgtsuccess";
		}
		request.put("listNeed", listNeed);
		return result;
	}

	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
}
