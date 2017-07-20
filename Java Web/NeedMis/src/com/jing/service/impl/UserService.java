package com.jing.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jing.dao.IUserDao;
import com.jing.entity.UserInfo;
import com.jing.service.IUserService;

@Transactional
public class UserService implements IUserService{

	//注入dao
	private IUserDao userDao;
	public void setUserDao(IUserDao userDao)
	{
		this.userDao = userDao;
	}
	
	@Override
	public String register(UserInfo userInfo)
	{
		String result = "";
		UserInfo user=userDao.getUser(userInfo);
		if (user != null) // 用户存在
		{
			result = "userExist";
		} 
		else // 保存用户
		{
			userInfo.setPowers("users");
			userDao.save(userInfo);
			result = "userSave";
		}
		return result;
	}

	//登录验证
	@Override
	public String login(UserInfo userInfo)
	{
		String result="";
		UserInfo user=userDao.getUser(userInfo);
		if(user != null) //用户存在
		{
			UserInfo u=userDao.findByUser(userInfo);
			if(u==null)//密码错误
			{
				result="pwdError";
			}
			else //用户和密码正确
			{
				if(u.getPowers().equals("users"))
				{
					result="users";
				}
				if(u.getPowers().equals("admin"))
				{
					result="admin";
				}
				if(u.getPowers().equals("assessor"))
				{
					result="assessor";
				}
				if(u.getPowers().equals("mgt"))
				{
					result="mgt";
				}
			}
		}
		else //用户不存在
		{
			result="userNoExist";
		}
		return result;
	}

	@Override
	public UserInfo findUser(UserInfo userInfo)
	{
		return userDao.getUser(userInfo);
	}

	@Override
	public void update(UserInfo userInfo)
	{
		userDao.update(userInfo);
	}
	@Override
	public String delete(String username)
	{
		String result="";
		UserInfo user=userDao.findById(username);
		if(user!=null)
		{
			userDao.delete(user);
			result="deleteSuccess";
		}
		else
		{
			result="deleteFail";
		}
		return result;
	}
	@Override
	public List<UserInfo> getUser()
	{
		return userDao.getUser();
	}

	@Override
	public List<UserInfo> getMgt()
	{
		return userDao.getMgt();
	}

	@Override
	public List<UserInfo> getAssessor()
	{
		return userDao.getAssessor();
	}

}
