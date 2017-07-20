#include<iostream>
using namespace std;
#define n 5
void main()
{
	int i,j,a[n][n];
	a[0][0]=2;
	for(i=0;i<n;i++)
		for(j=i+1;j<n;j++)
			a[i][j]=0;
	for(i=1;i<n;i++)
	{
		a[i][0]=a[i-1][i-1]+2;
		for(j=1;j<n;j++)
		{
			a[i][j]=a[i][j-1]+2;
			if(i==j)
				break;
		}
	}
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
			cout<<a[i][j]<<" ";
		cout<<endl;	
	}
}