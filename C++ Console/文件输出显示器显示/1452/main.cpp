#include"teacher.h"

void main()
{
	teacher t[4];//此处不用在初始化 因为前面.h已经初始化了
	int i;
	double s;
	string n,na;
	cout<<"输入工号姓名工资"<<endl;
	for(i=0;i<4;i++)
	{
		cin>>n>>na>>s;
		t[i].setnum(n);
		t[i].setname(na);
		t[i].setsalary(s);
	}
	cout<<"输出工号姓名工资"<<endl;
	for(i=0;i<4;i++)
	{
		t[i].display();
	}
	t[4].paixu(t);
}