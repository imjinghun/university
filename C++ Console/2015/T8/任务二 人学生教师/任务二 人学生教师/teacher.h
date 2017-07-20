#pragma once
#include"people.h"
class teacher: public people
{
	int teacherID;
public:
	teacher(void);
	teacher(int ID){teacherID=ID;};
	~teacher(void);
	void setID(int m);
	void display(void);
};
