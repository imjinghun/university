//输出某天为某年中的第几天 王占京 2015 3 5
#include<iostream>
using namespace std;
struct day
{
	int a,b,c;	//a b c 分别为 年月日
};
day input()//输入日期
{
	day d;
	cout<<"输入年月日"<<endl;
	cin>>d.a>>d.b>>d.c;
	return d;
}
bool runnian(int a)//闰年判断
{
	bool flag;
	if(a%100==0)
	{
		if(a%400==0)
			flag=true;
		else
			flag=false;
	}
	if(a%100!=0)
	{
		
		if(a%4==0)
			flag=true;
		else 
			flag=false;
	}		
	return flag;
}

void shuchu(day d)//输出
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

	f=runnian(d.a);
	if(f==true)
		a[1]=29;
	else 
		a[1]=28;

	for(i=0;i<d.b-1;i++)
		e+=a[i];
	j=e+d.c;
	cout<<"此日为此年的第 "<<j<<" 天"<<endl;
}
void main()
{
	day k;
	k=input();
	shuchu(k);
}