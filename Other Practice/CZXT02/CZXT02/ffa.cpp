//�״���Ӧ�㷨 
#include"headfile.h"
//����0��ʾδ�ɹ�
int ffa(node *head)
{
	node *temp, *p;
	temp = new node;
	p = head;
	cout << "���������С��";
	cin >> temp->size;
	temp->state = 1; //״̬��Ϊ�ѷ���
	while (p->next)
	{
		p = p->next;
		//���п��С ���� ����ķ�����С
		if (p->state == 0 && p->size == temp->size)
		{
			p->state = 1;
			return 1;
			break;
		}
		//���п��С ���� ����ķ�����С
		if (p->state == 0 && p->size > temp->size)
		{
			//��temp��������
			temp->prior = p->prior;
			temp->next = p;
			p->prior->next = temp;
			p->prior = temp;
			//��������
			temp->adr = p->adr; //��ַ
			temp->endadr = temp->adr + temp->size;
			p->adr = temp->endadr;
			p->size -= temp->size;
			return 1;
			break;
		}
	}
	return 0;
}