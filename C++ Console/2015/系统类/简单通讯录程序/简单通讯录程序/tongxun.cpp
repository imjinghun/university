#include "tongxun.h"

void tongxun::apply(int n)//�������鳤��
{
	tx.resize(n);
}
void tongxun::release()//�ͷſռ�
{
	tx.clear();
}
void tongxun::input1(int qs,int zz)//qs��ӻ򴴽�����ʼλ�� zz��ӻ򴴽���������ĵ���ֹλ��
{
	int i;
	for(i=qs;i<zz;i++)
		tx[i].input();
}
void tongxun::output1(int qs,int zz)//qs���ʱ����ʼλ�� zz���ʱ����ֹλ�� 
{
	int i;
	for(i=qs;i<zz;i++)
		tx[i].output();
}
void tongxun::chazhao(int z,string str)//z����ʱ������ str����ʱ�����name���ֻ���
{
	int i,j=0;
	cout<<"����������˵ı�� ���� ���� �Ա� լ�� �ֻ�����"<<endl;
	for(i=0;i<z;i++)
	{
		if(tx[i].name==str)
			tx[i].output();
		else if(tx[i].shouji==str)
			tx[i].output();
		else 
			j++;
	}
	if(j==z)
		cout<<"û����Ҫ���ҵ���Ϣ��"<<endl;
}
void tongxun::xiugai(int z,string str)//z������ str�޸�ʱ�����name
{
	int i,j=0;
	cout<<"�����޸ĺ�ı�� ���� ���� �Ա� լ�� �ֻ�����"<<endl;
	for(i=0;i<z;i++)
	{
		if(tx[i].name==str)
			tx[i].input();
		else
			j++;
	}
	if(j==z)
		cout<<"û�д��ˣ��������룡"<<endl;
}
void tongxun::shanchu(int z,string str)//z������ str��ɾ���ߵ�name
{
	int i,j=0,k;
	for(i=0;i<z;i++)
	{
		if(tx[i].name==str)
			for(k=i;k<z;k++)
				tx[k]=tx[k+1];
		else
			j++;
	}
	if(j==z)
		cout<<"û��Ҫ��ɾ�����ˣ�"<<endl;
}
tongxun::tongxun(void)
{
}
tongxun::~tongxun(void)
{
}
