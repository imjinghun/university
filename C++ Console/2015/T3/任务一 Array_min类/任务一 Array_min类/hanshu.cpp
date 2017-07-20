//求最小数 王占京 2015 3 17
#include<iostream>
#include "Arraymin.h"
using namespace std;

void arraymin::input()
{
	int i;
	cout<<"输入10个数"<<endl;
	for(i=0;i<10;i++)
		cin>>a[i];
}
void arraymin::yunxing()
{
	int i;
	for(i=0;i<10;i++)
		if(a[0]>a[i])
			a[0]=a[i];
}
void arraymin::output()
{
	cout<<"最小数"<<a[0]<<endl;
}