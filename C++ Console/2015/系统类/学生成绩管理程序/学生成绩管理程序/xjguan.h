#pragma once
#include"people.h"
#include<vector>

typedef vector<people>  vectorOfpeople;

class xjguan
{
	vectorOfpeople xj;
public:
	void apply(int n);//�������鳤��
	void release();//�ͷſռ�
	void input1(int qs,int zz);//������Ϣ
	void output1(int qs,int zz);//�����Ϣ
	void huizong(int z);//�����ֽܷ��л���
	void chazhao(int z,string str);//����
	void paixu(int z);//�����ֽܷ�������
	void charu(int p,int r,int z);//����
	xjguan(void);
	~xjguan(void);
};

