//���ĳ��Ϊĳ���еĵڼ��� ��ռ�� 2015 3 5
#include<iostream>
using namespace std;
struct day
{
	int a,b,c;	//a b c �ֱ�Ϊ ������
};
day input()//��������
{
	day d;
	cout<<"����������"<<endl;
	cin>>d.a>>d.b>>d.c;
	return d;
}
bool runnian(int a)//�����ж�
{
	bool flag;
	if(a%100==0)
	{
		if(a%400==0)
			flag=true;
		else
			flag=false;
	}
	if(a%100!=0)
	{
		
		if(a%4==0)
			flag=true;
		else 
			flag=false;
	}		
	return flag;
}

void shuchu(day d)//���
{
	int e=0,i,j,a[12];
	bool f;
	for(i=0;i<12;i++)
	{
		if(i==0||i==2||i==4||i==6||i==7||i==9||i==11)
			a[i]=31;
		if(i==3||i==5||i==8||i==10)
			a[i]=30;
	}

	f=runnian(d.a);
	if(f==true)
		a[1]=29;
	else 
		a[1]=28;

	for(i=0;i<d.b-1;i++)
		e+=a[i];
	j=e+d.c;
	cout<<"����Ϊ����ĵ� "<<j<<" ��"<<endl;
}
void main()
{
	day k;
	k=input();
	shuchu(k);
}