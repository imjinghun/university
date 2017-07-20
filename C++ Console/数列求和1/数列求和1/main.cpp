#include<iostream>
using namespace std;
void main()
{
	int i;
	double a=1,b=2,s=2,t;//a,b应为double型 若为整型则b/a为整型
	for(i=0;i<19;i++)
	{
		t=a;
		a=b;
		b=t+b;
		s=s+b/a;
	}
	cout<<"前20项和 "<<s<<endl;
}