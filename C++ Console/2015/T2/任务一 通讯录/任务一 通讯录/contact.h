#include <iostream>
#include <string>
using namespace std;

//结构体
struct contactBook
{
	int studentNum;
	string name;
	string zhuzhi;
	string telphoneNum;
	string email;
};

//函数声明
void add(contactBook xinxi[], int num);
void output(contactBook stdu);
void displayAll(contactBook xinxi[], int num);
int searchByName(contactBook xinxi[], int num, string name);//-1表示没查找到
void delete1(contactBook xinxi[], int num,int index);
void update(contactBook xinxi[], int index);
