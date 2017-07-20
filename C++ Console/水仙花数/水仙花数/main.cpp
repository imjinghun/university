#include<iostream>
using namespace std;
bool sxh(int a)
{
	bool f;
	int b,c,d;
	b=a%10;
	c=(a/10)%10;
	d=(a/100)%10;
	if(a==b*b*b+c*c*c+d*d*d)
		f=true;
	else
		f=false;
	return f;
}
void main()
{
	int i;
	bool f;
	cout<<"Ë®ÏÉ»¨Êý"<<endl;
	for(i=100;i<1000;i++)
	{
		f=sxh(i);
		if(f==true)
			cout<<i<<endl;
	}
}