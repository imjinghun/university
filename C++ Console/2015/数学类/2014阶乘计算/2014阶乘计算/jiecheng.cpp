#include "jiecheng.h"
void jiecheng::jiech()
{
	int i,j,k,s,a[10000];//ʹ���鳤�Ⱥܴ�
	for(i=0;i<10000;i++)
		a[i]=0;
	a[0]=1;
	for(i=2;i<=2014;i++)		
	{
		k=0;
		for(j=0;j<10000;j++)	//ʹС��10��������i���ѽ׳˽�����β� 	
		{
			s=a[j]*i+k;
			a[j]=s%10;
			k=s/10;
		}
	}
	for(j=9999;j>=0;j--)  
		if(a[j])	//a[j]��Ϊ0����ִ��if��䣬��ֹѭ�����õ�jֵ
			break;  
	cout<<"2014�׳�Ϊ�� "<<endl;	//�ӵ�һ����Ϊ0�������
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
