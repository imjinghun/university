//ѧ���� ��ռ�� 2015 3 19
#include<iostream>
#include<string>
#include "student.h"
using namespace std;

void main()
{
	stdu c[3];
	int x;
	string y;
	int i;
	cout<<"����ѧ����������"<<endl;
	for(i=0;i<3;i++)
	{
		cin>>x>>y;
		c[i].input(x,y);
	}
	cout<<"���ѧ����Ϣ"<<endl;
	for(i=0;i<3;i++)
		c[i].output();
}