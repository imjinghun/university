package com.jing.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jing.dao.IGmDao;
import com.jing.entity.Gm;
import com.jing.service.IGmService;

@Transactional
public class GmService implements IGmService
{
	private IGmDao GmDao;
	public void setGmDao(IGmDao GmDao)
	{
		this.GmDao = GmDao;
	}

	@Override
	public List<Gm> getGmMen()
	{
		return GmDao.getGmMen();
	}

	@Override
	public List<Gm> getGmDa(String Men)
	{
		return GmDao.getGmDa(Men);
	}

	@Override
	public List<Gm> getGmZhong(String Da)
	{
		return GmDao.getGmZhong(Da);
	}

}
