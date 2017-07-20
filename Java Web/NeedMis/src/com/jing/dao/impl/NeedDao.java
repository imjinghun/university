package com.jing.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;

import com.jing.dao.INeedDao;
import com.jing.entity.NeedTable;

public class NeedDao implements INeedDao
{
	//注入SessionFactory
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//需求保存/提交
	@Override
	public void save(NeedTable need)
	{
		sessionFactory.getCurrentSession().save(need);
	}
	//需求删除
	@Override
	public void delete(NeedTable need)
	{
		sessionFactory.getCurrentSession().delete(need);
	}
	//需求更新
	@Override
	public void update(NeedTable need)
	{
		sessionFactory.getCurrentSession().update(need);
	}
	//根据主键查找 需求
	@Override
	public NeedTable findById(int id)
	{
		return (NeedTable)sessionFactory.getCurrentSession()//
				.get(NeedTable.class, id);
	}

	//查询普通用户已填报的需求
	@SuppressWarnings("unchecked")
	@Override
	public List<NeedTable> getList(String organname)
	{
		return sessionFactory.getCurrentSession()//
				.createQuery("from NeedTable where organname = ?")//
				.setParameter(0, organname)//
				.list();
	}
	//获取未审核 形式审核通过、未通过的需求
	@SuppressWarnings("unchecked")
	@Override
	public List<NeedTable> getListXs()
	{
		return sessionFactory.getCurrentSession()//
				.createQuery("from NeedTable where states like ? or states = ?")//
				.setParameter(0, "形式审核%")//
				.setParameter(1, "未审核")//
				.list();
	}
	//获取管理部门的需求
	@SuppressWarnings("unchecked")
	@Override
	public List<NeedTable> getListBm(String glbm)
	{
		return sessionFactory.getCurrentSession()//
				.createQuery("from NeedTable where glbm = ?")//
				.setParameter(0, glbm)//
				.list();
	}
	//获取所有已提交需求
	@SuppressWarnings("unchecked")
	@Override
	public List<NeedTable> getListAll()
	{
		return sessionFactory.getCurrentSession()//
				.createQuery("from NeedTable where states != ?")//
				.setParameter(0, "未提交")//
				.list();
	}
	//综合查询
	@SuppressWarnings("unchecked")
	@Override
	public List<NeedTable> getListZh(String sql){
		return sessionFactory.getCurrentSession()//
				.createQuery(sql)//
				.list();
	}
}
