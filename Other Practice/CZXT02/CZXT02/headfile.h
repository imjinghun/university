#include<iostream>
using namespace std;
//������������� node
struct node
{
	int size;   //������С
	int adr; //�����׵�ַ
	int endadr; //�����յ�ַ
	int state;   //״̬ 0���� 1�ѷ���
	struct node *prior;//ǰ��ָ��
	struct node *next;//���ָ��
};