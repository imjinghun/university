#include<iostream>
using namespace std;

void gb(int a,int b,int &p,int &q)
{
	int i;
	for(i=b;i>1;i--)
		if(a%i==0&&b%i==0)
		{
			p=i;
			break;
		}
	q=(a*b)/p;
}
void main()
{
	int a,b,c,d,t;
	cout<<"������������"<<endl;
	cin>>a>>b;
	if(a<b)
	{
		t=b;
		b=a;
		a=t;
	}
	gb(a,b,c,d);
	cout<<"��С�����������Լ��Ϊ"<<endl;
	cout<<d<<" "<<c<<endl;
}