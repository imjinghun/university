package com.jing.action;

import java.util.ArrayList;
import java.util.List;

import com.jing.dao.CourseDao;
import com.jing.dao.GradeDao;
import com.jing.dao.StudentDao;
import com.jing.entity.Course;
import com.jing.entity.Grade;
import com.jing.entity.GradeId;
import com.jing.entity.Student;
import com.jing.service.CourseService;
import com.jing.service.GradeService;
import com.jing.service.StudentService;
import com.opensymphony.xwork2.ActionSupport;

public class GradeAction extends ActionSupport
{
	/*//grade数组
	private Grade[] grades;
	public Grade[] getGrades()
	{
		return grades;
	}
	public void setGrades(Grade[] grades)
	{
		this.grades = grades;
	}
	
	/*private Object[] gid;
	public Object[] getGid()
	{
		return gid;
	}
	public void setGid(Object[] gid)
	{
		this.gid = gid;
	}*/
	
	//获取前台 sid crid gscore 数据 存入数组
	String[] sid,crid;
	String[] gscore;
	
	public String[] getSid()
	{
		return sid;
	}
	public void setSid(String[] sid)
	{
		this.sid = sid;
	}
	public String[] getCrid()
	{
		return crid;
	}
	public void setCrid(String[] crid)
	{
		this.crid = crid;
	}
	public String[] getGscore()
	{
		return gscore;
	}
	public void setGscore(String[] gscore)
	{
		this.gscore = gscore;
	}

	//创建gradeService对象
	private GradeService gradeService;
	public void setGradeService(GradeService gradeService)
	{
		this.gradeService = gradeService;
	}

	// 创建对象
	StudentService stdService;
	CourseService crService;

	public void setStdService(StudentService stdService)
	{
		this.stdService = stdService;
	}

	public void setCrService(CourseService crService)
	{
		this.crService = crService;
	}

	// 保存课程
	public String Xuanke()
	{
		gradeService.saveBatch();
		return "XuankeSuccess";
	}

	
	//保存成绩
	public String saveGrade()
	{
		Student std = new Student();
		Course cr = new Course();
		// Grade GradeId对象
		Grade grade = new Grade();
		GradeId gradeId = new GradeId();
		for(int i=0;i<sid.length;i++)
		{
			//将对象赋值为存入数据库中的值
			std=stdService.findById(sid[i]);
			cr=crService.findById(crid[i]);
			//设置 grade主键
			gradeId.setStudent(std);
			gradeId.setCourse(cr);
			grade.setId(gradeId);
			//设置 成绩
			if(gscore[i]==null||gscore[i].trim().equals(""))
			{
				grade.setGgrade(null);
			}
			else
			{
				double gs=Double.parseDouble(gscore[i]);
				grade.setGgrade(gs);
			}
			//设置grade
			gradeService.saveGrade(grade);
		}
		return "saveSuccess";
	}

	/*// 封装学生id
	private String stdId;

	public String getStdId()
	{
		return stdId;
	}

	public void setStdId(String stdId)
	{
		this.stdId = stdId;
	}*/
}
