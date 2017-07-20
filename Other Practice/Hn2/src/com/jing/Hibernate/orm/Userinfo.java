package com.jing.Hibernate.orm;

/**
 * Userinfo entity. @author MyEclipse Persistence Tools
 */

public class Userinfo implements java.io.Serializable
{

	// Fields

	private Integer id;
	private String username;
	private String password;

	// Constructors

	/** default constructor */
	public Userinfo()
	{
	}

	/** minimal constructor */
	public Userinfo(Integer id)
	{
		this.id = id;
	}

	/** full constructor */
	public Userinfo(Integer id, String username, String password)
	{
		this.id = id;
		this.username = username;
		this.password = password;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

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

}