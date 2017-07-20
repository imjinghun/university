package com.jing.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable
{

	// Fields

	private String sid;
	private Classes classes;
	private String spwd;
	private String sname;
	private String ssex;
	private String sbirth;
	private String stel;
	private String saddress;
	private Set<Grade> grades = new HashSet<Grade>(0);

	// Constructors

	/** default constructor */
	public Student()
	{
	}

	/** minimal constructor */
	public Student(String sid)
	{
		this.sid = sid;
	}

	/** full constructor */
	public Student(String sid, Classes classes, String spwd, String sname,
			String ssex, String sbirth, String stel, String saddress,
			Set<Grade> grades)
	{
		this.sid = sid;
		this.classes = classes;
		this.spwd = spwd;
		this.sname = sname;
		this.ssex = ssex;
		this.sbirth = sbirth;
		this.stel = stel;
		this.saddress = saddress;
		this.grades = grades;
	}

	// Property accessors

	public String getSid()
	{
		return this.sid;
	}

	public void setSid(String sid)
	{
		this.sid = sid;
	}

	public Classes getClasses()
	{
		return this.classes;
	}

	public void setClasses(Classes classes)
	{
		this.classes = classes;
	}

	public String getSpwd()
	{
		return this.spwd;
	}

	public void setSpwd(String spwd)
	{
		this.spwd = spwd;
	}

	public String getSname()
	{
		return this.sname;
	}

	public void setSname(String sname)
	{
		this.sname = sname;
	}

	public String getSsex()
	{
		return this.ssex;
	}

	public void setSsex(String ssex)
	{
		this.ssex = ssex;
	}

	public String getSbirth()
	{
		return this.sbirth;
	}

	public void setSbirth(String sbirth)
	{
		this.sbirth = sbirth;
	}

	public String getStel()
	{
		return this.stel;
	}

	public void setStel(String stel)
	{
		this.stel = stel;
	}

	public String getSaddress()
	{
		return this.saddress;
	}

	public void setSaddress(String saddress)
	{
		this.saddress = saddress;
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