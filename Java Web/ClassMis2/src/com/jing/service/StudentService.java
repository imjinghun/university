package com.jing.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jing.dao.StudentDao;
import com.jing.entity.Student;
public class StudentService
{
	//注入Dao
	private StudentDao stdDao;
	public void setStdDao(StudentDao stdDao)
	{
		this.stdDao = stdDao;
	}
	
	public void saveStd(Student std)
	{
		stdDao.saveStd(std);
	}
	public void updateStd(Student std)
	{
		stdDao.updateStd(std);
	}
	public void deleteStd(Student std)
	{
		stdDao.deleteStd(std);
	}
	public Student findByStd(Student std)
	{
		return stdDao.findByStd(std);
	}
	public Student findById(String sid)
	{
		return stdDao.findById(sid);
	}
	public List<Student> listStd()
	{
		return stdDao.listStd();
	}
}

