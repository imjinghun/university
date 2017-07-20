// 日期类 王占京 2015 3 26
#include<iostream>
#include "date.h"
using namespace std;
void main()
{
	int y,m,d;
	date rq;
	cout<<"输入年份"<<endl;
	cin>>y;
	while(1)
	{
		if(y<1)
		{
			cout<<"格式错误，重新输入年份"<<endl;
			cin>>y;
		}
		else
			break;
	}
	cout<<"输入月份"<<endl;
	cin>>m;
	while(1)
	{
		if(m<1||m>12)
		{
			cout<<"格式错误，重新输入月份"<<endl;
			cin>>m;
		}
		else
			break;
	}
	cout<<"输入日"<<endl;
	cin>>d;
	while(1)
	{
		if(m==2)
		{
			bool f;
			f=rq.runnian();
			if(f==true)
			{
				if(d>29||d<1)
				{
					cout<<"格式错误，重新输入日"<<endl;
					cin>>d;
				}
			}
			else 
				if(d>28||d<1)
				{
					cout<<"格式错误，重新输入日"<<endl;
					cin>>d;
				}
		}
		if(m==1||m==3||m==5||m==8||m==10||m==12)
		{
			if(d>31||d<1)
			{
				cout<<"格式错误，重新输入日"<<endl;
				cin>>d;
			}
		}
		if(m==4||m==6||m==9||m==11)
		{
			if(d>30||d<1)
			{
				cout<<"格式错误，重新输入日"<<endl;
				cin>>d;
			}
		}
		else
			break;
	}
	
	rq.setyear(y);
	rq.setmon(m);
	rq.setday(d);
	rq.getyear();
	rq.getmon();
	rq.getday();
	rq.displayChineseDate();
	rq.displayAmericaDate();
	bool fl;
	fl=rq.runnian();
	if(fl==true)
		cout<<"此年为闰年"<<endl;
	else
		cout<<"此年不是闰年"<<endl;
	rq.numbersOfDate();
}