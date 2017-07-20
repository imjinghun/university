#include "doctor.h"

doctor::doctor(string id, string na, char c,double s)
{
	num = id;
	name = na;
	sex = c;
	salary = s;
}

doctor::~doctor(void)
{
}

void doctor::displayDoctor()
{
	cout << "Num:" << num << ", " << "Name:" << name << ", ";
	cout << "Sex:" << sex << "," << "Salary:" << salary <<endl; 
}

void doctor::saveDoctor1()
{
	ofstream outfile("f1.txt",ios::app);
	 outfile << "Num:" << num << ", " << "Name:" << name << ", ";
	 outfile << "Sex:" << sex << "," << "Salary:" << salary <<endl; 
}

void doctor::saveDoctor2()
{
	ofstream outfile("f1.dat",ios::binary);
	outfile.write((char*)this, sizeof(*this));
}
