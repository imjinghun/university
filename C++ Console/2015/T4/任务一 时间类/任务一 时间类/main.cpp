//ʱ���� ��ռ�� 2015 3 26
#include<iostream>
#include "Time.h"
using namespace std;
void main()
{
	int h,m,s;
	cout<<"����Сʱ"<<endl;
	cin>>h;
	while(1)
	{
		if(h<0||h>23)
		{
			cout<<"��ʽ��������������Сʱ"<<endl;
			cin>>h;
		}
		else
			break;
	}
	cout<<"�������"<<endl;
	cin>>m;
	while(1)
	{
		if(m<0||m>59)
		{
			cout<<"��ʽ�����������������"<<endl;
			cin>>m;
		}
		else
			break;
	}
	cout<<"��������"<<endl;
	cin>>s;
	while(1)
	{
		if(s<0||s>59)
		{
			cout<<"��ʽ������������������"<<endl;
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