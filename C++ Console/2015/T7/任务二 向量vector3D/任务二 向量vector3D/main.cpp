//vector3D 王占京 2015 4 10
#include"vector.h"
void main()
{
	vector a,b,c;
	double d;
	cout<<"输入两个三维向量"<<endl;
	cin>>a>>b;
	c=a+b;
	cout<<"向量加法 "<<c<<endl;
	c=a-b;
	cout<<"向量减法 "<<c<<endl;
	d=a*b;
	cout<<"向量乘法 "<<d<<endl;
}