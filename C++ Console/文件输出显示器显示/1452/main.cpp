#include"teacher.h"

void main()
{
	teacher t[4];//�˴������ڳ�ʼ�� ��Ϊǰ��.h�Ѿ���ʼ����
	int i;
	double s;
	string n,na;
	cout<<"���빤����������"<<endl;
	for(i=0;i<4;i++)
	{
		cin>>n>>na>>s;
		t[i].setnum(n);
		t[i].setname(na);
		t[i].setsalary(s);
	}
	cout<<"���������������"<<endl;
	for(i=0;i<4;i++)
	{
		t[i].display();
	}
	t[4].paixu(t);
}