#include<iostream>
#define n 5
using namespace std;
void zui(double b[n][n])
{
	int i,j,k;
	double t,c[n],q;
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
	}
	q=c[0];
	for(i=0;i<n;i++)
		if(c[0]>c[i])
			q=c[i];
	cout<<"ÿ�����ֵ�е���Сֵ"<<q;
}
void main()
{
	int i,j;
	double a[n][n];
	cout<<"�������о�Ϊ"<<n<<"�ľ���"<<endl;
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			cin>>a[i][j];

	zui(a);


}