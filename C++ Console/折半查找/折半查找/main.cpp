#include<iostream>
using namespace std;
#define n 5
void main()
{
	int i,j,k;
	double a[n],b,c,d;
	cout<<"��������"<<n<<"����"<<endl;
	for(i=0;i<n;i++)
		cin>>a[i];
	cout<<"����Ҫ���ҵ���"<<endl;
	cin>>b;
	if(a[0]<=b&&a[n-1]>=b)
	{
		c=n;
		while(1)
		{
			c=c/2;
			if(b<=a[c]&&b>=a[0])
		}
	}
}