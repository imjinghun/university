#include<iostream>
#include<string>
using namespace std;
void main()
{
	char a;
	double b,c;
	cout<<"�����������"<<endl;
	cin>>a;
	cout<<"������Ҫ�������"<<endl;
	cin>>b>>c;
	cout<<b<<a<<c<<"="<<endl;
	switch(a)
	{
	case'+':cout<<b+c<<endl;break;
	case'-':cout<<b-c<<endl;break;
	case'*':cout<<b*c<<endl;break;
	case'.':cout<<b*c<<endl;break;
	case'/':cout<<b/c<<endl;break;
	default:cout<<"�޴����㷨"<<endl;break;
	}
}