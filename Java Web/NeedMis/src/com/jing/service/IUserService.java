package com.jing.service;

import java.util.List;

import com.jing.entity.UserInfo;

public interface IUserService {

	String register(UserInfo userInfo);
	
	String login(UserInfo userInfo);
	UserInfo findUser(UserInfo userInfo);
	void update(UserInfo userInfo);
	String delete(String username);
	List<UserInfo> getUser();
	List<UserInfo> getMgt();
	List<UserInfo> getAssessor();
}
