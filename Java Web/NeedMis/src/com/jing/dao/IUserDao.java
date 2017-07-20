package com.jing.dao;

import java.util.List;

import com.jing.entity.UserInfo;

public interface IUserDao {
	UserInfo getUser(UserInfo userInfo);
	UserInfo findByUser(UserInfo userInfo);
	UserInfo findById(String username);
	void save(UserInfo userInfo);
	void update(UserInfo userInfo);
	void delete(UserInfo userInfo);
	List<UserInfo> getUser();
	List<UserInfo> getMgt();
	List<UserInfo> getAssessor();
}
