#pragma once
#include<iostream>
#include<new>
using namespace std;
class juzhen
{
	double **a;
	int row,col;
public:

	void gethl(int r,int c);//���������
	void shenqing();	//����ռ�
	void qingchu();	//�ͷſռ�
	void input();	//���뷽��
	void output(juzhen A);//�������
	void ji(int rr,int cc,juzhen A);	//����ļ�
	double det(juzhen A);	//����ʽ���Ƿ����
	bool det1(juzhen A);//�ж��Ƿ��Ƿ���
	friend juzhen operator+(juzhen A,juzhen B);
	friend juzhen operator-(juzhen A,juzhen B);
	friend juzhen operator*(juzhen A,juzhen B);
	juzhen(void);
	~juzhen(void);
};


