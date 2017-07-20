#pragma once
#include<iostream>
#include<string>

using namespace std;
class people
{
	
public:
	string name,xuehao;
	double zfen,pjfen,math,english,chinese;
	void input();//输入
	void output();//输出
	double zongfen();//计算总分
	double pingjun();//计算平均分
	people(void);
	~people(void);
};


