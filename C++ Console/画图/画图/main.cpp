#include<iostream>
using namespace std;

void main()
{
	int i,j,k,*p,n;
	char a;
	cout<<"输入要输出的花型及上半部分行数"<<endl;
	cin>>a>>n;
	p=new int[n];

	for(i=0;i<n;i++)
	{
		for(k=0;k<n-i;k++)
			cout<<" ";
		for(j=0;j<=i;j++)
		{
			cout<<a<<" ";
			if(i==j)
				cout<<endl;
		}
	}
	for(i=n-1;i>0;i--)
	{
		for(k=0;k<n-i+1;k++)
			cout<<" ";
		for(j=0;j<i;j++)
		{
			cout<<a<<" ";
			if(j==i-1)
				cout<<endl;
		}
	}
	delete[]p;
}