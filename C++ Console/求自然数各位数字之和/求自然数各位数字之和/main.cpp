#include<iostream>
using namespace std;

void main()
{
	int a,c,i;
	cout<<"����һ����λ��"<<endl;
	cin>>a;
	c=a%10;
	int b[2];
	for(i=0;i<2;i++)
	{	a=a/10;
		b[i]=a%10;
	}
	for(i=0;i<2;i++)
	{
		c=c+b[i];
	}
		
	cout<<c<<endl;

}