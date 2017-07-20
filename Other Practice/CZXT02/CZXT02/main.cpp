#include"headfile.h"

struct node *head, *tail;
int sum;//�ܵķ�����

int init();
int ffa(node *head);
int bfa(node *head);
void reclaim(int id);
void show();
void alloc(int choice);

void main()
{
	int choice, choice2; //�㷨 ����
	cout << "( 1 �״���Ӧ�㷨\t2 �����Ӧ�㷨\t0 �˳� )" << endl;
	cout << "��������ʹ�õ��ڴ�����㷨��";
	cin >> choice;

	while (choice != 0 && choice != 1 && choice != 2)
	{
		cout << "����������������룺";
		cin >> choice;
	}
	if (choice == 0)
	{
		return;
	}

	init(); //��ʼ��������

	while (1)
	{
		show();
		
		cout << "���������Ĳ���(1 �����ڴ�\t2 �����ڴ�\t0 �˳�)��";
		cin >> choice2;

		if (choice2 == 1)
		{
			alloc(choice); // �����ڴ�
		}
		else if (choice2 == 2)  // �ڴ����
		{
			int id;
			cout << "��������Ҫ�ͷŵķ����ţ�";
			cin >> id;
			reclaim(id);
		}
		else if (choice2 == 0)
		{
			break; //�˳�
		}
		else //�����������
		{
			cout << "�������������ԣ�" << endl;
			continue;
		}
	}
}

//��ʼ��������
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
//����
void alloc(int choice)
{
	int result;
	if (choice == 1)
	{
		result = ffa(head);
		if (result == 0)
		{
			cout << "�ڴ治�㣬����ʧ��" << endl;
		}
	}
	if (choice == 2)
	{
		result = bfa(head);
		if (result == 0)
		{
			cout << "�ڴ治�㣬����ʧ��" << endl;
		}
	}
}
//����
void reclaim(int id)
{
	if (id >= sum) //��ʾ�޴˷���
	{
		cout << "�޴˷���" << endl;
		return;
	}
	node *p;
	p = head;
	for (int i = 0; i <= id; i++)
	{
		p = p->next;
	}
	//�޿���������
	p->state = 0;
	//p�������һ��
	if (p->next == NULL)
	{
		return;
	}
	//��ǰ����������� 
	if (p->prior != head&&p->prior->state == 0)
	{
		p->prior->size += p->size;
		p->prior->endadr = p->endadr;

		p->prior->next = p->next;
		p->next->prior = p->prior;

		p = p->prior;
	}
	//�ͺ������������
	if (p->next != tail && p->next->state == 0)//�����Ŀ��п�����
	{
		p->size += p->next->size;
		p->endadr = p->next->endadr;
		if (p->next->next != NULL)
		{
			p->next->next->prior = p;
		}
		p->next = p->next->next;
	}
	//�����Ŀ��п�����
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
	cout << "\n����������:\n";
	cout << "������ \t��ַ\t��ַ\t������С\t״̬\n";
	while (p->next)
	{
		p = p->next;
		cout << "  "<< flag++ << "\t ";
		cout << p->adr << "\t";
		cout << p->endadr << "\t  ";
		cout << p->size << "\t\t";
		if (p->state == 0)
		{
			cout << "����"<<endl;
		}
		else
		{
			cout << "�ѷ���"<<endl;
		}
	}
	cout << "\n******************************************************************" << endl;
	sum = flag;
}

