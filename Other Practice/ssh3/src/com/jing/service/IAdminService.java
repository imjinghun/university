package com.jing.service;

import com.jing.entity.Admin;

public interface IAdminService {

	void register(Admin admin);

	Admin login(Admin admin);

}
