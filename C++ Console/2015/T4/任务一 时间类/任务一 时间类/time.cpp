#include<iostream>
#include "Time.h"
using namespace std;

void time::sethour(int h) //小时
{
	hour=h;
}
int time::gethour()
{
	return hour;
}

void time::setmin(int m) //分钟
{
	min=m;
}
int time::getmin()
{
	return min;
}
void time::setsec(int s) //秒钟
{
	sec=s;
}
int time::getsec()
{
	return sec;
}
void time::showtime24()//24小时制
{
	cout<<"输出24小时制时间"<<endl;
	cout<<gethour()<<":"<<getmin()<<":"<<getsec()<<endl;
}
void time::showtime12()
{
	cout<<"输出12小时制时间"<<endl;
	if(hour>12)
		cout<<gethour()-12<<":"<<getmin()<<":"<<getsec()<<endl;
	else
		cout<<gethour()<<":"<<getmin()<<":"<<getsec()<<endl;
}