//�� ѧ�� ��ʦ   ��ռ�� 2015 4 9
#include"people.h"
#include"student.h"
#include"teacher.h"
void main()
{
	int nianl1,nianl2,xueh,gongh;
	string xingm1,xingm2;
	cout<<"����ѧ����������ѧ��"<<endl;
	cin>>xingm1>>nianl1>>xueh;
	
	student stu;
	stu.setvalue(nianl1,xingm1);
	stu.setID(xueh);
	cout<<"���ѧ����������ѧ��"<<endl;
	stu.display();

	cout<<"�����ʦ��������ѧ��"<<endl;
	cin>>xingm2>>nianl2>>gongh;

	teacher tea;
	tea.setvalue(nianl2,xingm2);
	tea.setID(gongh);
	cout<<"�����ʦ��������ѧ��"<<endl;
	tea.display();
}