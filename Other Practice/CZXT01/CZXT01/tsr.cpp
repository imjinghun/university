//时间片轮转调度算法
#include"common.h"
int tsroutput(pcb *pp);
int tsrrun(pcb *pp);
int tsr()
{
	pcb *p = new pcb, *temp,*p2;
	p->next = NULL;
	cout << "依次输入进程名、进程完成需要的时间" << endl;
	for (int i = 0; i < 5; i++)
	{
		temp = new pcb;
		cin >> temp->name >> temp->needtime;
		temp->cputime = 0;
		temp->priround = 2;
		temp->state = 'W';
		//尾插
		p2 = p;
		while (p2->next)
		{
			p2 = p2->next;
		}
		temp->next = NULL;
		p2->next = temp;
	}
	cout << "各进程初始状态：" << endl;
	tsroutput(p);

	cout <<endl<< "运行状态：" << endl;
	tsrrun(p);
	return 1;
}
//运行
int tsrrun(pcb *pp)
{
	//p 原队列 p2 完成队列 p1执行的进程 p3进行队列排列的中介
	pcb *p, *p1, *p2,*p3;
	p = pp;
	p2 = new pcb;
	p2->next = NULL;
	while (p->next)
	{
		p1 = p->next;
		//当进程时间片<2时
		if (p1->needtime < 2)
		{
			p1->cputime += p1->needtime;
			p1->needtime = 0;
			p1->state = 'R';
			
			cout << endl<<"未完成的进程:"<< endl;
			tsroutput(p);

			//p指向下一个
			p->next = p1->next;
			//p1放入 p2队列
			p1->state = 'F';
			p1->next = p2->next;
			p2->next = p1;
			cout <<endl<< "已完成的进程：" << endl;
			//show p2
			tsroutput(p2);
		}
		//进程时间片 >2时
		if (p1->needtime >= 2)
		{
			p1->cputime += 2;
			p1->needtime -= 2;
			p1->state = 'R';
			cout << endl << "未完成的进程:" << endl;
			tsroutput(p);
			if (p1->needtime == 0)
			{
				//p指向p1下一个
				p->next = p1->next;
				
				//p1放入 p2队列
				p1->state = 'F';
				p1->next = p2->next;
				p2->next = p1;

				cout <<endl<< "已完成的进程：" << endl;
				tsroutput(p2);
			}
			else
			{
				//p1放入p队尾
				p->next = p1->next;
				p3 = p;
				while (p3->next)
				{
					p3 = p3->next;
				}
				p3->next = p1;
				p1->next = NULL;
			}
		}
	}
	return 1;
}
//输出
int tsroutput(pcb *pp)
{
	pcb *p = pp;
	cout << "进程名 轮转时间片数 进程占用CPU时间 进程到完成还需要的时间 进程状态" << endl;
	while (p->next)
	{
		p = p->next;
		cout << "  " << p->name << "	  " << p->priround << "		" << p->cputime << "		"
			<< p->needtime << "		    " << p->state << endl;
	}
	return 1;
}