package com.jing.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import com.jing.entity.Course;
import com.jing.entity.Grade;
import com.jing.entity.GradeId;
import com.jing.entity.Student;

public class GradeDao
{
	//注入sessionFactory
	private SessionFactory sessionFactory ;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	private CourseDao crDao;
	private StudentDao stdDao;
	public void setCrDao(CourseDao crDao)
	{
		this.crDao = crDao;
	}

	public void setStdDao(StudentDao stdDao)
	{
		this.stdDao = stdDao;
	}

	//批量插入学生课程信息
	public void saveBatch()
	{
		// 获取所有学生 课程 信息
		List<Student> std = stdDao.listStd();
		List<Course> cr = crDao.listCr();

		// 创建grade和grade主键对象
		Grade grade = new Grade();
		GradeId gid = new GradeId();

		// 获取学生 课程集合的长度
		int stdL = std.size();
		int crL = cr.size();
		try
		{
			// 使用循环 让每个学生选所有课程 保存到grade数据表
			for (int i = 0; i < stdL; i++)
			{
				// set Student属性
				gid.setStudent(std.get(i));
				
				for (int j = 0; j < crL; j++)
				{
					// set Course属性
					gid.setCourse(cr.get(j));
					grade.setId(gid);
					// 保存到grade表 
					if(findbyId(gid)==null)
					{
						// set Grade表主键属性
						sessionFactory.getCurrentSession().save(grade);
						//解决只能插入最后一条的问题
						//强制更新到数据库
						sessionFactory.getCurrentSession().flush();
						//清除一级缓存
						sessionFactory.getCurrentSession().clear();
					}
				}
			}
		} catch (Exception e)
		{
			System.out.println("保存课程学生信息出异常");
			e.printStackTrace();
		} 
	}

	// 更新 保存成绩
	public void saveGrade(Grade grade)
	{
		try
		{
			sessionFactory.getCurrentSession().update(grade);
		} catch (Exception e)
		{
			System.out.println("更新成绩出异常");
			e.printStackTrace();
		} 
	}
	//查找 grade表中信息是否存在
	public Grade findbyId(GradeId id)
	{
		Grade grade = new Grade();
		try
		{
			// 查找
			grade = (Grade) sessionFactory.getCurrentSession().get(Grade.class, id);
		} catch (Exception e)
		{
			System.out.println("根据主键查找grade信息异常");
			e.printStackTrace();
		} 
		return grade;
	}
	//统计学生课程信息
	@SuppressWarnings("unchecked")
	public List<Grade> listGrade()
	{
		List<Grade> grade=new ArrayList<Grade>();
		grade= sessionFactory.getCurrentSession().createQuery("from Grade").list();
		return grade;
	}
	//统计课程最高分 最低分 平均分
	@SuppressWarnings("unchecked")
	public List<Object[]> listCG()
	{
		List<Object[]> list=sessionFactory.getCurrentSession() //
				.createQuery("select g.id.course.crid,g.id.course.crname,"+ //
		"max(g.ggrade),min(g.ggrade),avg(g.ggrade) from Grade g,Course c "+ //
		"where g.id.course.crid=c.crid group by g.id.course.crid,g.id.course.crname").list();
		return list;
	}
	//统计学生课程信息 汇总学分 不及格课程标红
	@SuppressWarnings("unchecked")
	public List<Object[]> listXC(String sid)
	{
		List<Object[]> list=sessionFactory.getCurrentSession() //
				.createQuery("select s.sname,c.crid,c.crname,c.crcredit,g.ggrade from "+//
						"Student s,Course c,Grade g where s.sid=g.id.student.sid and c.crid=g.id.course.crid and s.sid=?")//
						.setParameter(0, sid).list();
		return list;
	}
	
}
