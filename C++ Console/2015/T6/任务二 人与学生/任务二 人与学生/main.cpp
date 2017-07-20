// 人与学生 王占京 2015 4 1
#include"student.h"
#include"people.h"

void main()
{
	int d,b;
	string c;
	cout<<"输入学生年龄姓名学号"<<endl;
	cin>>b>>c>>d;
	student s(b,c,d);
	s.setID(d);
	s.displayID();
	s.setvalue(b,c);
	s.display();



}