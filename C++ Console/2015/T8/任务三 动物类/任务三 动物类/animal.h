#pragma once
#include<iostream>
#include<string>
using namespace std;
class animal
{
protected:
	string ani;
public:
	animal(void);
	animal(string ani)
	{
		this->ani=ani;
	}
	~animal(void);
	virtual void speak()
	{
		cout<<"My name is animal!"<<endl;
	}
};
