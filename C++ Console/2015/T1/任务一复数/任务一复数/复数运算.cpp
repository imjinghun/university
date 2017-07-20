//复数运算 王占京 2015 3 4
#include<iostream>
#include<cmath>
using namespace std;
struct fushu
{
	double a,b;	//a实部 b虚部
};
fushu input()//输入
{
	fushu c;
	cout<<"输入一个复数的实部和虚部"<<endl;
	cin>>c.a>>c.b;
	return c;
}
fushu jia(fushu d,fushu e)//加法定义
{
	fushu f;
	f.a=d.a+e.a;
	f.b=d.b+e.b;
	return f;
}
fushu jian(fushu d,fushu e)//减法定义
{
	fushu f;
	f.a=d.a-e.a;
	f.b=d.b-e.b;
	return f;
}
fushu cheng(fushu d,fushu e)//乘法定义
{
	fushu f;
	f.a=d.a*e.a-d.b*e.b;
	f.b=d.a*e.b+d.b*e.a;
	return f;
}
fushu chu(fushu d,fushu e)//除法定义
{
	fushu f;
	f.a=(d.a*e.a+d.b*e.b)/(e.a*e.a+e.b*e.b);
	f.b=(d.b*e.a-d.a*e.b)/(e.a*e.a+e.b*e.b);
	return f;
}
double mo(fushu d)//求模定义
{
	double f;
	f=sqrt(d.a*d.a+d.b*d.b);
	return f;
}
void gonge(fushu &d)//共轭定义
{
	d.b=-d.b;
}
void shuchu(fushu g)//输出
{
	cout<<g.a<<" + "<<g.b<<"i"<<endl;
}
void main()//主函数
{
	fushu h[2],j;
	int i;
	for(i=0;i<2;i++)
		h[i]=input();

	cout<<"输出原来输入的复数"<<endl;
	for(i=0;i<2;i++)
		shuchu(h[i]);

	cout<<"两复数和为"<<endl;
	j=jia(h[0],h[1]);
	shuchu(j);

	cout<<"两复数差为"<<endl;
	j=jian(h[0],h[1]);
	shuchu(j);

	cout<<"两复数积为"<<endl;
	j=cheng(h[0],h[1]);
	shuchu(j);

	cout<<"两复数商为"<<endl;
	j=chu(h[0],h[1]);
	shuchu(j);

	cout<<"各自复数模为"<<endl;
	for(i=0;i<2;i++)
		cout<<mo(h[i])<<endl;

	cout<<"各自共轭复数为"<<endl;
	for(i=0;i<2;i++)
		gonge(h[i]);
	for(i=0;i<2;i++)
		shuchu(h[i]);
}