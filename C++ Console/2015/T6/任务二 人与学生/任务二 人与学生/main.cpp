// ����ѧ�� ��ռ�� 2015 4 1
#include"student.h"
#include"people.h"

void main()
{
	int d,b;
	string c;
	cout<<"����ѧ����������ѧ��"<<endl;
	cin>>b>>c>>d;
	student s(b,c,d);
	s.setID(d);
	s.displayID();
	s.setvalue(b,c);
	s.display();



}