//ʱ��Ƭ��ת�����㷨
#include"common.h"
int tsroutput(pcb *pp);
int tsrrun(pcb *pp);
int tsr()
{
	pcb *p = new pcb, *temp,*p2;
	p->next = NULL;
	cout << "������������������������Ҫ��ʱ��" << endl;
	for (int i = 0; i < 5; i++)
	{
		temp = new pcb;
		cin >> temp->name >> temp->needtime;
		temp->cputime = 0;
		temp->priround = 2;
		temp->state = 'W';
		//β��
		p2 = p;
		while (p2->next)
		{
			p2 = p2->next;
		}
		temp->next = NULL;
		p2->next = temp;
	}
	cout << "�����̳�ʼ״̬��" << endl;
	tsroutput(p);

	cout <<endl<< "����״̬��" << endl;
	tsrrun(p);
	return 1;
}
//����
int tsrrun(pcb *pp)
{
	//p ԭ���� p2 ��ɶ��� p1ִ�еĽ��� p3���ж������е��н�
	pcb *p, *p1, *p2,*p3;
	p = pp;
	p2 = new pcb;
	p2->next = NULL;
	while (p->next)
	{
		p1 = p->next;
		//������ʱ��Ƭ<2ʱ
		if (p1->needtime < 2)
		{
			p1->cputime += p1->needtime;
			p1->needtime = 0;
			p1->state = 'R';
			
			cout << endl<<"δ��ɵĽ���:"<< endl;
			tsroutput(p);

			//pָ����һ��
			p->next = p1->next;
			//p1���� p2����
			p1->state = 'F';
			p1->next = p2->next;
			p2->next = p1;
			cout <<endl<< "����ɵĽ��̣�" << endl;
			//show p2
			tsroutput(p2);
		}
		//����ʱ��Ƭ >2ʱ
		if (p1->needtime >= 2)
		{
			p1->cputime += 2;
			p1->needtime -= 2;
			p1->state = 'R';
			cout << endl << "δ��ɵĽ���:" << endl;
			tsroutput(p);
			if (p1->needtime == 0)
			{
				//pָ��p1��һ��
				p->next = p1->next;
				
				//p1���� p2����
				p1->state = 'F';
				p1->next = p2->next;
				p2->next = p1;

				cout <<endl<< "����ɵĽ��̣�" << endl;
				tsroutput(p2);
			}
			else
			{
				//p1����p��β
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
//���
int tsroutput(pcb *pp)
{
	pcb *p = pp;
	cout << "������ ��תʱ��Ƭ�� ����ռ��CPUʱ�� ���̵���ɻ���Ҫ��ʱ�� ����״̬" << endl;
	while (p->next)
	{
		p = p->next;
		cout << "  " << p->name << "	  " << p->priround << "		" << p->cputime << "		"
			<< p->needtime << "		    " << p->state << endl;
	}
	return 1;
}