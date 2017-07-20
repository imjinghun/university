//优先权调度算法
#include"common.h"
int hpfoutput(pcb *pp);
int hpfrun(pcb *pp);
int hpf()
{
	pcb *p = new pcb, *temp;
	p->next = NULL;
	cout << "依次输入进程名、进程完成需要的时间" << endl;
	cout << "根据进程优先级由低到高（1优先级最高）输入" << endl;
	for (int i = 0; i < 5; i++)
	{
		temp = new pcb;
		cin >> temp->name >> temp->needtime;
		temp->cputime = 0;
		temp->priround = 5-i;
		temp->state = 'W';
		temp->next = p->next;
		p->next = temp;
	}
	cout << "各进程初始状态：" << endl;
	hpfoutput(p);
	
	cout << "运行状态：" << endl;
	hpfrun(p);
	return 1;
}

int hpfoutput(pcb *pp)
{
	pcb *p = pp;
	cout << "进程名 进程优先级 进程占用CPU时间 进程到完成还需要的时间 进程状态" << endl;
	for (int i = 0; i < 5;i++)
	{
		p = p->next;
		cout << "  " << p->name << "	  " << p->priround << "		" << p->cputime << "		"
			<< p->needtime << "		    " << p->state << endl;
	}
	return 1;
}
int hpfrun(pcb *pp)
{
	pcb *p, *p1, *p2;
	p = pp;
	for (int i = 0; i < 5; i++)
	{
		p1 = p->next;
		int time = p1->needtime;
		for (int i = 0; i < time; i++)
		{
			p1->cputime++;
			p1->needtime--;
			if (p1->needtime == 0)
			{
				p1->state = 'F';
			}
			else{
				p1->state = 'R';
			}

			p->next = p1;

			hpfoutput(p);
		}
		p2 = p->next;

		while (p2->next)
		{
			p2 = p2->next;
		}
		p->next = p1->next;
		p2->next = p1;
		p1->next = NULL;
	}
	return 1;
}