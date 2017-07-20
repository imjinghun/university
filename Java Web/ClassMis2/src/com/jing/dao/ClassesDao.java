package com.jing.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import com.jing.entity.Classes;

public class ClassesDao
{
	//注入sessionFactory
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	// 保存班级
	public void saveClass(Classes cs)
	{
		try
		{
			sessionFactory.getCurrentSession().save(cs);
		} catch (Exception e)
		{
			System.out.println("保存班级异常");
			e.printStackTrace();
		} 
	}
	//更新班级信息
	public void updateClass(Classes cs)
	{
		try
		{
			sessionFactory.getCurrentSession().update(cs);
		} catch (Exception e)
		{
			System.out.println("更新班级出异常");
			e.printStackTrace();
		}
	}
	//删除班级
	public void deleteClass(Classes cs)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(cs);
		} catch (Exception e)
		{
			System.out.println("删除班级出异常");
			e.printStackTrace();
		} 
	}
	//根据主键查找
	@Test
	public Classes findById(String cid)
	{
		Classes classes = new Classes();
		try
		{
			// 查找
			classes = (Classes) sessionFactory.getCurrentSession() //
					.get(Classes.class, cid);
			//System.out.println(classes);
			
		} catch (Exception e)
		{
			System.out.println("根据主键查找班级信息异常");
			e.printStackTrace();
		} 
		return classes;
	}

	// 查出所有班级信息
	@SuppressWarnings("unchecked")
	public List<Classes> listCs()
	{
		List<Classes> classes = new ArrayList<Classes>();
		classes = sessionFactory.getCurrentSession()
				.createQuery("from Classes ").list();
		return classes;
	}
}
