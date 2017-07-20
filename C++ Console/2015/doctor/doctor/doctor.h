#pragma once
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

class doctor
{
public:
	doctor(string id = "0", string na = "wang", char c = 'M',double s = 0);
	~doctor(void);
	void setNum(string id) {num = id;}
	void setName(string na){name = na;}
	void setSex(char c){sex = c;}
	void setSalary(double s){salary = s;}

	string getNum(){return num;}
	string getName(){return name;}
	char getSex(){return sex;}
	double getSalary(){return salary;}

	void displayDoctor();
	void saveDoctor1();
	void saveDoctor2();
private:
	string num,name;
	char sex;
	double salary;
};
