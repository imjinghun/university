package com.jing.service;

import java.util.List;

import com.jing.entity.Gm;

public interface IGmService
{
	List<Gm> getGmMen();
	List<Gm> getGmDa(String Men);
	List<Gm> getGmZhong(String Da);
}
