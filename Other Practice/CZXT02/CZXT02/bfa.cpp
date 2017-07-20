//最佳适应算法
#include"headfile.h"

int bfa(node *head)
{
	node *temp, *p, *p2;
	temp = new node;
	p = head;
	cout << "输入分区大小：";
	cin >> temp->size;
	temp->state = 1; //状态设为已分配

	int minsize;//最小剩余空间
	p2 = NULL;
	//寻找最佳位置 并记录最小剩余空间
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
		// 将temp加入链表
		temp->prior = p2->prior;
		temp->next = p2;
		p2->prior->next = temp;
		p2->prior = temp;
		//设置属性
		temp->adr = p2->adr; //首址
		temp->endadr = temp->adr + temp->size;
		p2->adr = temp->endadr;
		p2->size = minsize;
		return 1;
	}
}