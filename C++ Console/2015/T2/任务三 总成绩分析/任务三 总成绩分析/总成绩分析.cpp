//�ܳɼ����� ��ռ�� 2015 3 12
#include<iostream>
#include<string>
using namespace std;
#define n 5
struct fenshu
{
	int a;
	string b;//b����//a ѧ��
	double c,d,e,f;// c d e f ����
	
};
void input(fenshu g[])//����
{
	int i;
	cout<<"����ѧ�� ���� ������ Ӣ�� C++ ���ܷ���"<<endl;
	for(i=0;i<n;i++)
		cin>>g[i].a>>g[i].b>>g[i].c>>g[i].d>>g[i].e>>g[i].f;
}
void shuchu1(fenshu g[])//����ܷ����ѧ������Ϣ
{
	int i,j;
	double h[n];
	fenshu t;

	for(i=0;i<n;i++)//��ÿλͬѧ�ܷ�
		h[i]=g[i].c+g[i].d+g[i].e+g[i].f;

	for(i=0;i<n;i++)//����
		for(j=0;j<i;j++)
			if(h[i]>h[j])
			{
				t=g[i];
				g[i]=g[j];
				g[j]=t;
			}
	h[0]=g[0].c+g[0].d+g[0].e+g[0].f;
	cout<<"����ܷ����ѧ����ѧ���������Ʒ������ܷ�"<<endl;
	cout<<g[0].a<<" "<<g[0].b<<" "<<g[0].c<<" "<<g[0].d<<" "<<g[0].e<<" "<<g[0].f<<" "<<h[0]<<endl;
	
}
void shuchu2(fenshu g[])//������߷����
{
	int i,j;
	double m;
	for(i=0;i<n;i++)//������������
		for(j=0;j<i;j++)
			if(g[i].c>g[j].c)
			{
				m=g[i].c;
				g[i].c=g[j].c;
				g[j].c=m;
			}
	for(i=0;i<n;i++)//Ӣ���������
		for(j=0;j<i;j++)
			if(g[i].d>g[j].d)
			{
				m=g[i].d;
				g[i].d=g[j].d;
				g[j].d=m;
			}
	for(i=0;i<n;i++)//c++��������
		for(j=0;j<i;j++)
			if(g[i].e>g[j].e)
			{
				m=g[i].e;
				g[i].e=g[j].e;
				g[j].e=m;
			}
	for(i=0;i<n;i++)//���ܷ�������
		for(j=0;j<i;j++)
			if(g[i].f>g[j].f)
			{
				m=g[i].f;
				g[i].f=g[j].f;
				g[j].f=m;
			}
	cout<<"���� Ӣ�� C++ ������߷���"<<endl;
	cout<<g[0].c<<" "<<g[0].d<<" "<<g[0].e<<" "<<g[0].f<<endl;
}
void shuchu3(fenshu g[])//ƽ�������
{
	int i;
	double h=0,q=0,r=0,u=0,m=0,x,y,z,w,k;

	for(i=0;i<n;i++)
	{
		h+=g[i].c;
		if(i==n-1)
			x=h/n;
	}//����
	for(i=0;i<n;i++)
	{
		q+=g[i].d;
		if(i==n-1)
			y=q/n;
	}//Ӣ��
	for(i=0;i<n;i++)
	{
		r+=g[i].e;
		if(i==n-1)
			z=r/n;
	}//c++
	for(i=0;i<n;i++)
	{
		u+=g[i].f;
		if(i==n-1)
			w=u/n;
	}//����
	for(i=0;i<n;i++)//���ܷ�
		m+=g[i].c+g[i].d+g[i].e+g[i].f;
	k=m/n;
	cout<<"�����ſ��Լ��ܳɼ���ƽ����"<<endl;
	cout<<x<<" "<<y<<" "<<z<<" "<<w<<" "<<k<<endl;
}
void shuchu4(fenshu g[])//����ѧ�����ֽܷ������ÿ��ѧ����ѧ�š����������ƿ��Է����Լ��ܷ�
{
	int i,j;
	double h[n];
	fenshu t;

	for(i=0;i<n;i++)//��ÿλͬѧ�ܷ�
		h[i]=g[i].c+g[i].d+g[i].e+g[i].f;

	for(i=0;i<n;i++)//����
		for(j=0;j<i;j++)
			if(h[i]>h[j])
			{
				t=g[i];
				g[i]=g[j];
				g[j]=t;
			}
	for(i=0;i<n;i++)//�������ÿλͬѧ�ܷ�
		h[i]=g[i].c+g[i].d+g[i].e+g[i].f;
	cout<<"����ѧ�����ֽܷ������ÿ��ѧ����ѧ�š����������ƿ��Է����Լ��ܷ�"<<endl;
	for(i=0;i<n;i++)
		cout<<g[i].a<<" "<<g[i].b<<" "<<g[i].c<<" "<<g[i].d<<" "<<g[i].e<<" "<<g[i].f<<" "<<h[i]<<endl;
}
void main()
{
	fenshu g[n];
	input(g);
	shuchu1(g);
	shuchu2(g);
	shuchu3(g);
	shuchu4(g);
}