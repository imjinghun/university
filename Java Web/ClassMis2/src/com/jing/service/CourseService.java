package com.jing.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jing.dao.CourseDao;
import com.jing.entity.Course;
public class CourseService
{
	private CourseDao crDao;
	public void setCrDao(CourseDao crDao)
	{
		this.crDao = crDao;
	}
	
	public void saveCourse(Course cr)
	{
		crDao.saveCourse(cr);
	}
	public void updateCourse(Course cr)
	{
		crDao.updateCourse(cr);
	}
	public void deleteCourse(Course cr)
	{
		crDao.deleteCourse(cr);
	}
	public Course findById(String crid)
	{
		return crDao.findById(crid);
	}
	public List<Course> listCr()
	{
		return crDao.listCr();
	}
}
