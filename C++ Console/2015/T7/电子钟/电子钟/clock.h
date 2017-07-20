#pragma once
#include<iostream>
using namespace std;
class clock
{public:
 int hou,min,sec;
public:
	clock(int hou=0,int min=0,int sec=0)
	{
	this->hou=hou;this->min=min;this->sec=sec;
	}
	~clock(void);
	
	 clock  clock::operator ++ ()
	 {return clock(hou,min,++sec);}
	 clock operator++(int)
	 {return clock(hou,min,++sec);}
	 clock  clock::operator -- ()
	 {return clock(hou,min,--sec);}
	 clock clock::operator --(int)
	 {return clock(hou,min,--sec);}
	friend istream& operator>>(istream&,clock&);
	friend ostream& operator<<(ostream&,clock&);

};