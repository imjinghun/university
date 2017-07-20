package com.jing.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jing.dao.ClassesDao;
import com.jing.entity.Classes;
public class ClassesService
{
	//注入
	private ClassesDao csDao;
	public void setCsDao(ClassesDao csDao)
	{
		this.csDao = csDao;
	}
	//方法
	public void saveClass(Classes cs)
	{
		csDao.saveClass(cs);
	}
	public void updateClass(Classes cs)
	{
		csDao.updateClass(cs);
	}
	public void deleteClass(Classes cs)
	{
		csDao.deleteClass(cs);
	}
	public Classes findById(String cid)
	{
		return csDao.findById(cid);
	}public List<Classes> listCs()
	{
		return csDao.listCs();
	}
}
