#include<iostream>
#include<cmath>
#include "point.h"
using namespace std;
void dian::input()
{
	cout<<"������ά����"<<endl;
	cin>>x>>y>>z;
}
void dian::output()
{
	cout<<"������"<<endl;
	cout<<x<<","<<y<<","<<z<<endl;
	double j;
	j=sqrt(x*x+y*y+z*z);
	cout<<"��ԭ����� "<<j<<endl;
}
void dian::fanx()
{
	cout<<"����x����"<<endl;
	cout<<x<<endl;
}
void dian::fany()
{
	cout<<"����y����"<<endl;
	cout<<y<<endl;
}
void dian::fanz()
{
	cout<<"����z����"<<endl;
	cout<<z<<endl;
}