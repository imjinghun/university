package com.jing.action;

import java.util.ArrayList;
import java.util.List;

import com.jing.Dao.CourseDao;
import com.jing.Dao.GradeDao;
import com.jing.Dao.StudentDao;
import com.jing.entity.Course;
import com.jing.entity.Grade;
import com.jing.entity.GradeId;
import com.jing.entity.Student;
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

	//创建gradeDao对象
	private GradeDao gradeDao = new GradeDao();
	public void setGradeDao(GradeDao gradeDao)
	{
		this.gradeDao = gradeDao;
	}
	public GradeDao getGradeDao()
	{
		return gradeDao;
	}
	
	// 保存课程
	public String Xuanke()
	{
		gradeDao.saveBatch();
		return "XuankeSuccess";
	}

	// 创建对象
	StudentDao stdDao = new StudentDao();
	CourseDao crDao = new CourseDao();
	Student std = new Student();
	Course cr = new Course();
	// Grade GradeId对象
	Grade grade = new Grade();
	GradeId gradeId = new GradeId();
	//保存成绩
	public String saveGrade()
	{
		for(int i=0;i<sid.length;i++)
		{
			//将对象赋值为存入数据库中的值
			std=stdDao.findById(sid[i]);
			cr=crDao.findById(crid[i]);
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
			gradeDao.saveGrade(grade);
		}
		return "saveSuccess";
	}

	// 封装学生id
	private String stdId;

	public String getStdId()
	{
		return stdId;
	}

	public void setStdId(String stdId)
	{
		this.stdId = stdId;
	}
	
	/*//统计某一学生所修课程信息、汇总学分、不及格课程（标红）
	public String xsInfo()
	{
		*//**
		 *  根据学号 得到student std对象
		 *  根据std 在gradeDao中查找
		 *//*
		List<GradeId> list=new ArrayList<GradeId>();
		
		std=stdDao.findById(stdId);
		if(std!=null)
		{
			list=gradeDao.xsInfo(std);
			System.out.println(list.size());
			for(int i=0;i<list.size();i++)
			{
				System.out.println(list.get(i).getStudent().getSid()+" "
						+list.get(i).getCourse().getCrid()+" ");
			}
		}
		return "xsSuccess";
	}
	*/
	
}
