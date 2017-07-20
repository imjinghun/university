#pragma once
#include"people.h"

class student:public people
{
private:
	int ID;
public:
	student(void);
	student(int m,string str,int n):people(m,str),ID(n){};
	~student(void);
	void setID(int m);
	void displayID();
};
