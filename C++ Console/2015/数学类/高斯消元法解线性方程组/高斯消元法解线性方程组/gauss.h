#pragma once
#include<iostream>
using namespace std;
class gauss
{
	double **a;
	int row,col;
public:
	void gethl(int r,int c);//���������
	void shenqing();	//����ռ�
	void qingchu();	//�ͷſռ�
	void input();//�������
	double det(gauss A);//��������ʽ
	friend void output(gauss A,gauss B);//������
	gauss(void);
	~gauss(void);
};
