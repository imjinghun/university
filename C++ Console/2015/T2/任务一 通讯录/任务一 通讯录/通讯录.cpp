//通讯录 王占京 2015 3 13
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
        cout << "按数字   1 插入 2 按姓名查找 3 删除 4 更新 5 显示 6 退出   开始进行操作" << endl;
		cin >> choice;
       
	    if(choice == 1)
		{
			add(xinxi,num);
			num++;
		}
		else if(choice == 2)
		{
			cout << "请输入要查找同学的姓名:" << endl;
			string name;
			cin >> name;
			int index = searchByName(xinxi,num,name);
			if(index == -1)
				cout << "查无此人!" << endl;
			else 
			{
				cout << "要查找的学生信息为:" << endl;
				output(xinxi[index]);
			}
		}
		else if(choice == 3)
		{
			cout << "输入删除的位置:" << endl;
			int weizhi;
			cin >> weizhi;
			delete1(xinxi,num,weizhi);
			num--;
		}
		else if(choice == 4)
		{
			cout << "输入更新的位置:" << endl;
			int weizhi1;
			cin >> weizhi1;
			update(xinxi,weizhi1);
		}
		else if(choice == 5)
			displayAll(xinxi,num);
		else if(choice == 6)
			break;
		else
			cout << "无此功能!" << endl;
	}
}