package com.jing.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jing.common.HibernateSessionFactory;
import com.jing.entity.Classes;

public class ClassesDao
{
	// 保存班级
	public void saveClass(Classes cs)
	{
		Session session = null;
		Transaction trasaction = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			trasaction = session.beginTransaction();
			session.save(cs);
			trasaction.commit();
		} catch (Exception e)
		{
			System.out.println("保存班级异常");
			e.printStackTrace();
		} finally
		{
			HibernateSessionFactory.closeSession();
		}
	}
	//更新班级信息
	public void updateClass(Classes cs)
	{
		Session session = null;
		Transaction trasaction = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			trasaction = session.beginTransaction();
			session.update(cs);
			trasaction.commit();
		} catch (Exception e)
		{
			System.out.println("更新班级出异常");
			e.printStackTrace();
		} finally
		{
			HibernateSessionFactory.closeSession();
		}
	}
	//删除班级
	public void deleteClass(Classes cs)
	{
		Session session = null;
		Transaction trasaction = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			trasaction = session.beginTransaction();
			session.delete(cs);
			trasaction.commit();
		} catch (Exception e)
		{
			System.out.println("删除班级出异常");
			e.printStackTrace();
		} finally
		{
			HibernateSessionFactory.closeSession();
		}
	}
	//根据主键查找
	public Classes findById(String cid)
	{
		Classes classes = new Classes();
		Session session = null;
		Transaction trasaction = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			trasaction = session.beginTransaction();
			// 查找
			classes = (Classes) session
					.createQuery("from Classes where cid=?") //
					.setParameter(0, cid) //
					.uniqueResult();
			trasaction.commit();
		} catch (Exception e)
		{
			System.out.println("根据主键查找班级信息异常");
			e.printStackTrace();
		} finally
		{
			HibernateSessionFactory.closeSession();
		}
		return classes;
	}
	
}
