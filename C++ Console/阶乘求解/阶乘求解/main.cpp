#include<iostream>
using namespace std;
double jiec(int a)
{
	int i;
	double s=1;
	for(i=1;i<=a;i++)
		s=s*i;
	return s;
}
void jiech(int a)
{
	int i,j;
	double s;
	for(i=1;i<=a;i++)
	{	s=1;
		for(j=1;j<=i;j++)
			s=s*j;
		cout<<s<<endl;
	}
}
void main()
{
	int b;
	cout<<"����һ������"<<endl;
	cin>>b;
	cout<<"�����׳�Ϊ"<<endl;
	cout<<jiec(b)<<endl;
	cout<<"���ÿһ�����Ľ׳�"<<endl;
	jiech(b);
}