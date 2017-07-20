#include<iostream>
#include<cmath>
#include "point.h"
using namespace std;
void dian::input()
{
	cout<<"输入三维坐标"<<endl;
	cin>>x>>y>>z;
}
void dian::output()
{
	cout<<"点坐标"<<endl;
	cout<<x<<","<<y<<","<<z<<endl;
	double j;
	j=sqrt(x*x+y*y+z*z);
	cout<<"距原点距离 "<<j<<endl;
}
void dian::fanx()
{
	cout<<"返回x坐标"<<endl;
	cout<<x<<endl;
}
void dian::fany()
{
	cout<<"返回y坐标"<<endl;
	cout<<y<<endl;
}
void dian::fanz()
{
	cout<<"返回z坐标"<<endl;
	cout<<z<<endl;
}