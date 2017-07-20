#include <iostream>
#include "doctor.h"
using namespace std;

void main()
{
	doctor doctors[4];
    int i,j;
	string num,name;
	char sex;
	double salary;

	cout << "请输入4位医生信息：" << endl;
	for(i = 0; i < 4; i++)
	{
		cin >> num >> name >> sex >> salary;
		doctors[i].setNum(num);
		doctors[i].setName(name);
		doctors[i].setSex(sex);
		doctors[i].setSalary(salary);
	}
    cout << "4位医生信息为：" << endl;
    for(i = 0; i < 4; i++)
		doctors[i].displayDoctor();

	doctor temp;
	for(i = 0; i < 3; i++)
		for(j = 0; j < 3 - i; j++)
			if(doctors[j].getSalary() < doctors[j+1].getSalary())
			{
				temp = doctors[j];
				doctors[j] = doctors[j+1];
				doctors[j+1] = temp;
			}
	cout << "排序后4位医生信息为：" << endl;
	for(i = 0; i < 4; i++)
	{
		doctors[i].displayDoctor();
	    doctors[i].saveDoctor1();
	}
}