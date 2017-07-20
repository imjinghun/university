//人 学生 教师   王占京 2015 4 9
#include"people.h"
#include"student.h"
#include"teacher.h"
void main()
{
	int nianl1,nianl2,xueh,gongh;
	string xingm1,xingm2;
	cout<<"输入学生姓名年龄学号"<<endl;
	cin>>xingm1>>nianl1>>xueh;
	
	student stu;
	stu.setvalue(nianl1,xingm1);
	stu.setID(xueh);
	cout<<"输出学生姓名年龄学号"<<endl;
	stu.display();

	cout<<"输入教师姓名年龄学号"<<endl;
	cin>>xingm2>>nianl2>>gongh;

	teacher tea;
	tea.setvalue(nianl2,xingm2);
	tea.setID(gongh);
	cout<<"输出教师姓名年龄学号"<<endl;
	tea.display();
}