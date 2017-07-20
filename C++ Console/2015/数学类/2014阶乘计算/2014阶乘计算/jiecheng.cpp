#include "jiecheng.h"
void jiecheng::jiech()
{
	int i,j,k,s,a[10000];//使数组长度很大
	for(i=0;i<10000;i++)
		a[i]=0;
	a[0]=1;
	for(i=2;i<=2014;i++)		
	{
		k=0;
		for(j=0;j<10000;j++)	//使小于10的数乘以i，把阶乘结果依次拆开 	
		{
			s=a[j]*i+k;
			a[j]=s%10;
			k=s/10;
		}
	}
	for(j=9999;j>=0;j--)  
		if(a[j])	//a[j]不为0，则执行if语句，终止循环，得到j值
			break;  
	cout<<"2014阶乘为： "<<endl;	//从第一个不为0的数输出
	for(i=j;i>=0;i--)
		cout<<a[i];
	cout<<endl;
}
jiecheng::jiecheng(void)
{
}

jiecheng::~jiecheng(void)
{
}
