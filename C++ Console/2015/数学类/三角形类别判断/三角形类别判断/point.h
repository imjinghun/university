#pragma once
#include<iostream>
#include<cmath>
using namespace std;
class point
{
	double x,y;
public:
	double juli(point b,point d);
	friend istream&operator>>(istream& input,point& p);
	point(void);
	~point(void);
};

