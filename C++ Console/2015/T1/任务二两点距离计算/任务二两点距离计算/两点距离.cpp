//两点距离计算 王占京 2015 3 5
#include<iostream>
#include<cmath>
using namespace std;
struct zuobiao
{
	double x,y,z;
};
zuobiao input()//坐标输入
{
	zuobiao a;
	cout<<"输入三维两点坐标"<<endl;
	cin>>a.x>>a.y>>a.z;
	return a;
}
double juli(zuobiao b,zuobiao c)//距离定义
{
	double d;
	d=sqrt((b.x-c.x)*(b.x-c.x)+(b.y-c.y)*(b.y-c.y)+(b.z-c.z)*(b.z-c.z));
	return d;
}
void shuchu(double e)//距离输出
{
	cout<<"两点距离为"<<endl;
	cout<<e<<endl;
}
void shuchu1(zuobiao h)//坐标输出
{
	cout<<h.x<<" "<<h.y<<" "<<h.z<<endl;
}
void main()
{
	zuobiao f,g;
	f=input();
	g=input();
	shuchu(juli(f,g));
	cout<<"输出原来输入的坐标为"<<endl;
	shuchu1(f);
	shuchu1(g);
	
}