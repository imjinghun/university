#pragma once
#include"people.h"
#include<vector>

typedef vector<people>  vectorOfpeople;

class xinguan
{
	vectorOfpeople xg;
public:
	void apply(int n);//�������鳤��
	void release();//�ͷſռ�
	void input1(int qs,int zz);//������Ϣ
	void output1(int qs,int zz);//�����Ϣ
	void chazhao(int z,string str);//����
	void xiugai(int z,string str);//�޸�
	void shanchu(int z,string str);//ɾ��
	xinguan(void);
	~xinguan(void);
};

