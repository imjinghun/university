#pragma once
#include<iostream>
using namespace std;
class vector
{
	double x,y,z;
public:
	vector(void);
	vector(double x,double y,double z);
	~vector(void);
	friend istream&operator>>(istream&,vector&);
	friend ostream&operator<<(ostream&,vector&);
	friend vector operator+(vector A,vector B);
	friend vector operator-(vector A,vector B);
	friend double operator*(vector A,vector B);
};
