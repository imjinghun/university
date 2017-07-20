//计算矩形的周长 王占京 2015 3 15
#include<iostream>
#include "矩形.h"
using namespace std;
void main()
{
	chang e;
	double c,d;
	cout<<"输入矩形长宽"<<endl;
	cin>>c>>d;
	e.zhouchang(c,d);
	cout<<"周长"<<e.length()<<endl;

}