#include "guess.h"

int guess::getn()//��������
{
	int m;
	srand((int)time(0));//srand((int)time(0))��ʾ�Ե�ǰʱ���Ӧ��intֵΪ����������
	m=rand()%9999+1;	//time(0) time����������1970��1��1��00:00:00���������
	return m;
}
int guess::settime()//������Ϸʱ��
{
	int s;
	cout<<"����������������Ϸ�����ֵ�ʱ��(��)���������enter��Ϸ��ʼ"<<endl;
	cin>>s;
	return s;
}
int guess::playerinput()//���������������
{
	int g;
	cout<<"�������µ���"<<endl;
	cin>>g;
	return g;
}
void guess::tishi(guess gu,int g,int m)//��Ϸ��ʾ
{
	int c,n;
	c=g;		//�������
	n=m;		//�����
	if(c>n)
		cout<<"����"<<endl;
	else if(c<n)
		cout<<"С��"<<endl;
	else 
		cout<<"��ϲ������ˣ���ȷ�³�����  "<<n<<endl;
}
void guess::begin(guess gu)
{
	int m,g,s,x=0;// m����� g������� s�����ʱ��
	m=gu.getn();	//��������
	s=gu.settime();//������Ϸʱ��
	long t=clock();// ��ʼ��ʱ
	while((clock()-t)/CLOCKS_PER_SEC<=s)
	{
		cout<<"��ʣʱ�� "<<s-(clock()-t)/CLOCKS_PER_SEC<<" ��"<<endl;
		if(s-(clock()-t)/CLOCKS_PER_SEC==0)
			break;
		g=gu.playerinput();
		gu.tishi(gu,g,m);//��Ϸ��ʾ
		if(g==m)
		{
			int miao;
			cout<<endl;
			cout<<"����ͣ���ڴ˽����������������������ʾ����"<<endl;
			cin>>miao;
			Sleep(1000*miao);//����ͣ��ʱ��
			break;
		}
	}
	if((clock()-t)/CLOCKS_PER_SEC>=s)
	{
		int miao;
		cout<<"ʱ�䵽�����ź�δ�³����� "<<s<<endl;
		cout<<endl;
		cout<<"����ͣ���ڴ˽����������������������ʾ����"<<endl;
		cin>>miao;
		Sleep(1000*miao);//����ͣ��ʱ��
	}
		
}
void guess::again()//����Ϸ
{
	system("cls");
	guess gu;
	int x;
	cout<<"ѡ��������Ĳ��� 1����Ϸ 2������Ϸ"<<endl;
	cin>>x;
	while(x==1)
	{
		gu.begin(gu);
		cout<<"ѡ��������Ĳ��� 1����Ϸ 2������Ϸ"<<endl;
		cin>>x;
	}
}
guess::guess(void)
{
}
guess::~guess(void)
{
}

