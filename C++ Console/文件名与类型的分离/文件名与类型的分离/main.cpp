#include<iostream>
#include<string>
using namespace std;
void main()
{
	string a;
	int c,d;

	cout<<"输入一个文件名及其类型（如abc.doc）"<<endl;
	cin>>a;

	c=a.length();
	d=a.find(".");


	cout<<"输入文件的长度及“.“的位置"<<endl;
	cout<<c<<" "<<d<<endl;

	string b(a,d+1,c-d);
	string e(a,0,d);

	cout<<"文件名"<<e<<endl;
	cout<<"类型"<<b<<endl;

}