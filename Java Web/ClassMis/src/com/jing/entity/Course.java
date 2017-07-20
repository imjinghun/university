package com.jing.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */

public class Course implements java.io.Serializable
{

	// Fields

	private String crid;
	private String crname;
	private String crnature;
	private Double crcredit;
	private Set<Grade> grades = new HashSet<Grade>(0);

	// Constructors

	/** default constructor */
	public Course()
	{
	}

	/** minimal constructor */
	public Course(String crid)
	{
		this.crid = crid;
	}

	/** full constructor */
	public Course(String crid, String crname, String crnature, Double crcredit,
			Set<Grade> grades)
	{
		this.crid = crid;
		this.crname = crname;
		this.crnature = crnature;
		this.crcredit = crcredit;
		this.grades = grades;
	}

	// Property accessors

	public String getCrid()
	{
		return this.crid;
	}

	public void setCrid(String crid)
	{
		this.crid = crid;
	}

	public String getCrname()
	{
		return this.crname;
	}

	public void setCrname(String crname)
	{
		this.crname = crname;
	}

	public String getCrnature()
	{
		return this.crnature;
	}

	public void setCrnature(String crnature)
	{
		this.crnature = crnature;
	}

	public Double getCrcredit()
	{
		return this.crcredit;
	}

	public void setCrcredit(Double crcredit)
	{
		this.crcredit = crcredit;
	}

	public Set<Grade> getGrades()
	{
		return this.grades;
	}

	public void setGrades(Set<Grade> grades)
	{
		this.grades = grades;
	}

}