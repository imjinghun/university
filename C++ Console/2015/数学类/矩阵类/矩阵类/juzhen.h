#pragma once
#include<iostream>
#include<new>
using namespace std;
class juzhen
{
	double **a;
	int row,col;
public:

	void gethl(int r,int c);//获得行列数
	void shenqing();	//申请空间
	void qingchu();	//释放空间
	void input();	//输入方阵
	void output(juzhen A);//输出方阵
	void ji(int rr,int cc,juzhen A);	//方阵的迹
	double det(juzhen A);	//行列式及是否可逆
	bool det1(juzhen A);//判断是否是方阵
	friend juzhen operator+(juzhen A,juzhen B);
	friend juzhen operator-(juzhen A,juzhen B);
	friend juzhen operator*(juzhen A,juzhen B);
	juzhen(void);
	~juzhen(void);
};


