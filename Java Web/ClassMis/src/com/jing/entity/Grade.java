package com.jing.entity;

/**
 * Grade entity. @author MyEclipse Persistence Tools
 */

public class Grade implements java.io.Serializable
{

	// Fields

	private GradeId id;
	private Double ggrade;

	// Constructors

	/** default constructor */
	public Grade()
	{
	}

	/** minimal constructor */
	public Grade(GradeId id)
	{
		this.id = id;
	}

	/** full constructor */
	public Grade(GradeId id, Double ggrade)
	{
		this.id = id;
		this.ggrade = ggrade;
	}

	// Property accessors

	public GradeId getId()
	{
		return this.id;
	}

	public void setId(GradeId id)
	{
		this.id = id;
	}

	public Double getGgrade()
	{
		return this.ggrade;
	}

	public void setGgrade(Double ggrade)
	{
		this.ggrade = ggrade;
	}

}