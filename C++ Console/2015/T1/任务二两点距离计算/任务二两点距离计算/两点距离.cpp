//���������� ��ռ�� 2015 3 5
#include<iostream>
#include<cmath>
using namespace std;
struct zuobiao
{
	double x,y,z;
};
zuobiao input()//��������
{
	zuobiao a;
	cout<<"������ά��������"<<endl;
	cin>>a.x>>a.y>>a.z;
	return a;
}
double juli(zuobiao b,zuobiao c)//���붨��
{
	double d;
	d=sqrt((b.x-c.x)*(b.x-c.x)+(b.y-c.y)*(b.y-c.y)+(b.z-c.z)*(b.z-c.z));
	return d;
}
void shuchu(double e)//�������
{
	cout<<"�������Ϊ"<<endl;
	cout<<e<<endl;
}
void shuchu1(zuobiao h)//�������
{
	cout<<h.x<<" "<<h.y<<" "<<h.z<<endl;
}
void main()
{
	zuobiao f,g;
	f=input();
	g=input();
	shuchu(juli(f,g));
	cout<<"���ԭ�����������Ϊ"<<endl;
	shuchu1(f);
	shuchu1(g);
	
}