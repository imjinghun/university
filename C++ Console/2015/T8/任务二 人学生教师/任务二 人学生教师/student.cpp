#include "student.h"

student::student(void)
{
}
student::student(int I)
{
	studentID=I;
}
student::~student(void)
{
}
void student::setID(int m)
{
	studentID=m;
}
void student::display(void)
{
	cout<<name<<" "<<age<<" "<<studentID<<endl;
}
