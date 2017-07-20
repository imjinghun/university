#include<iostream>
#include "point.h"
using namespace std;

point::point()
{}
point::point(double a, double b, double c)
{
	x=a;
	y=b;
	z=c;
	cout<<"构造初值 "<<x<<" "<<y<<" "<<z<<endl;
}
point::~point(void)
{
	cout<<"析构末值 "<<x<<" "<<y<<" "<<z<<endl;
}
void point::setx(double aa)
{
	x=aa;
}
double point::getx()
{
	cout<<"返回x值 "<<x<<endl;
	return x;
}
void point::sety(double bb)
{
	y=bb;
}
double point::gety()
{
	cout<<"返回y值 "<<y<<endl;
	return y;
}
void point::setz(double cc)
{
	z=cc;
}
double point::getz()
{
	cout<<"返回z值 "<<z<<endl;
	return z;
}