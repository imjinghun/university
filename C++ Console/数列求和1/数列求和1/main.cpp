#include<iostream>
using namespace std;
void main()
{
	int i;
	double a=1,b=2,s=2,t;//a,bӦΪdouble�� ��Ϊ������b/aΪ����
	for(i=0;i<19;i++)
	{
		t=a;
		a=b;
		b=t+b;
		s=s+b/a;
	}
	cout<<"ǰ20��� "<<s<<endl;
}