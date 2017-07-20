package com.jing.action;

import com.jing.entity.Admin;
import com.jing.service.IAdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {

	private Admin admin = new Admin();
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Admin getAdmin() {
		return admin;
	}
	
	@Override
	public Admin getModel() {
		return admin;
	}
	
	private IAdminService adminService;
	
	public void setAdminService(IAdminService adminService) {
		this.adminService = adminService;
	}
	
	public String login(){
		// 
		Admin adminInfo = adminService.login(admin);
		// 
		if (adminInfo == null){
			// 
			return "loginFaild";
		} else {
			// 保存数据到session
			System.out.println("成功");
			ActionContext.getContext().getSession().put("adminInfo", adminInfo);
			return "index";
		}
	}

}
