#include<iostream>
using namespace std;
#define n 3
void main()
{
	double i, a=0;
	//int i;
	//double d=1;        ���߰�//�� double�е�iȥ��  ��ѭ��{}�е�i��Ϊd
	for(i=1;i<n+1;i=i+2)
	{   //d++;
		a=a+(1/(i*(i+1)));
	}
	cout<<a<<endl;
}