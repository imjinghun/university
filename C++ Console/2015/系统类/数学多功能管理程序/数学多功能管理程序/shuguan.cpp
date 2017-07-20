#include "shuguan.h"

void shuguan::sushu()//素数输出
{
	int i,j,x,m=0;
	for(i=1;i<=1000;i++)
	{
		x=0;
		for(j=1;j<=i;j++)	//让每一个数i除以比自己小的数j
			if(i%j==0)
				x++;
		if(x<=2)			//余数为0的数j只有两个，则为素数
		{
			cout<<i<<" ";
			m++;
			if(m%10==0)		//按每行十个输出
				cout<<endl;
		}
	}
	cout<<endl;
	cout<<"共有素数 "<<m<<" 个"<<endl;
}
void shuguan::shuixianhua()	//100--1000内的水仙花数
{
	int i,j,t,a[3],m=0;
	for(i=100;i<1000;i++)
	{
		t=i;
		for(j=0;j<3;j++)
		{
			a[j]=t%10;			//求出各位数字
			t=t/10;
		}
		if(i==(a[0]*a[0]*a[0]+a[1]*a[1]*a[1]+a[2]*a[2]*a[2]))
		{
				cout<<i<<" ";
				m++;
				if(m%10==0)			//控制按每行十个输出
					cout<<endl;
		}
	}
	cout<<endl;
	cout<<"共有水仙花数 "<<m<<" 个"<<endl;
}
void shuguan::wanshu()//完数输出
{
	int i,j,s,k=0;
	for(i=1;i<=1000;i++)
	{
		s=0;
		for(j=1;j<i;j++)
			if(i%j==0)
				s=s+j;
		if(i==s)
		{
			cout<<i<<" ";
			k++;			//控制按每行十个输出
			if(k%10==0)
				cout<<endl;
		}
	}
	cout<<endl;
	cout<<"共有完数 "<<k<<" 个"<<endl;
}
void shuguan::paixu()	//
{
	int i,j;
	string a[10],t;
	cout<<"输入10个字符串"<<endl;
	for(i=0;i<10;i++)
		cin>>a[i];
	for(i=0;i<9;i++)
		for(j=0;j<9-i;j++)
			if(a[j]<a[j+1])
			{
				t=a[j];
				a[j]=a[j+1];
				a[j+1]=t;
			}
	cout<<"字符串有大到小输出为"<<endl;
	for(i=0;i<10;i++)
		cout<<a[i]<<" ";
	cout<<endl;
}
void shuguan::zxfh()//字符串中信息分类汇总
{
	string str;
	cout<<"输入想要分类汇总的字符串"<<endl;
	fflush(stdin);
	getline(cin,str);
	int i=0,k,j1=0,j2=0,j3=0,j4=0,j5=0;
	k=str.length();
	while(1)
	{
		string s(str,i,1);
		if(s>="A"&&s<="Z")
			j1++;
		else if(s>="a"&&s<="z")
			j2++;
		else if(s>="0"&&s<="9")
			j3++;
		else if(s==" ")
			j4++;
		else
			j5++;
		i++;
		if(k==i)
			break;
	}
	cout<<"大写字母 小写字母 数字 空格和其他符号 个数依次为"<<endl;
	cout<<j1<<" "<<j2<<" "<<j3<<" "<<j4<<" "<<j5<<endl;
}
shuguan::shuguan(void)
{
}


shuguan::~shuguan(void)
{
}