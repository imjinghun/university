package com.jing.service.impl;

import com.jing.dao.IAdminDao;
import com.jing.entity.Admin;
import com.jing.service.IAdminService;



public class AdminService implements IAdminService {
	
	private IAdminDao adminDao; //JDK
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}	

	@Override
	public Admin login(Admin admin) {
		return adminDao.findByAdmin(admin);
	}

	@Override
	public void register(Admin admin) {
		adminDao.save(admin);
	}

}
