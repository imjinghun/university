#include "contact.h"
#include <iostream>
#include <string>
using namespace std;

void add(contactBook xinxi[], int num)
{
	cout << "����ѧ�ţ���������ͥסַ���绰������:" << endl;
	cin >> xinxi[num].studentNum >> xinxi[num].name>>xinxi[num].zhuzhi;
	cin >> xinxi[num].telphoneNum >> xinxi[num].email;
}

void output(contactBook stdu)
{
	cout << stdu.studentNum  << " " <<  stdu.name << " "<<stdu.zhuzhi<<" ";
	cout <<  stdu.telphoneNum << " " <<  stdu.email << endl;
}

void displayAll(contactBook xinxi[], int num)
{
	cout << endl << "����ѧ����Ϣ" <<endl;
	int i;
	for(i = 0; i < num; i++)
		output(xinxi[i]);

	cout << endl;
}

int searchByName(contactBook xinxi[], int num, string name)
{
	int index = -1,i;

	for(i = 0; i < num; i++)
		if(xinxi[i].name == name)
			index = i;

	return index;
}

void delete1(contactBook xinxi[], int num, int index)
{
	int i;
	for(i = index; i < num; i++)
		xinxi[i] = xinxi[i + 1];
}

void update(contactBook xinxi[],  int index)
{
	cout << "�������µ�ѧ�ţ���������ͥסַ���绰������:" << endl;
	cin >> xinxi[index].studentNum >> xinxi[index].name>>xinxi[index].zhuzhi;
	cin >> xinxi[index].telphoneNum >> xinxi[index].email;
}
