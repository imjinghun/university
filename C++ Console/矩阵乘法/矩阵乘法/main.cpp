#include<iostream>
using namespace std;
#define m 2
#define n 3

void main()
{
	int i,j,k;
	double a[m][n],b[n][m],c[n][n];
	cout<<"�������зֱ�Ϊ"<<m<<","<<n<<"�ľ���"<<endl;
	for(i=0;i<m;i++)
		for(j=0;j<n;j++)
			cin>>a[i][j];
	cout<<"�������зֱ�Ϊ"<<n<<","<<m<<"�ľ���"<<endl;
	for(i=0;i<n;i++)
		for(j=0;j<m;j++)
			cin>>b[i][j];
	for(i=0;i<n;i++)
		for(k=0;k<n;k++)
		{
			c[i][k]=0;
			for(j=0;j<n;j++)
				c[i][k]+=a[i][j]*b[j][i];
		}
	cout<<"������˽��"<<endl;
	for(i=0;i<m;i++)
	{
		for(j=0;j<m;j++)
			cout<<c[i][j]<<" ";
		cout<<endl;
	}
}