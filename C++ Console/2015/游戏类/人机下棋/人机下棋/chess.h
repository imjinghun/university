#pragma once
#include<iostream>
#include<string>
#include<time.h>
using namespace std;
class chess
{
	string str[3][3],str1,str2;
	int a[3][3];
public:
	friend int suiji();		//���Ի�������
	void choose1(string s); //���ѡ����λ��
	void choose11();
	void choose2();			//����ѡ����λ��
	bool pan1();			//�ж����ʤ
	bool pan2();			//�жϵ���ʤ
	void start1();			//��ʼ��Ϸ(�������)
	void start2();			//��ʼ��Ϸ(��������)
	void output();			//���
	chess(void);			//��ʼ��
	~chess(void);
};

