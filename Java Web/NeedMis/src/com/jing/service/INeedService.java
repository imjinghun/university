package com.jing.service;

import java.util.List;

import com.jing.entity.NeedTable;

public interface INeedService {

	String save(NeedTable need);
	String update(NeedTable need);
	String delete(int id);
	List<NeedTable> getNeedUser(String organname);
	NeedTable findById(int id);
	List<NeedTable> getListXs();
	List<NeedTable> getListBm(String glbm);
	List<NeedTable> getListAll();
	List<NeedTable> getListZh(String sql);
}
