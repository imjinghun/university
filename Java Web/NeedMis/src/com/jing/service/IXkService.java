package com.jing.service;

import java.util.List;

import com.jing.entity.Xk;

public interface IXkService
{
	List<Xk> getXkYi();
	List<Xk> getXkEr(String Yiji);
	List<Xk> getXkSan(String Erji);
}
