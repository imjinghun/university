#include "xinguan.h"

void xinguan::apply(int n)//申请数组长度
{
	xg.resize(n);
}
void xinguan::release()//释放空间
{
	xg.clear();
}
void xinguan::input1(int qs,int zz)//qs添加或创建的起始位置 zz添加或创建的人数后的的终止位置
{
	int i;
	for(i=qs;i<zz;i++)
		xg[i].input();
}
void xinguan::output1(int qs,int zz)//qs输出时的起始位置 zz输出时的终止位置 
{
	int i;
	for(i=qs;i<zz;i++)
		xg[i].output();
}
void xinguan::chazhao(int z,string str)//z查找时总人数 str查找时输入的学号班级或专业
{
	int i,j=0;
	cout<<"输出被查找到的学号、姓名、性别、年龄、班级、学院、专业"<<endl;
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
		cout<<"没有所要查找的信息！"<<endl;
}
void xinguan::xiugai(int z,string str)//z总人数 str修改时输入的学号
{
	int i,j=0;
	cout<<"输入修改后的学号、姓名、性别、年龄、班级、学院、专业"<<endl;
	for(i=0;i<z;i++)
	{
		if(xg[i].name==str)
			xg[i].input();
		else
			j++;
	}
	if(j==z)
		cout<<"没有此人，不可输入！"<<endl;
}
void xinguan::shanchu(int z,string str)//z总人数 str被删除者的name
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
		cout<<"没有要被删除的人！"<<endl;
}
xinguan::xinguan(void)
{
}
xinguan::~xinguan(void)
{
}
