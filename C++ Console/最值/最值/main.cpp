#include<iostream>
#define n 5
using namespace std;
void zui(double b[n][n])
{
	int i,j,k;
	double t,c[n],d[n];
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
			for(k=j+1;k<n;k++)
				if(b[i][j]<b[i][k])
				{
					t=b[i][j];
					b[i][j]=b[i][k];
					b[i][k]=t;
				}
		c[i]=b[i][0];
		d[i]=b[i][n-1];
	}
	cout<<"每行最大值最小值"<<endl;
	for(i=0;i<n;i++)
	   cout<<c[i]<<" "<<d[i]<<endl;
}
void zui1(double b[n][n])
{
	int i,j,k;
	double t,c[n],d[n];
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
			for(k=j+1;k<n;k++)
				if(b[i][j]<b[i][k])
				{
					t=b[j][i];
					b[j][i]=b[k][i];
					b[k][i]=t;
				}
		c[i]=b[0][i];
		d[i]=b[n-1][i];
	}
	cout<<"每列最大值最小值"<<endl;
	for(i=0;i<n;i++)
	   cout<<c[i]<<" "<<d[i]<<endl;
}
void main()
{
	int i,j;
	double a[n][n];
	cout<<"输入行列均为"<<n<<"的矩阵"<<endl;
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			cin>>a[i][j];

	zui(a);
	zui1(a);


}