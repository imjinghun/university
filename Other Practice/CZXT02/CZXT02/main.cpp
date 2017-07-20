#include"headfile.h"

struct node *head, *tail;
int sum;//总的分区数

int init();
int ffa(node *head);
int bfa(node *head);
void reclaim(int id);
void show();
void alloc(int choice);

void main()
{
	int choice, choice2; //算法 操作
	cout << "( 1 首次适应算法\t2 最佳适应算法\t0 退出 )" << endl;
	cout << "请输入所使用的内存分配算法：";
	cin >> choice;

	while (choice != 0 && choice != 1 && choice != 2)
	{
		cout << "输入错误，请重新输入：";
		cin >> choice;
	}
	if (choice == 0)
	{
		return;
	}

	init(); //初始化空闲区

	while (1)
	{
		show();
		
		cout << "请输入您的操作(1 分配内存\t2 回收内存\t0 退出)：";
		cin >> choice2;

		if (choice2 == 1)
		{
			alloc(choice); // 分配内存
		}
		else if (choice2 == 2)  // 内存回收
		{
			int id;
			cout << "请输入您要释放的分区号：";
			cin >> id;
			reclaim(id);
		}
		else if (choice2 == 0)
		{
			break; //退出
		}
		else //输入操作有误
		{
			cout << "输入有误，请重试！" << endl;
			continue;
		}
	}
}

//初始化空闲区
int init()
{
	head = new node;
	tail = new node;

	head->prior = NULL;
	head->next = tail;
	tail->prior = head;
	tail->next = NULL;

	tail->adr = 0;
	tail->size = 32767;
	tail->endadr = 32767;
	tail->state = 0;

	return 1;
}
//分配
void alloc(int choice)
{
	int result;
	if (choice == 1)
	{
		result = ffa(head);
		if (result == 0)
		{
			cout << "内存不足，分配失败" << endl;
		}
	}
	if (choice == 2)
	{
		result = bfa(head);
		if (result == 0)
		{
			cout << "内存不足，分配失败" << endl;
		}
	}
}
//回收
void reclaim(int id)
{
	if (id >= sum) //表示无此分区
	{
		cout << "无此分区" << endl;
		return;
	}
	node *p;
	p = head;
	for (int i = 0; i <= id; i++)
	{
		p = p->next;
	}
	//无空闲区相连
	p->state = 0;
	//p就是最后一个
	if (p->next == NULL)
	{
		return;
	}
	//和前面空闲区相连 
	if (p->prior != head&&p->prior->state == 0)
	{
		p->prior->size += p->size;
		p->prior->endadr = p->endadr;

		p->prior->next = p->next;
		p->next->prior = p->prior;

		p = p->prior;
	}
	//和后面空闲区相连
	if (p->next != tail && p->next->state == 0)//与后面的空闲块相连
	{
		p->size += p->next->size;
		p->endadr = p->next->endadr;
		if (p->next->next != NULL)
		{
			p->next->next->prior = p;
		}
		p->next = p->next->next;
	}
	//与最后的空闲块相连
	if (p->next == tail && p->next->state == 0)
	{
		p->size += p->next->size;
		p->endadr = p->next->endadr;
		p->next = p->next->next;
	}
}
void show()
{
	int flag = 0;
	node *p = head;
	cout << "******************************************************************" << endl;
	cout << "\n主存分配情况:\n";
	cout << "分区号 \t首址\t终址\t分区大小\t状态\n";
	while (p->next)
	{
		p = p->next;
		cout << "  "<< flag++ << "\t ";
		cout << p->adr << "\t";
		cout << p->endadr << "\t  ";
		cout << p->size << "\t\t";
		if (p->state == 0)
		{
			cout << "空闲"<<endl;
		}
		else
		{
			cout << "已分配"<<endl;
		}
	}
	cout << "\n******************************************************************" << endl;
	sum = flag;
}

