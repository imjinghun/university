#include<iostream>
#include "date.h"
using namespace std;

void date::setyear(int y)
{
	year=y;
}
int date::getyear()
{
	return year;
}
void date::setmon(int m)
{
	mon=m;
}
int date::getmon()
{
	return mon;
}
void date::setday(int d)
{
	day=d;
}
int date::getday()
{
	return day;
}
void date::displayChineseDate()
{
	cout<<"��ʽ���ڱ�ʾ"<<endl;
	cout<<getyear()<<" �� "<<getmon()<<" �� "<<getday()<<" �� "<<endl;
}
void date::displayAmericaDate()
{
	cout<<"��ʽ���ڱ�ʾ"<<endl;
	cout<<getmon()<<" "<<getday()<<","<<getyear()<<endl;
}