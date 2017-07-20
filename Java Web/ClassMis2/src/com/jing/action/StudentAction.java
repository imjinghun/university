package com.jing.action;

import com.jing.dao.ClassesDao;
import com.jing.dao.StudentDao;
import com.jing.entity.Classes;
import com.jing.entity.Student;
import com.jing.service.ClassesService;
import com.jing.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport
{
	//封装数据
	private Student std;
	public Student getStd()
	{
		return std;
	}
	public void setStd(Student std)
	{
		this.std = std;
	}
	
	private String classid;
	public String getClassid()
	{
		return classid;
	}
	public void setClassid(String classid)
	{
		this.classid = classid;
	}
	
	//注入Service
	private StudentService stdService;
	public void setStdService(StudentService stdService)
	{
		this.stdService = stdService;
	}
	//班级Service
	private ClassesService csService;
	public void setCsService(ClassesService csService)
	{
		this.csService = csService;
	}

	//登录
	public String login()
	{
		Student student=stdService.findById(std.getSid());
		Student student2=stdService.findByStd(std);
		if(student==null)
		{
			this.addFieldError("loginError", "学号不存在");
			return "loginFail";
		}
		else if(student2==null)
		{
			this.addFieldError("loginError", "密码不正确");
			return "loginFail";
		}
		else
		{
			return "loginSuccess";
		}
	}
	//注册 添加学生信息
	public String register()
	{
		String result="";
		Student student=stdService.findById(std.getSid());
		if(student!=null)
		{
			result="saveFail";
			this.addFieldError("saveError", "学号重复");
		}
		else
		{
			Classes classes=csService.findById(classid);
			if(classes!=null)
			{
				std.setClasses(classes);
				stdService.saveStd(std);
				result="saveSuccess";
			}
			else
			{
				this.addFieldError("saveError", "班级不存在");
				result="saveFail";
			}
		}
		return result;
	}
	
	//删除学生信息
	public String deleteStd()
	{
		String sid=std.getSid();
		Student ss=stdService.findById(sid);
		stdService.deleteStd(ss);
		return "deleteSuccess";
	}
	
	//更新学生信息
	public String updateStd()
	{
		String result="";
		Classes classes=csService.findById(classid);
		if(classes!=null)
		{
			std.setClasses(classes);
			stdService.updateStd(std);
			result="updateSuccess";
		}
		else
		{
			this.addFieldError("updError", "班级不存在");
			result="updateFail";
		}
		return result;
	}
}
