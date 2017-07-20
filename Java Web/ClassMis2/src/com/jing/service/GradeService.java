package com.jing.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jing.dao.GradeDao;
import com.jing.entity.Grade;
import com.jing.entity.GradeId;
public class GradeService
{
	private GradeDao gdDao;
	public void setGdDao(GradeDao gdDao)
	{
		this.gdDao = gdDao;
	}
	public void saveBatch()
	{
		gdDao.saveBatch();
	}
	public void saveGrade(Grade grade)
	{
		gdDao.saveGrade(grade);
	}
	public Grade findbyId(GradeId id)
	{
		return gdDao.findbyId(id);
	}
	public List<Grade> listGrade()
	{
		return gdDao.listGrade();
	}
	public List<Object[]> listCG()
	{
		return gdDao.listCG();
	}
	public List<Object[]> listXC(String sid)
	{
		return gdDao.listXC(sid);
	}
}
