#include <iostream>
#include <string>
using namespace std;

//�ṹ��
struct contactBook
{
	int studentNum;
	string name;
	string zhuzhi;
	string telphoneNum;
	string email;
};

//��������
void add(contactBook xinxi[], int num);
void output(contactBook stdu);
void displayAll(contactBook xinxi[], int num);
int searchByName(contactBook xinxi[], int num, string name);//-1��ʾû���ҵ�
void delete1(contactBook xinxi[], int num,int index);
void update(contactBook xinxi[], int index);
