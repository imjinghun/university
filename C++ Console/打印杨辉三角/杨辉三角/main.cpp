#include<iostream>
#include<new>
using namespace std;

void main()
{
	int **a,n;
	int i,j,k;
	cout<<"输入杨辉三角行数"<<endl;
	cin>>n;
	a=new int*[n];
	for(i=0;i<n;i++)
		*(a+i)=new int[n];

	
	for(i=0;i<n;i++)
		for(j=0;j<=i;j++)
		{
			if(i==j||j==0)
				a[i][j]=1;
			else
				a[i][j]=a[i-1][j]+a[i-1][j-1];
		}
	for(i=0;i<n;i++)
	{
		for(k=0;k<n-i;k++)
			cout<<" ";
		for(j=0;j<=i;j++)
			cout<<a[i][j]<<" ";
		cout<<endl;
	}
	for(i=0;i<n;i++)
		delete[]a[i];
	delete[]a;
}