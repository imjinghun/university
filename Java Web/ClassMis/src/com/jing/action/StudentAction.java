package com.jing.action;

import com.jing.Dao.ClassesDao;
import com.jing.Dao.StudentDao;
import com.jing.entity.Classes;
import com.jing.entity.Student;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport
{
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
	
	//学生Dao
	private StudentDao stdDao = new StudentDao();
	public StudentDao getStdDao()
	{
		return stdDao;
	}
	public void setStdDao(StudentDao stdDao)
	{
		this.stdDao = stdDao;
	}
	//班级Dao
	private ClassesDao csDao = new ClassesDao();
	public ClassesDao getCsDao()
	{
		return csDao;
	}
	public void setCsDao(ClassesDao csDao)
	{
		this.csDao = csDao;
	}

	//登录
	public String login()
	{
		Student student=stdDao.findById(std.getSid());
		Student student2=stdDao.findByStd(std);
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
		Student student=stdDao.findById(std.getSid());
		if(student!=null)
		{
			result="saveFail";
			this.addFieldError("saveError", "学号重复");
		}
		else
		{
			Classes classes=csDao.findById(classid);
			if(classes!=null)
			{
				std.setClasses(classes);
				stdDao.saveStd(std);
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
		Student ss=stdDao.findById(sid);
		stdDao.deleteStd(ss);
		return "deleteSuccess";
	}
	
	//更新学生信息
	public String updateStd()
	{
		String result="";
		Classes classes=csDao.findById(classid);
		if(classes!=null)
		{
			std.setClasses(classes);
			stdDao.updateStd(std);
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
