//�����Ӧ�㷨
#include"headfile.h"

int bfa(node *head)
{
	node *temp, *p, *p2;
	temp = new node;
	p = head;
	cout << "���������С��";
	cin >> temp->size;
	temp->state = 1; //״̬��Ϊ�ѷ���

	int minsize;//��Сʣ��ռ�
	p2 = NULL;
	//Ѱ�����λ�� ����¼��Сʣ��ռ�
	while (p->next)
	{
		p = p->next;
		if (p->state == 0 && p->size >= temp->size)
		{
			if (p2 == NULL)
			{
				p2 = p;
				minsize = p->size - temp->size;
			}
			else if (p2->size > p->size)
			{
				p2 = p;
				minsize = p->size - temp->size;
			}
		}
	}
	if (p2 == NULL)
	{
		return 0;
	}
	else if (p2->size == temp->size)
	{
		p2->state = 1;
		return 1;
	}
	else
	{
		// ��temp��������
		temp->prior = p2->prior;
		temp->next = p2;
		p2->prior->next = temp;
		p2->prior = temp;
		//��������
		temp->adr = p2->adr; //��ַ
		temp->endadr = temp->adr + temp->size;
		p2->adr = temp->endadr;
		p2->size = minsize;
		return 1;
	}
}