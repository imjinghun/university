#include "tongxun.h"

void tongxun::apply(int n)//申请数组长度
{
	tx.resize(n);
}
void tongxun::release()//释放空间
{
	tx.clear();
}
void tongxun::input1(int qs,int zz)//qs添加或创建的起始位置 zz添加或创建的人数后的的终止位置
{
	int i;
	for(i=qs;i<zz;i++)
		tx[i].input();
}
void tongxun::output1(int qs,int zz)//qs输出时的起始位置 zz输出时的终止位置 
{
	int i;
	for(i=qs;i<zz;i++)
		tx[i].output();
}
void tongxun::chazhao(int z,string str)//z查找时总人数 str查找时输入的name或手机号
{
	int i,j=0;
	cout<<"输出被查找人的编号 年龄 姓名 性别 宅电 手机号码"<<endl;
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
		cout<<"没有所要查找的信息！"<<endl;
}
void tongxun::xiugai(int z,string str)//z总人数 str修改时输入的name
{
	int i,j=0;
	cout<<"输入修改后的编号 年龄 姓名 性别 宅电 手机号码"<<endl;
	for(i=0;i<z;i++)
	{
		if(tx[i].name==str)
			tx[i].input();
		else
			j++;
	}
	if(j==z)
		cout<<"没有此人，不可输入！"<<endl;
}
void tongxun::shanchu(int z,string str)//z总人数 str被删除者的name
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
		cout<<"没有要被删除的人！"<<endl;
}
tongxun::tongxun(void)
{
}
tongxun::~tongxun(void)
{
}
