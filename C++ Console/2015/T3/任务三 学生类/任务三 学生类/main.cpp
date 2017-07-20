//学生类 王占京 2015 3 19
#include<iostream>
#include<string>
#include "student.h"
using namespace std;

void main()
{
	stdu c[3];
	int x;
	string y;
	int i;
	cout<<"输入学生年龄姓名"<<endl;
	for(i=0;i<3;i++)
	{
		cin>>x>>y;
		c[i].input(x,y);
	}
	cout<<"输出学生信息"<<endl;
	for(i=0;i<3;i++)
		c[i].output();
}