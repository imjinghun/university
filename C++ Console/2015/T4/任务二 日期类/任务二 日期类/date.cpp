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
	cout<<"中式日期表示"<<endl;
	cout<<getyear()<<" 年 "<<getmon()<<" 月 "<<getday()<<" 日 "<<endl;
}
void date::displayAmericaDate()
{
	cout<<"美式日期表示"<<endl;
	cout<<getmon()<<" "<<getday()<<","<<getyear()<<endl;
}