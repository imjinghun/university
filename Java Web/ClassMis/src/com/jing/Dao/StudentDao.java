package com.jing.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jing.common.HibernateSessionFactory;
import com.jing.entity.Student;

public class StudentDao
{
	//保存学生
	public void saveStd(Student std)
	{
		Session session=null;
		Transaction trasaction=null;
		try
		{
			session = HibernateSessionFactory.getSession();
			trasaction = session.beginTransaction();
			session.save(std);
			trasaction.commit();
		}
		catch (Exception e) {
			System.out.println("保存学生出异常");
			e.printStackTrace();
		}
		finally
		{
			HibernateSessionFactory.closeSession();
		}
	}
	//更新学生信息
	public void updateStd(Student std)
	{
		Session session = null;
		Transaction trasaction = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			trasaction = session.beginTransaction();
			session.update(std);
			trasaction.commit();
		} catch (Exception e)
		{
			System.out.println("更新学生出异常");
			e.printStackTrace();
		} finally
		{
			HibernateSessionFactory.closeSession();
		}
	}
	//删除学生
	public void deleteStd(Student std)
	{
		Session session = null;
		Transaction trasaction = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			trasaction = session.beginTransaction();
			session.delete(std);
			trasaction.commit();
		} catch (Exception e)
		{
			System.out.println("删除学生出异常");
			e.printStackTrace();
		} finally
		{
			HibernateSessionFactory.closeSession();
		}
	}
	//根据用户名和密码查找
	public Student findByStd(Student std)
	{
		Student student=new Student();
		Session session=null;
		Transaction trasaction=null;
		try
		{
			session = HibernateSessionFactory.getSession();
			trasaction = session.beginTransaction();
			//查找
			student=(Student)session.createQuery("from Student where sid=? and spwd=?") //
					.setParameter(0, std.getSid()) //
					.setParameter(1, std.getSpwd()) //
					.uniqueResult();
			
			trasaction.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			HibernateSessionFactory.closeSession();
		}
		return student;
	}

	// 根据用户名查找
	public Student findById(String sid)
	{
		Student student = new Student();
		Session session = null;
		Transaction trasaction = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			trasaction = session.beginTransaction();
			// 查找
			student = (Student) session
					.createQuery("from Student where sid=?") //
					.setParameter(0, sid) //
					.uniqueResult();

			trasaction.commit();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			HibernateSessionFactory.closeSession();
		}
		return student;
	}

	// 查出所有学生信息
	List<Student> listStd()
	{
		Session session = null;
		Transaction trasaction = null;
		session = HibernateSessionFactory.getSession();
		trasaction = session.beginTransaction();
		List<Student> student=new ArrayList<Student>();
		student= session.createQuery("from Student ").list();
		trasaction.commit();
		return student;
	}
}
