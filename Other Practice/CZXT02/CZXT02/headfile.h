#include<iostream>
using namespace std;
//定义分区描述器 node
struct node
{
	int size;   //分区大小
	int adr; //分区首地址
	int endadr; //分区终地址
	int state;   //状态 0空闲 1已分配
	struct node *prior;//前驱指针
	struct node *next;//后继指针
};