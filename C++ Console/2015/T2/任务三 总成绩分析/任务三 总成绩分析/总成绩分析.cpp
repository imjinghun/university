//总成绩分析 王占京 2015 3 12
#include<iostream>
#include<string>
using namespace std;
#define n 5
struct fenshu
{
	int a;
	string b;//b姓名//a 学号
	double c,d,e,f;// c d e f 分数
	
};
void input(fenshu g[])//输入
{
	int i;
	cout<<"输入学号 姓名 及高数 英语 C++ 马哲分数"<<endl;
	for(i=0;i<n;i++)
		cin>>g[i].a>>g[i].b>>g[i].c>>g[i].d>>g[i].e>>g[i].f;
}
void shuchu1(fenshu g[])//输出总分最高学生的信息
{
	int i,j;
	double h[n];
	fenshu t;

	for(i=0;i<n;i++)//求每位同学总分
		h[i]=g[i].c+g[i].d+g[i].e+g[i].f;

	for(i=0;i<n;i++)//排序
		for(j=0;j<i;j++)
			if(h[i]>h[j])
			{
				t=g[i];
				g[i]=g[j];
				g[j]=t;
			}
	h[0]=g[0].c+g[0].d+g[0].e+g[0].f;
	cout<<"输出总分最高学生的学号姓名各科分数及总分"<<endl;
	cout<<g[0].a<<" "<<g[0].b<<" "<<g[0].c<<" "<<g[0].d<<" "<<g[0].e<<" "<<g[0].f<<" "<<h[0]<<endl;
	
}
void shuchu2(fenshu g[])//各科最高分输出
{
	int i,j;
	double m;
	for(i=0;i<n;i++)//高数分数排序
		for(j=0;j<i;j++)
			if(g[i].c>g[j].c)
			{
				m=g[i].c;
				g[i].c=g[j].c;
				g[j].c=m;
			}
	for(i=0;i<n;i++)//英语分数排序
		for(j=0;j<i;j++)
			if(g[i].d>g[j].d)
			{
				m=g[i].d;
				g[i].d=g[j].d;
				g[j].d=m;
			}
	for(i=0;i<n;i++)//c++分数排序
		for(j=0;j<i;j++)
			if(g[i].e>g[j].e)
			{
				m=g[i].e;
				g[i].e=g[j].e;
				g[j].e=m;
			}
	for(i=0;i<n;i++)//马哲分数排序
		for(j=0;j<i;j++)
			if(g[i].f>g[j].f)
			{
				m=g[i].f;
				g[i].f=g[j].f;
				g[j].f=m;
			}
	cout<<"高数 英语 C++ 马哲最高分数"<<endl;
	cout<<g[0].c<<" "<<g[0].d<<" "<<g[0].e<<" "<<g[0].f<<endl;
}
void shuchu3(fenshu g[])//平均分输出
{
	int i;
	double h=0,q=0,r=0,u=0,m=0,x,y,z,w,k;

	for(i=0;i<n;i++)
	{
		h+=g[i].c;
		if(i==n-1)
			x=h/n;
	}//高数
	for(i=0;i<n;i++)
	{
		q+=g[i].d;
		if(i==n-1)
			y=q/n;
	}//英语
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
	}//马哲
	for(i=0;i<n;i++)//求总分
		m+=g[i].c+g[i].d+g[i].e+g[i].f;
	k=m/n;
	cout<<"这四门课以及总成绩的平均分"<<endl;
	cout<<x<<" "<<y<<" "<<z<<" "<<w<<" "<<k<<endl;
}
void shuchu4(fenshu g[])//按照学生的总分降序输出每个学生的学号、姓名、各科考试分数以及总分
{
	int i,j;
	double h[n];
	fenshu t;

	for(i=0;i<n;i++)//求每位同学总分
		h[i]=g[i].c+g[i].d+g[i].e+g[i].f;

	for(i=0;i<n;i++)//排序
		for(j=0;j<i;j++)
			if(h[i]>h[j])
			{
				t=g[i];
				g[i]=g[j];
				g[j]=t;
			}
	for(i=0;i<n;i++)//排序后求每位同学总分
		h[i]=g[i].c+g[i].d+g[i].e+g[i].f;
	cout<<"按照学生的总分降序输出每个学生的学号、姓名、各科考试分数以及总分"<<endl;
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