//���Ƴɼ�ͳ�� ��ռ�� 2015 3 8
#include<iostream>
#include<string>
using namespace std;
#define n 5
struct ch
{
	int a;//aѧ��
	string b;//b ����
	double c;//c �ɼ�
};
void  input(ch d[])
{
	int i;
	cout<<"����ѧ��ѧ���������Է���"<<endl;
	for(i=0;i<n;i++)
		cin>>d[i].a>>d[i].b>>d[i].c;
}
void shuchu(ch d[])
{
	int i;
	cout<<"�������ѧ���������Գɼ�"<<endl;
	for(i=0;i<n;i++)
		cout<<d[i].a<<" "<<d[i].b<<" "<<d[i].c<<endl;
}
void shuchu1(ch d[])
{
	int i,j;
	ch t;
	for(i=0;i<n;i++)
		for(j=0;j<i;j++)
			if(d[i].c>d[j].c)
			{
				t=d[i];
				d[i]=d[j];
				d[j]=t;
			}
	cout<<d[0].a<<" "<<d[0].b<<" "<<d[0].c<<endl;
}
void main()
{
	ch e[n];
	input(e);
	shuchu(e);
	cout<<"��߷�ѧ����������"<<endl;
	shuchu1(e);
}