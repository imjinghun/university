#include<iostream>
using namespace std;
#define m 2
#define n 3

void main()
{
	int i,j;
	double a[m][n],b[n][n];
	cout<<"输入行列分别为"<<m<<","<<n<<"的矩阵"<<endl;
	for(i=0;i<m;i++)
		for(j=0;j<n;j++)
			cin>>a[i][j];
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			b[j][i]=a[i][j];
	cout<<"矩阵转置"<<endl;
	for(i=0;i<n;i++)
	{
		for(j=0;j<m;j++)
			cout<<b[i][j]<<" ";
		cout<<endl;
	}
}