#include<iostream>
#include<cctype>
using namespace std;

void main()
{
	char a,b,c,d;
	cout<<"����һ����д��ĸ��Сд��ĸ"<<endl;
	cin>>a>>b;

	c=tolower(a);
	d=toupper(b);
	cout<<a<<"��Сд "<<c<<endl;
	cout<<b<<"�Ĵ�д "<<d<<endl;
}