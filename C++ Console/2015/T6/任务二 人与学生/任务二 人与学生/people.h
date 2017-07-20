#pragma once
#include<string>
#include<iostream>
using namespace std;
class people
{
protected:
	int age;
	string name;
public:
	people(void);
	people(int m,string str);
	~people(void);
	void setvalue(int m,string str);
	void display();
};
