#include "caiquan.h"
int caiquan::getn()//��������
{
	int n;
	srand((int)time(0));
	n=rand()%2+1;
	return n;
}
int caiquan::playerinput()//�������
{
	int m;
	cout<<"��1��3����һ����������1����ʯͷ��2���������3����"<<endl;
	cin>>m;
	while(m<1||m>3)
	{
		cout<<"���벻�Ϸ�����������"<<endl;
		cin>>m;
	}
	return m;
}
void caiquan::begin(caiquan cq)
{
	int n,m,x=0,i=0,c=0,a=0,b=0;
	n=cq.getn();
	m=cq.playerinput();
	while(1)
	{
		
		if(n==1&&m==1)//���������Ҷ���ʯͷ
		{
			i++;
			cout<<"���ǵ� "<<i<<" ��"<<endl;
			cout<<"���������Ҷ���ʯͷ��ƽ��"<<endl;
			c++;
			while(1)
			{
				cout<<endl<<"ѡ��������Ĳ��� 1����Ϸ 2��Ϸ����"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"�ܹ����� "<<i<<" ��"<<endl;
					cout<<"ƽ���ܹ� "<<c<<" ��"<<endl;
					cout<<"���ʤ�� "<<a<<" ��"<<endl;
					cout<<"���ʧ�� "<<b<<" ��"<<endl;
					break;
				}
				else
					cout<<"�޴˹���!"<<endl;
			}
			if(x==2)
				break;
		}
		if(n==2&&m==2)//���������Ҷ�������
		{
			i++;
			cout<<"���ǵ� "<<i<<" ��"<<endl;
			cout<<"���������Ҷ���������ƽ��"<<endl;
			c++;
			while(1)
			{
				cout<<endl<<"ѡ��������Ĳ��� 1����Ϸ 2��Ϸ����"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"�ܹ����� "<<i<<" ��"<<endl;
					cout<<"ƽ���ܹ� "<<c<<" ��"<<endl;
					cout<<"���ʤ�� "<<a<<" ��"<<endl;
					cout<<"���ʧ�� "<<b<<" ��"<<endl;
					break;
				}
				else
					cout<<"�޴˹���!"<<endl;
			}
			if(x==2)
				break;
		}
		if(n==3&&m==3)//���������Ҷ�����
		{
			i++;
			cout<<"���ǵ� "<<i<<" ��"<<endl;
			cout<<"���������Ҷ�������ƽ��"<<endl;
			c++;
			while(1)
			{
				cout<<endl<<"ѡ��������Ĳ��� 1����Ϸ 2��Ϸ����"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"�ܹ����� "<<i<<" ��"<<endl;
					cout<<"ƽ���ܹ� "<<c<<" ��"<<endl;
					cout<<"���ʤ�� "<<a<<" ��"<<endl;
					cout<<"���ʧ�� "<<b<<" ��"<<endl;
					break;
				}
				else
					cout<<"�޴˹���!"<<endl;
			}
			if(x==2)
				break;
		}
		if(n==1&&m==2)//�������ʯͷ����ҳ�����
		{
			i++;
			cout<<"���ǵ� "<<i<<" ��"<<endl;
			cout<<"�������ʯͷ����ҳ����������ʧ��"<<endl;
			b++;
			while(1)
			{
				cout<<endl<<"ѡ��������Ĳ��� 1����Ϸ 2��Ϸ����"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"�ܹ����� "<<i<<" ��"<<endl;
					cout<<"ƽ���ܹ� "<<c<<" ��"<<endl;
					cout<<"���ʤ�� "<<a<<" ��"<<endl;
					cout<<"���ʧ�� "<<b<<" ��"<<endl;
					break;
				}
				else
					cout<<"�޴˹���!"<<endl;
			}
			if(x==2)
				break;
		}
		if(n==1&&m==3)//�������ʯͷ����ҳ���
		{
			i++;
			cout<<"���ǵ� "<<i<<" ��"<<endl;
			cout<<"�������ʯͷ����ҳ��������ʤ��"<<endl;
			a++;
			while(1)
			{
				cout<<endl<<"ѡ��������Ĳ��� 1����Ϸ 2��Ϸ����"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"�ܹ����� "<<i<<" ��"<<endl;
					cout<<"ƽ���ܹ� "<<c<<" ��"<<endl;
					cout<<"���ʤ�� "<<a<<" ��"<<endl;
					cout<<"���ʧ�� "<<b<<" ��"<<endl;
					break;
				}
				else
					cout<<"�޴˹���!"<<endl;
			}
			if(x==2)
				break;
		}
		if(n==2&&m==3)//���������������ҳ���
		{
			i++;
			cout<<"���ǵ� "<<i<<" ��"<<endl;
			cout<<"���������������ҳ��������ʧ��"<<endl;
			b++;
			while(1)
			{
				cout<<endl<<"ѡ��������Ĳ��� 1����Ϸ 2��Ϸ����"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"�ܹ����� "<<i<<" ��"<<endl;
					cout<<"ƽ���ܹ� "<<c<<" ��"<<endl;
					cout<<"���ʤ�� "<<a<<" ��"<<endl;
					cout<<"���ʧ�� "<<b<<" ��"<<endl;
					break;
				}
				else
					cout<<"�޴˹���!"<<endl;
			}
			if(x==2)
				break;
		}
		if(n==2&&m==1)//���������������ҳ�ʯͷ
		{
			i++;
			cout<<"���ǵ� "<<i<<" ��"<<endl;
			cout<<"���������������ҳ�ʯͷ�����ʤ��"<<endl;
			a++;
			while(1)
			{
				cout<<endl<<"ѡ��������Ĳ��� 1����Ϸ 2��Ϸ����"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"�ܹ����� "<<i<<" ��"<<endl;
					cout<<"ƽ���ܹ� "<<c<<" ��"<<endl;
					cout<<"���ʤ�� "<<a<<" ��"<<endl;
					cout<<"���ʧ�� "<<b<<" ��"<<endl;
					break;
				}
				else
					cout<<"�޴˹���!"<<endl;
			}
			if(x==2)
				break;
		}
		if(n==3&&m==1)//�������������ҳ�ʯͷ
		{
			i++;
			cout<<"���ǵ� "<<i<<" ��"<<endl;
			cout<<"�������������ҳ�ʯͷ�����ʧ��"<<endl;
			b++;
			while(1)
			{
				cout<<endl<<"ѡ��������Ĳ��� 1����Ϸ 2��Ϸ����"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"�ܹ����� "<<i<<" ��"<<endl;
					cout<<"ƽ���ܹ� "<<c<<" ��"<<endl;
					cout<<"���ʤ�� "<<a<<" ��"<<endl;
					cout<<"���ʧ�� "<<b<<" ��"<<endl;
					break;
				}
				else
					cout<<"�޴˹���!"<<endl;
			}
			if(x==2)
				break;
		}
		if(n==3&&m==2)//�������������ҳ�����
		{
			i++;
			cout<<"���ǵ� "<<i<<" ��"<<endl;
			cout<<"�������������ҳ����������ʤ��"<<endl;
			a++;
			while(1)
			{
				cout<<endl<<"ѡ��������Ĳ��� 1����Ϸ 2��Ϸ����"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"�ܹ����� "<<i<<" ��"<<endl;
					cout<<"ƽ���ܹ� "<<c<<" ��"<<endl;
					cout<<"���ʤ�� "<<a<<" ��"<<endl;
					cout<<"���ʧ�� "<<b<<" ��"<<endl;
					break;
				}
				else
					cout<<"�޴˹���!"<<endl;
			}
			if(x==2)
				break;
		}
	}
}
caiquan::caiquan(void)
{
}


caiquan::~caiquan(void)
{
}