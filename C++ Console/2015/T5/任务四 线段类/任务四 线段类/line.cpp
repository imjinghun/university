#include<iostream>
#include<cmath>
#include "line.h"
using namespace std;

void line::input()
{
	cout<<"����������ά����"<<endl;
	cin>>p.x>>p.y>>p.z;
	cin>>q.x>>q.y>>q.z;
}
void line::output()
{
	double c;
	c=sqrt((p.x-q.x)*(p.x-q.x)+(p.y-q.y)*(p.y-q.y)+(p.z-q.z)*(p.z-q.z));
	cout<<"�߶ξ���"<<c<<endl;
}
line::line()
{
	cout<<"����"<<endl;
}
line::~line()
{
	cout<<"����"<<endl;
}