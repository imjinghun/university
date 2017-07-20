#include<iostream>
using namespace std;
#define n 5
void main()
{
	int i,j,k;
	double a[n],b,c,d;
	cout<<"有序输入"<<n<<"个数"<<endl;
	for(i=0;i<n;i++)
		cin>>a[i];
	cout<<"输入要查找的数"<<endl;
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