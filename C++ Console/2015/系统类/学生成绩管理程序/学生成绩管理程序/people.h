#pragma once
#include<iostream>
#include<string>

using namespace std;
class people
{
	
public:
	string name,xuehao;
	double zfen,pjfen,math,english,chinese;
	void input();//����
	void output();//���
	double zongfen();//�����ܷ�
	double pingjun();//����ƽ����
	people(void);
	~people(void);
};


