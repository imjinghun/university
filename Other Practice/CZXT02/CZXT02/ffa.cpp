//首次适应算法 
#include"headfile.h"
//返回0表示未成功
int ffa(node *head)
{
	node *temp, *p;
	temp = new node;
	p = head;
	cout << "输入分区大小：";
	cin >> temp->size;
	temp->state = 1; //状态设为已分配
	while (p->next)
	{
		p = p->next;
		//空闲块大小 等于 申请的分区大小
		if (p->state == 0 && p->size == temp->size)
		{
			p->state = 1;
			return 1;
			break;
		}
		//空闲块大小 大于 申请的分区大小
		if (p->state == 0 && p->size > temp->size)
		{
			//将temp加入链表
			temp->prior = p->prior;
			temp->next = p;
			p->prior->next = temp;
			p->prior = temp;
			//设置属性
			temp->adr = p->adr; //首址
			temp->endadr = temp->adr + temp->size;
			p->adr = temp->endadr;
			p->size -= temp->size;
			return 1;
			break;
		}
	}
	return 0;
}