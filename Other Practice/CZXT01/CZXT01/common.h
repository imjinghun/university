#include<string>
#include<iostream>
using namespace std;
struct pcb
{
	string name;//进程名
	int priround;//进程优先数/进程每次轮转的时间片数
	int cputime;//进程累计占用 CPU 的时间片数
	int needtime;//进程到完成还需要的时间片数
	char state;//进程状态 W R F
	struct pcb *next;//下一个
};