//ͨѶ¼ ��ռ�� 2015 3 13
#include <iostream>
#include <string>
#include "contact.h"
using namespace std;


void main()
{
    contactBook xinxi[100];
    int num = 0;
    
	while(1)
	{
		int choice;
		cout << endl;
        cout << "������   1 ���� 2 ���������� 3 ɾ�� 4 ���� 5 ��ʾ 6 �˳�   ��ʼ���в���" << endl;
		cin >> choice;
       
	    if(choice == 1)
		{
			add(xinxi,num);
			num++;
		}
		else if(choice == 2)
		{
			cout << "������Ҫ����ͬѧ������:" << endl;
			string name;
			cin >> name;
			int index = searchByName(xinxi,num,name);
			if(index == -1)
				cout << "���޴���!" << endl;
			else 
			{
				cout << "Ҫ���ҵ�ѧ����ϢΪ:" << endl;
				output(xinxi[index]);
			}
		}
		else if(choice == 3)
		{
			cout << "����ɾ����λ��:" << endl;
			int weizhi;
			cin >> weizhi;
			delete1(xinxi,num,weizhi);
			num--;
		}
		else if(choice == 4)
		{
			cout << "������µ�λ��:" << endl;
			int weizhi1;
			cin >> weizhi1;
			update(xinxi,weizhi1);
		}
		else if(choice == 5)
			displayAll(xinxi,num);
		else if(choice == 6)
			break;
		else
			cout << "�޴˹���!" << endl;
	}
}