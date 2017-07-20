#pragma once
#include"people.h"

class student:public people
{
	int studentID;
public:
	student(void);
	student(int);
	~student(void);
	void setID(int m);
	void display(void);
};
