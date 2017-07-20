#include "fushu.h"
#include<iostream>
using namespace std;

fushu add(fushu a,fushu b)
{
	fushu c;
	c.real=a.real+b.real;
	c.image=a.image+b.image;
	cout<<"加法"<<endl;
	cout<<c.real<<" + "<<c.image<<"i"<<endl;
	return c;
}
fushu jian(fushu a,fushu b)
{
	fushu c;
	c.real=a.real-b.real;
	c.image=a.image-b.image;
	cout<<"减法"<<endl;
	cout<<c.real<<" + "<<c.image<<"i"<<endl;
	return c;
}
fushu cheng(fushu a,fushu b)
{
	fushu c;
	c.real=a.real*b.real-a.image*b.image;
	c.image=a.real*b.image+a.image*b.real;
	cout<<"乘法"<<endl;
	cout<<c.real<<" + "<<c.image<<"i"<<endl;
	return c;
}
fushu chu(fushu a,fushu b)
{
	fushu c;
	c.real=(a.real*b.real+a.image*b.image)/(b.real*b.real+b.image*b.image);
	c.image=(a.real*b.image+a.image*b.real)/(b.real*b.real+b.image*b.image);
	cout<<"除法"<<endl;
	cout<<c.real<<" + "<<c.image<<"i"<<endl;
	return c;
}

fushu::fushu(double x,double y)
{
	real=x;
	image=y;
}

fushu::fushu(void)
{
}

fushu::~fushu(void)
{
}
