#include "teacher.h"

teacher::teacher(void)
{
}

teacher::~teacher(void)
{
}
void teacher::setID(int m)
{
	teacherID=m;
}
void teacher::display(void)
{
	cout<<name<<" "<<age<<" "<<teacherID<<endl;
}