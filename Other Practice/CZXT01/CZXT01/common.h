#include<string>
#include<iostream>
using namespace std;
struct pcb
{
	string name;//������
	int priround;//����������/����ÿ����ת��ʱ��Ƭ��
	int cputime;//�����ۼ�ռ�� CPU ��ʱ��Ƭ��
	int needtime;//���̵���ɻ���Ҫ��ʱ��Ƭ��
	char state;//����״̬ W R F
	struct pcb *next;//��һ��
};