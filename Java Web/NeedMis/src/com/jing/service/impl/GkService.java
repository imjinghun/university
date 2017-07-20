package com.jing.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.jing.dao.IGkDao;
import com.jing.entity.Gk;
import com.jing.service.IGkService;

@Transactional
public class GkService implements IGkService
{
	private IGkDao GkDao;
	public void setGkDao(IGkDao GkDao)
	{
		this.GkDao = GkDao;
	}

	@Override
	public List<Gk> getGk()
	{
		return GkDao.getGk();
	}
}
