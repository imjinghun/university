#include "shuguan.h"

void shuguan::sushu()//�������
{
	int i,j,x,m=0;
	for(i=1;i<=1000;i++)
	{
		x=0;
		for(j=1;j<=i;j++)	//��ÿһ����i���Ա��Լ�С����j
			if(i%j==0)
				x++;
		if(x<=2)			//����Ϊ0����jֻ����������Ϊ����
		{
			cout<<i<<" ";
			m++;
			if(m%10==0)		//��ÿ��ʮ�����
				cout<<endl;
		}
	}
	cout<<endl;
	cout<<"�������� "<<m<<" ��"<<endl;
}
void shuguan::shuixianhua()	//100--1000�ڵ�ˮ�ɻ���
{
	int i,j,t,a[3],m=0;
	for(i=100;i<1000;i++)
	{
		t=i;
		for(j=0;j<3;j++)
		{
			a[j]=t%10;			//�����λ����
			t=t/10;
		}
		if(i==(a[0]*a[0]*a[0]+a[1]*a[1]*a[1]+a[2]*a[2]*a[2]))
		{
				cout<<i<<" ";
				m++;
				if(m%10==0)			//���ư�ÿ��ʮ�����
					cout<<endl;
		}
	}
	cout<<endl;
	cout<<"����ˮ�ɻ��� "<<m<<" ��"<<endl;
}
void shuguan::wanshu()//�������
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
			k++;			//���ư�ÿ��ʮ�����
			if(k%10==0)
				cout<<endl;
		}
	}
	cout<<endl;
	cout<<"�������� "<<k<<" ��"<<endl;
}
void shuguan::paixu()	//
{
	int i,j;
	string a[10],t;
	cout<<"����10���ַ���"<<endl;
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
	cout<<"�ַ����д�С���Ϊ"<<endl;
	for(i=0;i<10;i++)
		cout<<a[i]<<" ";
	cout<<endl;
}
void shuguan::zxfh()//�ַ�������Ϣ�������
{
	string str;
	cout<<"������Ҫ������ܵ��ַ���"<<endl;
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
	cout<<"��д��ĸ Сд��ĸ ���� �ո���������� ��������Ϊ"<<endl;
	cout<<j1<<" "<<j2<<" "<<j3<<" "<<j4<<" "<<j5<<endl;
}
shuguan::shuguan(void)
{
}


shuguan::~shuguan(void)
{
}