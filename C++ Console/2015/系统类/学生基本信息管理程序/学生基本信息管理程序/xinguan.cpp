#include "xinguan.h"

void xinguan::apply(int n)//�������鳤��
{
	xg.resize(n);
}
void xinguan::release()//�ͷſռ�
{
	xg.clear();
}
void xinguan::input1(int qs,int zz)//qs��ӻ򴴽�����ʼλ�� zz��ӻ򴴽���������ĵ���ֹλ��
{
	int i;
	for(i=qs;i<zz;i++)
		xg[i].input();
}
void xinguan::output1(int qs,int zz)//qs���ʱ����ʼλ�� zz���ʱ����ֹλ�� 
{
	int i;
	for(i=qs;i<zz;i++)
		xg[i].output();
}
void xinguan::chazhao(int z,string str)//z����ʱ������ str����ʱ�����ѧ�Ű༶��רҵ
{
	int i,j=0;
	cout<<"��������ҵ���ѧ�š��������Ա����䡢�༶��ѧԺ��רҵ"<<endl;
	for(i=0;i<z;i++)
	{
		if(xg[i].xuehao==str)
			xg[i].output();
		else if(xg[i].banji==str)
			xg[i].output();
		else if(xg[i].zhuanye==str)
			xg[i].output();
		else 
			j++;
	}
	if(j==z)
		cout<<"û����Ҫ���ҵ���Ϣ��"<<endl;
}
void xinguan::xiugai(int z,string str)//z������ str�޸�ʱ�����ѧ��
{
	int i,j=0;
	cout<<"�����޸ĺ��ѧ�š��������Ա����䡢�༶��ѧԺ��רҵ"<<endl;
	for(i=0;i<z;i++)
	{
		if(xg[i].name==str)
			xg[i].input();
		else
			j++;
	}
	if(j==z)
		cout<<"û�д��ˣ��������룡"<<endl;
}
void xinguan::shanchu(int z,string str)//z������ str��ɾ���ߵ�name
{
	int i,j=0,k;
	for(i=0;i<z;i++)
	{
		if(xg[i].name==str)
			for(k=i;k<z;k++)
				xg[k]=xg[k+1];
		else
			j++;
	}
	if(j==z)
		cout<<"û��Ҫ��ɾ�����ˣ�"<<endl;
}
xinguan::xinguan(void)
{
}
xinguan::~xinguan(void)
{
}
