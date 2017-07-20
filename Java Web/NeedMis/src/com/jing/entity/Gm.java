package com.jing.entity;

/**
 * Gm entity. @author MyEclipse Persistence Tools
 */

public class Gm implements java.io.Serializable
{

	// Fields

	private String code;
	private String title;

	// Constructors

	/** default constructor */
	public Gm()
	{
	}

	/** minimal constructor */
	public Gm(String code)
	{
		this.code = code;
	}

	/** full constructor */
	public Gm(String code, String title)
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