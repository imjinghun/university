#pragma once
#include<iostream>
using namespace std;
class gauss
{
	double **a;
	int row,col;
public:
	void gethl(int r,int c);//获得行列数
	void shenqing();	//申请空间
	void qingchu();	//释放空间
	void input();//输入矩阵
	double det(gauss A);//计算行列式
	friend void output(gauss A,gauss B);//输出结果
	gauss(void);
	~gauss(void);
};
