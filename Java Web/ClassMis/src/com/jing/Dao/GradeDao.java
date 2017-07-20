package com.jing.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jing.common.HibernateSessionFactory;
import com.jing.entity.Course;
import com.jing.entity.Grade;
import com.jing.entity.GradeId;
import com.jing.entity.Student;

public class GradeDao
{
	private CourseDao crDao=new CourseDao();
	private StudentDao stdDao=new StudentDao();
	//批量插入学生课程信息
	public void saveBatch()
	{
		// 获取所有学生 课程 信息
		List<Student> std = stdDao.listStd();
		List<Course> cr = crDao.listCr();

		// 创建grade和grade主键对象
		Grade grade = new Grade();
		GradeId gid = new GradeId();

		// 获取学生 课程集合的长度
		int stdL = std.size();
		int crL = cr.size();

		try
		{
			// 使用循环 让每个学生选所有课程 保存到grade数据表
			for (int i = 0; i < stdL; i++)
			{
				// set Student属性
				gid.setStudent(std.get(i));
				for (int j = 0; j < crL; j++)
				{
					// set Course属性
					gid.setCourse(cr.get(j));
					
					// 保存到grade表 
					if(findbyId(gid)==null)
					{
						// set Grade表主键属性
						grade.setId(gid);
						Session session = null;
						Transaction trasaction = null;
						session = HibernateSessionFactory.getSession();
						trasaction = session.beginTransaction();
						session.save(grade);
						trasaction.commit();
					}
				}
			}
		} catch (Exception e)
		{
			System.out.println("保存课程学生信息出异常");
			e.printStackTrace();
		} finally
		{
			HibernateSessionFactory.closeSession();
		}
	}

	// 更新 保存成绩
	public void saveGrade(Grade grade)
	{
		Session session = null;
		Transaction trasaction = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			trasaction = session.beginTransaction();
			session.update(grade);
			trasaction.commit();
		} catch (Exception e)
		{
			System.out.println("更新成绩出异常");
			e.printStackTrace();
		} finally
		{
			HibernateSessionFactory.closeSession();
		}
	}
	//查找 grade表中信息是否存在
	public Grade findbyId(GradeId id)
	{
		Grade grade = new Grade();
		Session session = null;
		Transaction trasaction = null;
		try
		{
			session = HibernateSessionFactory.getSession();
			trasaction = session.beginTransaction();
			// 查找
			grade = (Grade) session.get(Grade.class, id);
			trasaction.commit();
		} catch (Exception e)
		{
			System.out.println("根据主键查找grade信息异常");
			e.printStackTrace();
		} finally
		{
			HibernateSessionFactory.closeSession();
		}
		return grade;
	}
	/*//统计学生课程信息
	@SuppressWarnings("unchecked")
	public List<GradeId> xsInfo(Student std)
	{
		Session session = null;
		Transaction trasaction = null;
		session = HibernateSessionFactory.getSession();
		trasaction = session.beginTransaction();
		
		List<GradeId> listXs=new ArrayList<GradeId>();
		listXs= session.createQuery("from GradeId where student=?")//
				.setParameter(0, std)
				.list();
		
		trasaction.commit();
		return listXs;
	}*/
	
}
