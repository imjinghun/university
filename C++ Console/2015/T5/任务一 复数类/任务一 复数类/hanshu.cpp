#include<iostream>
#include "fushu.h"
using namespace std;

fushu::fushu(double x,double y)
{
	a=x;
	b=y;	
	cout<<a<<" + "<<b<<"i"<<endl;
}
fushu::~fushu()
{
	cout<<a<<" + "<<b<<"i"<<endl;
}
