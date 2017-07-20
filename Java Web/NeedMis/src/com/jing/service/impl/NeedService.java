package com.jing.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jing.dao.INeedDao;
import com.jing.entity.NeedTable;
import com.jing.service.INeedService;

@Transactional
public class NeedService implements INeedService
{
	//注入Dao
	private INeedDao needDao;
	public void setNeedDao(INeedDao needDao)
	{
		this.needDao = needDao;
	}

	//保存/提交需求
	@Override
	public String save(NeedTable need)
	{
		needDao.save(need);
		return "saveSuccess";
	}

	//更新需求
	@Override
	public String update(NeedTable need)
	{
		needDao.update(need);
		return "updateSuccess";
	}

	//删除需求
	@Override
	public String delete(int id)
	{
		String result="";
		NeedTable need=needDao.findById(id);
		if(need!=null)
		{
			needDao.delete(need);
			result="deleteSuccess";
		}
		else
		{
			result="deleteFail";
		}
		return result;
	}

	@Override
	public NeedTable findById(int id)
	{
		return needDao.findById(id);
	}
	
	//根据机构名称查找需求
	@Override
	public List<NeedTable> getNeedUser(String organname)
	{
		return needDao.getList(organname);
	}

	// 获取未审核 形式审核通过、未通过的需求
	@Override
	public List<NeedTable> getListXs()
	{
		return needDao.getListXs();
	}
	// 获取部门的需求
	@Override
	public List<NeedTable> getListBm(String glbm)
	{
		return needDao.getListBm(glbm);
	}
	// 获取所有已提交的需求
	@Override
	public List<NeedTable> getListAll()
	{
		return needDao.getListAll();
	}
	
	//综合查询
	@Override
	public List<NeedTable> getListZh(String sql){
		return needDao.getListZh(sql);
	}

}
