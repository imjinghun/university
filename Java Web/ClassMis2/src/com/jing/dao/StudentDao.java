package com.jing.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import com.jing.entity.Student;

public class StudentDao
{
	//注入sessionFactory
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	//保存学生
	public void saveStd(Student std)
	{
		try
		{
			sessionFactory.getCurrentSession().save(std);
		}
		catch (Exception e) {
			System.out.println("保存学生出异常");
			e.printStackTrace();
		}
	}
	//更新学生信息
	public void updateStd(Student std)
	{
		try
		{
			sessionFactory.getCurrentSession().update(std);
		} catch (Exception e)
		{
			System.out.println("更新学生出异常");
			e.printStackTrace();
		} 
	}
	//删除学生
	public void deleteStd(Student std)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(std);
		} catch (Exception e)
		{
			System.out.println("删除学生出异常");
			e.printStackTrace();
		} 
	}
	//根据用户名和密码查找
	public Student findByStd(Student std)
	{
		Student student=new Student();
		try
		{
			//查找
			student=(Student)sessionFactory.getCurrentSession().createQuery("from Student where sid=? and spwd=?") //
					.setParameter(0, std.getSid()) //
					.setParameter(1, std.getSpwd()) //
					.uniqueResult();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	// 根据用户名查找
	public Student findById(String sid)
	{
		Student student = new Student();
		try
		{
			// 查找
			student = (Student) sessionFactory.getCurrentSession() //
					.get(Student.class, sid);
		} catch (Exception e)
		{
			e.printStackTrace();
		} 
		return student;
	}

	// 查出所有学生信息
	@SuppressWarnings("unchecked")
	public List<Student> listStd()
	{
		List<Student> student=new ArrayList<Student>();
		student= sessionFactory.getCurrentSession().createQuery("from Student ").list();
		return student;
	}
}
