#pragma once
#include<iostream>
#include"time.h"//Ҳ����дΪ#include<time.h>
#include<windows.h>
using namespace std;
class guess
{
public:
	int getn();//��������������
	int settime();//������Ϸʱ��
	int playerinput();//�������
	void tishi(guess gu,int g,int m);//��Ϸ��ʾ
	void begin(guess gu);//��Ϸ����
	void again();//����Ϸ
	guess(void);
	~guess(void);
};

