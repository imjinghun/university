#include<iostream>
using namespace std;
void main()
{
	int a,b,t,i,j,x,m=0;
	cout<<"输入两个整数"<<endl;
	cin>>a>>b;
	if(a>b)
	{
		t=a;
		a=b;
		b=t;
	}
	for(i=a;i<=b;i++)
	{
		x=0;
		for(j=1;j<=i;j++)
			if(i%j==0)
				x++;
		if(x<=2)
		{
			cout<<i<<" ";
			m++;
			if(m%5==0)
				cout<<endl;
		}

	}
}