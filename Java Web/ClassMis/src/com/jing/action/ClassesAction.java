package com.jing.action;


import com.jing.Dao.ClassesDao;
import com.jing.entity.Classes;
import com.opensymphony.xwork2.ActionSupport;

public class ClassesAction extends ActionSupport
{
	private Classes cs;
	public Classes getCs()
	{
		return cs;
	}
	public void setCs(Classes cs)
	{
		this.cs = cs;
	}
	
	private ClassesDao csDao = new ClassesDao();
	public ClassesDao getCsDao()
	{
		return csDao;
	}
	public void setCsDao(ClassesDao csDao)
	{
		this.csDao = csDao;
	}
	
	// 保存班级
	public String saveCs()
	{
		String result="";
		if(csDao.findById(cs.getCid())==null) //主键不重复
		{
			csDao.saveClass(cs);
			result="saveSuccess";
		}
		else
		{
			this.addFieldError("saveError", "班级已存在");
			result="saveFail";
		}
		return result;
	}

	// 删除班级信息
	public String deleteCs()
	{
		String cid = cs.getCid();
		Classes cc = csDao.findById(cid);
		csDao.deleteClass(cc);
		return "deleteSuccess";
	}

	// 更新班级信息
	public String updateCs()
	{
		csDao.updateClass(cs);
		return "updateSuccess";
	}

}
