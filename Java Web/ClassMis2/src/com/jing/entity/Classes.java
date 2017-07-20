package com.jing.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Classes implements java.io.Serializable
{

	// Fields

	private String cid;
	private String cname;
	private Set<Student> students = new HashSet<Student>(0);

	// Constructors

	/** default constructor */
	public Classes()
	{
	}

	/** minimal constructor */
	public Classes(String cid)
	{
		this.cid = cid;
	}

	/** full constructor */
	public Classes(String cid, String cname, Set<Student> students)
	{
		this.cid = cid;
		this.cname = cname;
		this.students = students;
	}

	// Property accessors

	public String getCid()
	{
		return this.cid;
	}

	public void setCid(String cid)
	{
		this.cid = cid;
	}

	public String getCname()
	{
		return this.cname;
	}

	public void setCname(String cname)
	{
		this.cname = cname;
	}

	public Set<Student> getStudents()
	{
		return this.students;
	}

	public void setStudents(Set<Student> students)
	{
		this.students = students;
	}

}