#include<iostream>
#include<cctype>
using namespace std;

void main()
{
	char a,b;
	cout<<"输入一个大写字母和小写字母"<<endl;
	cin>>a>>b;
	cout<<a<<"的小写 "<<tolower(a)<<endl;
	cout<<b<<"的大写 "<<toupper(b)<<endl;
}