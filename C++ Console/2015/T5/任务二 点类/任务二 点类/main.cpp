//点类 王占京 2015 3 25
#include<iostream>
#include "point.h"
using namespace std;
void main()
{
	double q,w,e;
	point a(1,2,3);
	cout<<"输入x y z值"<<endl;
	cin>>q>>w>>e;
	a.setx(q);
	a.getx();
	a.sety(w);
	a.gety();
	a.setz(e);
	a.getz();
}