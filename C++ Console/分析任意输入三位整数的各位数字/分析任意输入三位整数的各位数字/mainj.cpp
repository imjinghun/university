#include<iostream>
using namespace std;

void main()
{
	int a,c,i;
	cout<<"输入一个三位数"<<endl;
	cin>>a;
	c=a%10;
	int b[2];
	for(i=0;i<2;i++)
	{	a=a/10;
		b[i]=a%10;
	}
	for(i=2;i>0;i--)
		cout<<b[i-1]<<endl;
	cout<<c<<endl;

}