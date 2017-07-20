#include<iostream>
using namespace std;

void main()
{
	int i,j;
	double a[9][9];
	for(j=0;j<9;j++)	
		for(i=0;i<9;i++)
			a[i][j]=(i+1)*(j+1);
	for(i=0;i<9;i++)
	{
		for(j=0;j<=i;j++)
			cout<<j+1<<"x"<<i+1<<"="<<a[i][j]<<" ";
		cout<<endl;
	}
}