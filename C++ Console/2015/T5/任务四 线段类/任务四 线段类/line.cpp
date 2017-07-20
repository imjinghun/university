#include<iostream>
#include<cmath>
#include "line.h"
using namespace std;

void line::input()
{
	cout<<"输入两个三维坐标"<<endl;
	cin>>p.x>>p.y>>p.z;
	cin>>q.x>>q.y>>q.z;
}
void line::output()
{
	double c;
	c=sqrt((p.x-q.x)*(p.x-q.x)+(p.y-q.y)*(p.y-q.y)+(p.z-q.z)*(p.z-q.z));
	cout<<"线段距离"<<c<<endl;
}
line::line()
{
	cout<<"构造"<<endl;
}
line::~line()
{
	cout<<"析构"<<endl;
}