#include<iostream>
#include<string>
using namespace std;
void main()
{
	char a;
	double b,c;
	cout<<"输入运算符号"<<endl;
	cin>>a;
	cout<<"输入需要运算的数"<<endl;
	cin>>b>>c;
	cout<<b<<a<<c<<"="<<endl;
	switch(a)
	{
	case'+':cout<<b+c<<endl;break;
	case'-':cout<<b-c<<endl;break;
	case'*':cout<<b*c<<endl;break;
	case'.':cout<<b*c<<endl;break;
	case'/':cout<<b/c<<endl;break;
	default:cout<<"无此运算法"<<endl;break;
	}
}