
#include<iostream>
#include "point.h"
using namespace std;
void main()
{
	double q,w,e;
	point a(1,2,3),*p;
	p=&a;
	cout<<"ÊäÈëx y zÖµ"<<endl;
	cin>>q>>w>>e;
	p->setx(q);
	p->getx();
	p->sety(w);
	p->gety();
	p->setz(e);
	p->getz();
}