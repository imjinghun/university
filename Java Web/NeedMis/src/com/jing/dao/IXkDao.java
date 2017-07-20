package com.jing.dao;

import java.util.List;

import com.jing.entity.Xk;

public interface IXkDao
{
	List<Xk> getXkYi();
	List<Xk> getXkEr(String Yiji);
	List<Xk> getXkSan(String Erji);
}
