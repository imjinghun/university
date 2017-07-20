#pragma once
#include <iostream>
using namespace std;

class fenshu
{
	int fenz,fenm;
public:
	fenshu(void);
	~fenshu(void);
	friend fenshu operator+(fenshu a,fenshu b);
	friend fenshu operator-(fenshu a,fenshu b);
	friend fenshu operator*(fenshu a,fenshu b);
	friend istream&operator>>(istream&,fenshu&);
	friend ostream&operator<<(ostream&,fenshu&);
};
