#include<iostream>
#include<string>
using namespace std;
void main()
{
	string a;
	int c,d;

	cout<<"����һ���ļ����������ͣ���abc.doc��"<<endl;
	cin>>a;

	c=a.length();
	d=a.find(".");


	cout<<"�����ļ��ĳ��ȼ���.����λ��"<<endl;
	cout<<c<<" "<<d<<endl;

	string b(a,d+1,c-d);
	string e(a,0,d);

	cout<<"�ļ���"<<e<<endl;
	cout<<"����"<<b<<endl;

}