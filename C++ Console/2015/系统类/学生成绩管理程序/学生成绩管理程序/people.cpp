#include "people.h"

void people::input()
{
	cin>>xuehao>>name>>chinese>>math>>english;
}
void people::output()
{
	people p;
	pjfen=p.pingjun();
	zfen=p.zongfen();
	cout<<xuehao<<" "<<name<<" "<<chinese<<" "<<math<<" "<<english<<" "<<pjfen<<" "<<zfen<<endl;
}
double people::zongfen()
{
	double zf;
	zf=chinese+math+english;
	return zf;
}
double people::pingjun()
{
	double pj;
	pj=(chinese+math+english)/3;
	return pj;
}
people::people(void)
{
}

people::~people(void)
{
}
