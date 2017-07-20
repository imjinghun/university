package com.jing.action;

import com.jing.entity.Course;
import com.jing.service.CourseService;
import com.opensymphony.xwork2.ActionSupport;

public class CourseAction extends ActionSupport
{
	private Course cr;
	public Course getCr()
	{
		return cr;
	}
	public void setCr(Course cr)
	{
		this.cr = cr;
	}
	
	private CourseService crService;
	public void setCrService(CourseService crService)
	{
		this.crService = crService;
	}
	
	// 保存课程
	public String saveCr()
	{
		String result="";
		if(crService.findById(cr.getCrid())==null) //主键不重复
		{
			crService.saveCourse(cr);
			result="saveSuccess";
		}
		else
		{
			this.addFieldError("saveError", "课程已存在");
			result="saveFail";
		}
		return result;
	}

	// 删除课程信息
	public String deleteCr()
	{
		String cid = cr.getCrid();
		Course cc = crService.findById(cid);
		crService.deleteCourse(cc);
		return "deleteSuccess";
	}

	// 更新课程信息
	public String updateCr()
	{
		crService.updateCourse(cr);
		return "updateSuccess";
	}

}
