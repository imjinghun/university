#include<iostream>
#define n 4
using namespace std;
void main()
{
	int i,j,k,l;
	double a[n][n];
	cout<<"�������о�Ϊ"<<n<<"�ľ���"<<endl;
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			cin>>a[i][j];

	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
		{
			double p,q,r;
			p=a[i][j];
			q=a[i][0];
			r=a[0][j];

			for(k=0;k<n;k++)
				if(q<a[i][k])
					q=a[i][k];//qΪ�������

		
			for(l=0;l<n;l++)
				if(r>a[l][j])
					r=a[l][j];//r������С

			if(p==q&&p==r)
				cout<<p<<"  �� "<<i+1<<" �� "<<j+1<<" ��Ϊ����"<<endl;
		}
}