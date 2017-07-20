#pragma once
#include<iostream>
#include<string>
using namespace std;

class teacher
{
	double salary;
	string name,num;
public:

	teacher(double s=0, string n="0000", string na="qw")
	{
		salary=s;
		num=n;
		name=na;
	}
	~teacher(void);
	void setsalary(double s){salary=s;}
	void setnum(string n){num=n;}
	void setname(string na){name=na;}
	double getsalary(){return salary;}
	string getnum(){return num;}
	string getname(){return name;}
	void display(){cout<<num<<" "<<name<<" "<<salary<<endl;}
	void paixu(teacher a[]);
};
