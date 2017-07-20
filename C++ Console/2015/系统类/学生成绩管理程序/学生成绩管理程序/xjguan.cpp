#include "xjguan.h"

void xjguan::apply(int n)//申请数组长度
{
	xj.resize(n);
}
void xjguan::release()//释放空间
{
	xj.clear();
}
void xjguan::input1(int qs,int zz)//qs添加或创建的起始位置 zz添加或创建的人数后的的终止位置
{
	int i;
	for(i=qs;i<zz;i++)
		xj[i].input();
}
void xjguan::output1(int qs,int zz)//qs输出时的起始位置 zz输出时的终止位置 
{
	int i;
	for(i=qs;i<zz;i++)
		xj[i].output();
}
void xjguan::chazhao(int z,string str)//z查找时总人数 str查找时输入的学号
{
	int i,j=0;
	cout<<"输出被查找人的学号 姓名 语文 数学 英语成绩 平均分 总分"<<endl;
	for(i=0;i<z;i++)
	{
		if(xj[i].xuehao==str)
			xj[i].output();
		else 
			j++;
	}
	if(j==z)
		cout<<"没有所要查找的信息！"<<endl;
}
void xjguan::paixu(int z)//按照总分降序排序 z总人数
{
	people p;
	int i,j;
	for(i=0;i<z;i++)
		for(j=0;j<z-i;j++)
			if(xj[j].zongfen()<xj[j+1].zongfen())//调用求和函数，排序
			{
				p=xj[j+1];
				xj[j+1]=xj[j];
				xj[j]=p;
			}
	for(i=0;i<z;i++)
		xj[i].output();

}
void xjguan::huizong(int z)//计算总分进行汇总 z总人数
{
	int i;
	for(i=0;i<z;i++)
		cout<<xj[i].xuehao<<" "<<xj[i].name<<" "<<xj[i].zongfen()<<endl;
}
void xjguan::charu(int p,int r,int z)//插入的 p位置 r人数 z总人数
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