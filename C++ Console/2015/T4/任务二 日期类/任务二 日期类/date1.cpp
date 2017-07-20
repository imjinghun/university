#include<iostream>
#include "date.h"
using namespace std;

bool date::runnian()//闰年判断
{
	bool flag;
	if(year%100==0)
	{
		if(year%400==0)
			flag=true;
		else
			flag=false;
	}
	if(year%100!=0)
	{
		
		if(year%4==0)
			flag=true;
		else 
			flag=false;
	}		
	return flag;
}

void date::numbersOfDate()
{
	int e=0,i,j,a[12];
	bool f;
	for(i=0;i<12;i++)
	{
		if(i==0||i==2||i==4||i==6||i==7||i==9||i==11)
			a[i]=31;
		if(i==3||i==5||i==8||i==10)
			a[i]=30;
	}

	f=runnian();
	if(f==true)
		a[1]=29;
	else 
		a[1]=28;

	for(i=0;i<mon-1;i++)
		e+=a[i];
	j=e+day;
	cout<<"此日为此年的第 "<<j<<" 天"<<endl;
}