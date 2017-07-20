#pragma once
#include"people.h"
#include<vector>

typedef vector<people>  vectorOfpeople;

class xinguan
{
	vectorOfpeople xg;
public:
	void apply(int n);//申请数组长度
	void release();//释放空间
	void input1(int qs,int zz);//输入信息
	void output1(int qs,int zz);//输出信息
	void chazhao(int z,string str);//查找
	void xiugai(int z,string str);//修改
	void shanchu(int z,string str);//删除
	xinguan(void);
	~xinguan(void);
};

