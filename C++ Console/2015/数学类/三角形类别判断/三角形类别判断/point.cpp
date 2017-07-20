#include "point.h"
istream&operator>>(istream& input,point& p)
{
	input>>p.x>>p.y;
	return input;
}
double point::juli(point b,point d)
{
	double c;
	c=sqrt((b.x-d.x)*(b.x-d.x)+(b.y-d.y)*(b.y-d.y));
	return c;
}

point::point(void)
{
}

point::~point(void)
{
}
