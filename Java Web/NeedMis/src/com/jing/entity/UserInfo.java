package com.jing.entity;

/**
 * UserInfo entity. @author MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable
{

	// Fields

	private String username;
	private String password;
	private String organcode;
	private String organname;
	private String parentmgt;
	private String contactaddr;
	private String unitweb;
	private String email;
	private String legalperson;
	private String postcode;
	private String contacts;
	private String tel;
	private String phone;
	private String fax;
	private String glbm;
	private String powers;

	// Constructors

	public UserInfo()
	{
	}

	public UserInfo(String username)
	{
		this.username = username;
	}

	public UserInfo(String username, String password, String organcode,
			String organname, String parentmgt, String contactaddr,
			String unitweb, String email, String legalperson, String postcode,
			String contacts, String tel, String phone, String fax,String glbm,String powers)
	{
		this.username = username;
		this.password = password;
		this.organcode = organcode;
		this.organname = organname;
		this.parentmgt = parentmgt;
		this.contactaddr = contactaddr;
		this.unitweb = unitweb;
		this.email = email;
		this.legalperson = legalperson;
		this.postcode = postcode;
		this.contacts = contacts;
		this.tel = tel;
		this.phone = phone;
		this.fax = fax;
		this.glbm = glbm;
		this.powers=powers;
	}

	// Property accessors

	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getOrgancode()
	{
		return this.organcode;
	}

	public void setOrgancode(String organcode)
	{
		this.organcode = organcode;
	}

	public String getOrganname()
	{
		return this.organname;
	}

	public void setOrganname(String organname)
	{
		this.organname = organname;
	}

	public String getParentmgt()
	{
		return this.parentmgt;
	}

	public void setParentmgt(String parentmgt)
	{
		this.parentmgt = parentmgt;
	}

	public String getContactaddr()
	{
		return this.contactaddr;
	}

	public void setContactaddr(String contactaddr)
	{
		this.contactaddr = contactaddr;
	}

	public String getUnitweb()
	{
		return this.unitweb;
	}

	public void setUnitweb(String unitweb)
	{
		this.unitweb = unitweb;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getLegalperson()
	{
		return this.legalperson;
	}

	public void setLegalperson(String legalperson)
	{
		this.legalperson = legalperson;
	}

	public String getPostcode()
	{
		return this.postcode;
	}

	public void setPostcode(String postcode)
	{
		this.postcode = postcode;
	}

	public String getContacts()
	{
		return this.contacts;
	}

	public void setContacts(String contacts)
	{
		this.contacts = contacts;
	}

	public String getTel()
	{
		return this.tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public String getPhone()
	{
		return this.phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getFax()
	{
		return this.fax;
	}

	public void setFax(String fax)
	{
		this.fax = fax;
	}
	
	public String getGlbm()
	{
		return this.glbm;
	}

	public void setGlbm(String glbm)
	{
		this.glbm = glbm;
	}
	
	public String getPowers()
	{
		return powers;
	}

	public void setPowers(String powers)
	{
		this.powers=powers;
	}
}