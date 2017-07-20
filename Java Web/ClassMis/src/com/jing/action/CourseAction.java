package com.jing.action;


import com.jing.Dao.CourseDao;
import com.jing.entity.Course;
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
	
	private CourseDao crDao = new CourseDao();
	public CourseDao getCrDao()
	{
		return crDao;
	}
	public void setCrDao(CourseDao crDao)
	{
		this.crDao = crDao;
	}
	
	// 保存课程
	public String saveCr()
	{
		String result="";
		if(crDao.findById(cr.getCrid())==null) //主键不重复
		{
			crDao.saveCourse(cr);
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
		Course cc = crDao.findById(cid);
		crDao.deleteCourse(cc);
		return "deleteSuccess";
	}

	// 更新课程信息
	public String updateCr()
	{
		crDao.updateCourse(cr);
		return "updateSuccess";
	}

}
