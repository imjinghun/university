#include<iostream>
#include<cctype>
using namespace std;

void main()
{
	char a,b;
	cout<<"����һ����д��ĸ��Сд��ĸ"<<endl;
	cin>>a>>b;
	cout<<a<<"��Сд "<<tolower(a)<<endl;
	cout<<b<<"�Ĵ�д "<<toupper(b)<<endl;
}