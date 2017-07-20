#pragma once
#include"people.h"
#include<vector>

typedef vector<people>  vectorOfpeople;

class xjguan
{
	vectorOfpeople xj;
public:
	void apply(int n);//申请数组长度
	void release();//释放空间
	void input1(int qs,int zz);//输入信息
	void output1(int qs,int zz);//输出信息
	void huizong(int z);//计算总分进行汇总
	void chazhao(int z,string str);//查找
	void paixu(int z);//按照总分降序排序
	void charu(int p,int r,int z);//插入
	xjguan(void);
	~xjguan(void);
};

