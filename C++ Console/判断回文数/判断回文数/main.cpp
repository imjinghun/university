#include<iostream>
#include<new>
using namespace std;

void main()
{
	int i,t,j=0,k,*a,*b;
	cout<<"输入一个大于等于二位数的整数"<<endl;
	cin>>i;
	t=i;
	while(1)//判断输入数的位数
	{
		i=i/10;
		j++;
		if(i==0)
			break;
	}
	a=new int[j];
	b=new int[j];
	a[0]=t%10;
	for(k=1;k<j;k++)
	{
		t=t/10;
		a[k]=t%10;
	}
	for(k=0;k<j/2;k++)
	{
		b[k]=a[j-k-1];
	}
	int m=0;
	for(k=0;k<j/2;k++)
		if(a[k]==b[k])
			m++;
	if(m==j/2)
		cout<<"是回文数"<<endl;
	else
			cout<<"不是回文数"<<endl;

	delete []a;

}