#include<iostream>
#include<cctype>
using namespace std;

void main()
{
	char a,b,c,d;
	cout<<"输入一个大写字母和小写字母"<<endl;
	cin>>a>>b;

	c=tolower(a);
	d=toupper(b);
	cout<<a<<"的小写 "<<c<<endl;
	cout<<b<<"的大写 "<<d<<endl;
}