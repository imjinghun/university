package com.jing.entity;

/**
 * Xk entity. @author MyEclipse Persistence Tools
 */

public class Xk implements java.io.Serializable
{

	// Fields

	private String code;
	private String title;

	// Constructors

	/** default constructor */
	public Xk()
	{
	}

	/** minimal constructor */
	public Xk(String code)
	{
		this.code = code;
	}

	/** full constructor */
	public Xk(String code, String title)
	{
		this.code = code;
		this.title = title;
	}

	// Property accessors

	public String getCode()
	{
		return this.code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

}