package com.jing.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import com.jing.entity.Course;

public class CourseDao
{
	// 注入sessionFactory
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
		
	// 保存课程
	public void saveCourse(Course cr)
	{
		try
		{
			sessionFactory.getCurrentSession().save(cr);
		} catch (Exception e)
		{
			System.out.println("保存课程异常");
			e.printStackTrace();
		} 
	}
	//更新课程信息
	public void updateCourse(Course cr)
	{
		try
		{
			sessionFactory.getCurrentSession().update(cr);
		} catch (Exception e)
		{
			System.out.println("更新课程出异常");
			e.printStackTrace();
		} 
	}
	//删除课程
	public void deleteCourse(Course cr)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(cr);
		} catch (Exception e)
		{
			System.out.println("删除课程出异常");
			e.printStackTrace();
		} 
	}
	//根据主键查找
	public Course findById(String crid)
	{
		Course course = new Course();
		try
		{
			// 查找
			course = (Course) sessionFactory.getCurrentSession() //
					.get(Course.class, crid);
		} catch (Exception e)
		{
			System.out.println("根据主键查找课程信息异常");
			e.printStackTrace();
		} 
		return course;
	}

	// 查出所有课程信息
	@SuppressWarnings("unchecked")
	public List<Course> listCr()
	{
		List<Course> course=new ArrayList<Course>();
		course= sessionFactory.getCurrentSession().createQuery("from Course ").list();
		return course;
	}
	
}
