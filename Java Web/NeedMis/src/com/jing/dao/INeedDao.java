package com.jing.dao;

import java.util.List;

import com.jing.entity.NeedTable;

public interface INeedDao
{
	void save(NeedTable need);
	void delete(NeedTable need);
	void update(NeedTable need);
	NeedTable findById(int id);
	List<NeedTable> getList(String organname);
	List<NeedTable> getListXs();
	List<NeedTable> getListBm(String glbm);
	List<NeedTable> getListAll();
	List<NeedTable> getListZh(String sql);
}
