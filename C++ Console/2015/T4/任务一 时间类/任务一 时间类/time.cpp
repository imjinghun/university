#include<iostream>
#include "Time.h"
using namespace std;

void time::sethour(int h) //Сʱ
{
	hour=h;
}
int time::gethour()
{
	return hour;
}

void time::setmin(int m) //����
{
	min=m;
}
int time::getmin()
{
	return min;
}
void time::setsec(int s) //����
{
	sec=s;
}
int time::getsec()
{
	return sec;
}
void time::showtime24()//24Сʱ��
{
	cout<<"���24Сʱ��ʱ��"<<endl;
	cout<<gethour()<<":"<<getmin()<<":"<<getsec()<<endl;
}
void time::showtime12()
{
	cout<<"���12Сʱ��ʱ��"<<endl;
	if(hour>12)
		cout<<gethour()-12<<":"<<getmin()<<":"<<getsec()<<endl;
	else
		cout<<gethour()<<":"<<getmin()<<":"<<getsec()<<endl;
}