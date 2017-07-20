//时间类 王占京 2015 3 26
#include<iostream>
#include "Time.h"
using namespace std;
void main()
{
	int h,m,s;
	cout<<"输入小时"<<endl;
	cin>>h;
	while(1)
	{
		if(h<0||h>23)
		{
			cout<<"格式错误，请重新输入小时"<<endl;
			cin>>h;
		}
		else
			break;
	}
	cout<<"输入分钟"<<endl;
	cin>>m;
	while(1)
	{
		if(m<0||m>59)
		{
			cout<<"格式错误，请重新输入分钟"<<endl;
			cin>>m;
		}
		else
			break;
	}
	cout<<"输入秒钟"<<endl;
	cin>>s;
	while(1)
	{
		if(s<0||s>59)
		{
			cout<<"格式错误，请重新输入秒钟"<<endl;
			cin>>s;
		}
		else
			break;
	}
	time a;
	a.sethour(h);
	a.gethour();
	a.setmin(m);
	a.getmin();
	a.setsec(s);
	a.getsec();
	a.showtime24();
	a.showtime12();
}