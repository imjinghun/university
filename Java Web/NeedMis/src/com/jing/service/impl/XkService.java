package com.jing.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jing.dao.IXkDao;
import com.jing.entity.Xk;
import com.jing.service.IXkService;

@Transactional
public class XkService implements IXkService
{
	private IXkDao xkDao;
	public void setXkDao(IXkDao xkDao)
	{
		this.xkDao = xkDao;
	}

	@Override
	public List<Xk> getXkYi()
	{
		return xkDao.getXkYi();
	}

	@Override
	public List<Xk> getXkEr(String Yiji)
	{
		return xkDao.getXkEr(Yiji);
	}

	@Override
	public List<Xk> getXkSan(String Erji)
	{
		return xkDao.getXkSan(Erji);
	}

}
