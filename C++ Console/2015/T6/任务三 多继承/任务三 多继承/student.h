#pragma once
#include<string>
using namespace std;
class student
{
protected:
	int xh;
	string xm,bj;
public:
	student(void);
	~student(void);
	void input();
	void output();
};
