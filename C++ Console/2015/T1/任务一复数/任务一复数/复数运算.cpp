//�������� ��ռ�� 2015 3 4
#include<iostream>
#include<cmath>
using namespace std;
struct fushu
{
	double a,b;	//aʵ�� b�鲿
};
fushu input()//����
{
	fushu c;
	cout<<"����һ��������ʵ�����鲿"<<endl;
	cin>>c.a>>c.b;
	return c;
}
fushu jia(fushu d,fushu e)//�ӷ�����
{
	fushu f;
	f.a=d.a+e.a;
	f.b=d.b+e.b;
	return f;
}
fushu jian(fushu d,fushu e)//��������
{
	fushu f;
	f.a=d.a-e.a;
	f.b=d.b-e.b;
	return f;
}
fushu cheng(fushu d,fushu e)//�˷�����
{
	fushu f;
	f.a=d.a*e.a-d.b*e.b;
	f.b=d.a*e.b+d.b*e.a;
	return f;
}
fushu chu(fushu d,fushu e)//��������
{
	fushu f;
	f.a=(d.a*e.a+d.b*e.b)/(e.a*e.a+e.b*e.b);
	f.b=(d.b*e.a-d.a*e.b)/(e.a*e.a+e.b*e.b);
	return f;
}
double mo(fushu d)//��ģ����
{
	double f;
	f=sqrt(d.a*d.a+d.b*d.b);
	return f;
}
void gonge(fushu &d)//�����
{
	d.b=-d.b;
}
void shuchu(fushu g)//���
{
	cout<<g.a<<" + "<<g.b<<"i"<<endl;
}
void main()//������
{
	fushu h[2],j;
	int i;
	for(i=0;i<2;i++)
		h[i]=input();

	cout<<"���ԭ������ĸ���"<<endl;
	for(i=0;i<2;i++)
		shuchu(h[i]);

	cout<<"��������Ϊ"<<endl;
	j=jia(h[0],h[1]);
	shuchu(j);

	cout<<"��������Ϊ"<<endl;
	j=jian(h[0],h[1]);
	shuchu(j);

	cout<<"��������Ϊ"<<endl;
	j=cheng(h[0],h[1]);
	shuchu(j);

	cout<<"��������Ϊ"<<endl;
	j=chu(h[0],h[1]);
	shuchu(j);

	cout<<"���Ը���ģΪ"<<endl;
	for(i=0;i<2;i++)
		cout<<mo(h[i])<<endl;

	cout<<"���Թ����Ϊ"<<endl;
	for(i=0;i<2;i++)
		gonge(h[i]);
	for(i=0;i<2;i++)
		shuchu(h[i]);
}