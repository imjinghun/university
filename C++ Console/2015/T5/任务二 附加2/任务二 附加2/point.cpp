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
	cout<<"�����ֵ "<<x<<" "<<y<<" "<<z<<endl;
}
point::~point(void)
{
	cout<<"����ĩֵ "<<x<<" "<<y<<" "<<z<<endl;
}
void point::setx(double aa)
{
	x=aa;
}
double point::getx()
{
	cout<<"����xֵ "<<x<<endl;
	return x;
}
void point::sety(double bb)
{
	y=bb;
}
double point::gety()
{
	cout<<"����yֵ "<<y<<endl;
	return y;
}
void point::setz(double cc)
{
	z=cc;
}
double point::getz()
{
	cout<<"����zֵ "<<z<<endl;
	return z;
}