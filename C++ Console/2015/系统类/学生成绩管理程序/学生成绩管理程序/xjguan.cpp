#include "xjguan.h"

void xjguan::apply(int n)//�������鳤��
{
	xj.resize(n);
}
void xjguan::release()//�ͷſռ�
{
	xj.clear();
}
void xjguan::input1(int qs,int zz)//qs��ӻ򴴽�����ʼλ�� zz��ӻ򴴽���������ĵ���ֹλ��
{
	int i;
	for(i=qs;i<zz;i++)
		xj[i].input();
}
void xjguan::output1(int qs,int zz)//qs���ʱ����ʼλ�� zz���ʱ����ֹλ�� 
{
	int i;
	for(i=qs;i<zz;i++)
		xj[i].output();
}
void xjguan::chazhao(int z,string str)//z����ʱ������ str����ʱ�����ѧ��
{
	int i,j=0;
	cout<<"����������˵�ѧ�� ���� ���� ��ѧ Ӣ��ɼ� ƽ���� �ܷ�"<<endl;
	for(i=0;i<z;i++)
	{
		if(xj[i].xuehao==str)
			xj[i].output();
		else 
			j++;
	}
	if(j==z)
		cout<<"û����Ҫ���ҵ���Ϣ��"<<endl;
}
void xjguan::paixu(int z)//�����ֽܷ������� z������
{
	people p;
	int i,j;
	for(i=0;i<z;i++)
		for(j=0;j<z-i;j++)
			if(xj[j].zongfen()<xj[j+1].zongfen())//������ͺ���������
			{
				p=xj[j+1];
				xj[j+1]=xj[j];
				xj[j]=p;
			}
	for(i=0;i<z;i++)
		xj[i].output();

}
void xjguan::huizong(int z)//�����ֽܷ��л��� z������
{
	int i;
	for(i=0;i<z;i++)
		cout<<xj[i].xuehao<<" "<<xj[i].name<<" "<<xj[i].zongfen()<<endl;
}
void xjguan::charu(int p,int r,int z)//����� pλ�� r���� z������
{
	int i;
	for(i=z-1;i>p;i--)
		xj[i]=xj[i-r];
}
xjguan::xjguan(void)
{
}
xjguan::~xjguan(void)
{
}