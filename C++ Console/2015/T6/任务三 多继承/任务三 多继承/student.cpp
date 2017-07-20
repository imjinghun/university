#include "student.h"
#include<iostream>
#include<string>
using namespace std;
void student::input()
{
	cout<<"输入学号班级姓名"<<endl;
	cin>>xh>>bj>>xm;
}
void student::output()
{
	cout<<"输出学号班级姓名 "<<xh<<" "<<bj<<" "<<xm<<endl;
}

student::student(void)
{
}

student::~student(void)
{
}
