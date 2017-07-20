#pragma once
#include<iostream>
#include<string>
using namespace std;

class people
{
public:
	int age;//age年龄
	string name,sex,xuehao,banji,xueyuan,zhuanye;//name姓名、sex性别、xuehao学号、banji班级、xueyuan学院、zhuanye专业
	void input();//输入
	void output();//输出
	people(void);
	~people(void);
};

