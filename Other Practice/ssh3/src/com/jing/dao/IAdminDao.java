package com.jing.dao;

import com.jing.entity.Admin;


public interface IAdminDao {

	void save(Admin admin);

	Admin findByAdmin(Admin admin);

}
