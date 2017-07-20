#pragma once
#include<iostream>
#include<string>
using namespace std;
class people
{
protected:
	int age;
	string name;
public:
	people(void);
	people(int a,string n){age=a;name=n;};
	~people(void);
	void setvalue(int m,string str);
	virtual void display(void)=0;
};
