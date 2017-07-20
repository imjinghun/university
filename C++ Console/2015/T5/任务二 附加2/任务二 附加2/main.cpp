#include<iostream>
#include "point.h"
using namespace std;
void main()
{
	int i;
	point a(1,2,3),p[3];
	cout<<"ÊäÈëx y zÖµ"<<endl;
	for(i=0;i<3;i++)
	{
		double q,w,e;
		cin>>q>>w>>e;
		p[i].setx(q);
		p[i].getx();
		p[i].sety(w);
		p[i].gety();
		p[i].setz(e);
		p[i].getz();
	}
}