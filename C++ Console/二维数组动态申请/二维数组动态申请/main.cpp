#include<iostream>
#include<new>
using namespace std;

void main()
{
	int **a;
	int r,c,i,j;
	cout<<"输入矩阵行数列数"<<endl;
	cin>>r>>c;

	a=new int*[r];
	for(i=0;i<r;i++)
		*(a+i)=new int[c];

	cout<<"输入行列为"<<r<<" "<<c<<"的矩阵"<<endl;
	for(i=0;i<r;i++)
		for(j=0;j<c;j++)
			cin>>a[i][j];
	for(i=0;i<r;i++)
	{
		for(j=0;j<c;j++)
			cout<<a[i][j]<<" ";
		cout<<endl;
	}
	for(i=0;i<r;i++)	
		delete []a[i];
	delete []a;
}