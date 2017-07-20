package com.jing.action;

import com.jing.entity.Classes;
import com.jing.service.ClassesService;
import com.opensymphony.xwork2.ActionSupport;

public class ClassesAction extends ActionSupport
{
	private Classes cs;
	public Classes getCs()
	{
		return cs;
	}
	public void setCs(Classes cs)
	{
		this.cs = cs;
	}
	
	private ClassesService csService;
	public void setCsService(ClassesService csService)
	{
		this.csService = csService;
	}
	
	// 保存班级
	public String saveCs()
	{
		String result="";
		if(csService.findById(cs.getCid())==null) //主键不重复
		{
			csService.saveClass(cs);
			result="saveSuccess";
		}
		else
		{
			this.addFieldError("saveError", "班级已存在");
			result="saveFail";
		}
		return result;
	}

	// 删除班级信息
	public String deleteCs()
	{
		String cid = cs.getCid();
		Classes cc = csService.findById(cid);
		csService.deleteClass(cc);
		return "deleteSuccess";
	}

	// 更新班级信息
	public String updateCs()
	{
		csService.updateClass(cs);
		return "updateSuccess";
	}

}
