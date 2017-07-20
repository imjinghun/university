package com.jing.dao;

import java.util.List;

import com.jing.entity.Gm;

public interface IGmDao
{
	List<Gm> getGmMen();
	List<Gm> getGmDa(String Men);
	List<Gm> getGmZhong(String Da);
}
