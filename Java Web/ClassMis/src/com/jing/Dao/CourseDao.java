package com.jing.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jing.common.HibernateSessionFactory;
import com.jing.entity.Course;

public class CourseDao
{
	// 保存课程
	public void saveCourse(Course cr)
	{
		Session session = null;
		Transaction trasaction = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			trasaction = session.beginTransaction();
			session.save(cr);
			trasaction.commit();
		} catch (Exception e)
		{
			System.out.println("保存课程异常");
			e.printStackTrace();
		} finally
		{
			HibernateSessionFactory.closeSession();
		}
	}
	//更新课程信息
	public void updateCourse(Course cr)
	{
		Session session = null;
		Transaction trasaction = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			trasaction = session.beginTransaction();
			session.update(cr);
			trasaction.commit();
		} catch (Exception e)
		{
			System.out.println("更新课程出异常");
			e.printStackTrace();
		} finally
		{
			HibernateSessionFactory.closeSession();
		}
	}
	//删除课程
	public void deleteCourse(Course cr)
	{
		Session session = null;
		Transaction trasaction = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			trasaction = session.beginTransaction();
			session.delete(cr);
			trasaction.commit();
		} catch (Exception e)
		{
			System.out.println("删除课程出异常");
			e.printStackTrace();
		} finally
		{
			HibernateSessionFactory.closeSession();
		}
	}
	//根据主键查找
	public Course findById(String crid)
	{
		Course course = new Course();
		Session session = null;
		Transaction trasaction = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			trasaction = session.beginTransaction();
			// 查找
			course = (Course) session
					.createQuery("from Course where crid=?") //
					.setParameter(0, crid) //
					.uniqueResult();
			trasaction.commit();
		} catch (Exception e)
		{
			System.out.println("根据主键查找课程信息异常");
			e.printStackTrace();
		} finally
		{
			HibernateSessionFactory.closeSession();
		}
		return course;
	}

	// 查出所有课程信息
	List<Course> listCr()
	{
		Session session = null;
		Transaction trasaction = null;
		session = HibernateSessionFactory.getSession();
		trasaction = session.beginTransaction();
		List<Course> course=new ArrayList<Course>();
		course= session.createQuery("from Course ").list();
		trasaction.commit();
		return course;
	}
	
}
