#include "chess.h"

void chess::output()//���
{
		cout<<"��"<<"��"<<"��"<<""<<"��"<<"��"<<"��"<<"��"<<endl;
		cout<<"��"<<str[0][0]<<" ��"<<str[0][1]<<" ��"<<str[0][2]<<" ��"<<endl;
		cout<<"��"<<"��"<<"��"<<""<<"��"<<"��"<<"��"<<"��"<<endl;
		cout<<"��"<<str[1][0]<<" ��"<<str[1][1]<<" ��"<<str[1][2]<<" ��"<<endl;
		cout<<"��"<<"��"<<"��"<<""<<"��"<<"��"<<"��"<<"��"<<endl;
		cout<<"��"<<str[2][0]<<" ��"<<str[2][1]<<" ��"<<str[2][2]<<" ��"<<endl;
		cout<<"��"<<"��"<<"��"<<""<<"��"<<"��"<<"��"<<"��"<<endl;
}
int suiji()//����������λ��
{
	int sj;
	srand((int)time(0));
	sj=rand()%3;
	return sj;
}
void chess::choose2()//����ѡ������
{
	int place1,place2;
	place1=suiji();
	place2=suiji();
	while(1)//���Ի�õ�λ�ú���һ��Լ���ͬʱ���������»��λ��
	{
		if(a[place1][place2]==0)
		{
			if(str1=="x")
				str[place1][place2]=str2;//str2����o,�Ѿ���ʼ��
			else
				str[place1][place2]=str1;
			break;
		}
		else
		{
			place1=suiji();
			place2=suiji();
		}
	}
	a[place1][place2]=4;
}
void chess::choose1(string s)//���ѡ������
{
	int place1,place2;
	cin>>place1>>place2;
	while(1)//���ѡ���λ�ú͵��Ի��Լ���ͬʱ���������ѡ��λ��
	{
		if(a[place1-1][place2-1]==0)
		{
			str[place1-1][place2-1]=s;//sΪ���ѡ������
			break;
		}
		else
		{
			cout<<"λ���ѱ�ռ��������ѡ��λ��"<<endl;
			cin>>place1>>place2;
		}
	}
	a[place1-1][place2-1]=1;
}
void chess::choose11()//���ѡ������(��������ʱ)
{
	int place1,place2;
	cin>>place1>>place2;
	while(1)//���ѡ���λ�ú͵��Ի��Լ���ͬʱ���������ѡ��λ��
	{	
		if(a[place1-1][place2-1]==0)
		{
			str[place1-1][place2-1]=str1;//sΪ���ѡ������
			break;
		}
		else
		{
			cout<<"λ���ѱ�ռ��������ѡ��λ��"<<endl;
			cin>>place1>>place2;
		}
	}
	a[place1-1][place2-1]=1;
}
bool chess::pan1()//���ʤ
{
	bool f=false;
	int sum=0,i,j;
	for(i=0;i<3;i++)//�ж���
	{
		for(j=0;j<3;j++)
			sum+=a[i][j];
		if(sum==3)
		{
			f=true;
			break;
		}
	}
	sum=0;
	for(i=0;i<3;i++)//�ж���
	{
		for(j=0;j<3;j++)
			sum+=a[j][i];
		if(sum==3)
		{
			f=true;
			break;
		}
	}
	sum=0;
	for(i=0;i<3;i++)//�ж����Խ���
	{
		sum+=a[i][i];
		if(sum==3)
			f=true;
	}
	sum=0;
	j=3;
	for(i=0;i<3;i++)//�жϴζԽ���
	{
		j--;
		sum+=a[i][j];
		if(sum==3)
			cout<<"���ʤ"<<endl;
	}
	return f;
}
bool chess::pan2()//����ʤ
{
	bool f=false;
	int sum=0,i,j;
	for(i=0;i<3;i++)//�ж���
	{
		for(j=0;j<3;j++)
			sum+=a[i][j];
		if(sum==12)
		{
			f=true;
			break;
		}
	}
	sum=0;
	for(i=0;i<3;i++)//�ж���
	{
		for(j=0;j<3;j++)
			sum+=a[j][i];
		if(sum==12)
		{
			f=true;
			break;
		}
	}
	sum=0;
	for(i=0;i<3;i++)//�ж����Խ���
	{
		sum+=a[i][i];
		if(sum==12)
			f=true;
	}
	sum=0;
	j=3;
	for(i=0;i<3;i++)//�жϴζԽ���
	{
		j--;
		sum+=a[i][j];
		if(sum==12)
			f=true;
	}
	return f;
}
void chess::start1()//��ʼ��Ϸ(�������)
{
	bool flag;
	string str3;
	chess cs;
	cout<<"ѡ����Ҫʹ�õ����� 'X' �� 'O'"<<endl;//����˫����
	cin>>str3;
	cout<<"��ʼ״̬"<<endl;
	cs.output();
	cout<<"ѡ����Ҫ�µ�λ��(�Ӵ��С�*���ŵ�λ��ѡ) ��������λ��"<<endl;
	while(1)
	{
		cout<<"�����"<<endl;
		cout<<endl;
		cs.choose1(str3);
		cs.output();
		flag=cs.pan1();
		if(flag==true)
		{
			cout<<"���ʤ"<<endl;
			break;
		}
		cout<<endl;
		cout<<"������"<<endl;
		cout<<endl;
		cs.choose2();
		cs.output();
		flag=cs.pan2();
		if(flag==true)
		{
			cout<<"����ʤ"<<endl;
			break;
		}
	}
}
void chess::start2()//��ʼ��Ϸ(��������)
{
	int m=1;
	bool flag;
	string str3;
	chess cs;
	cout<<"��ʼ״̬"<<endl;
	cs.output();
	while(1)
	{
		cout<<"������"<<endl;
		cout<<endl;
		cs.choose2();
		cs.output();
		flag=cs.pan2();
		if(flag==true)
		{
			cout<<"����ʤ"<<endl;
			break;
		}
		if(m==1)
		{
			cout<<"ѡ����Ҫ�µ�λ��(�Ӵ��С�*���ŵ�λ��ѡ) ��������λ��"<<endl;
			m=0;
		}
		cout<<"�����"<<endl;
		cout<<endl;
		cs.choose11();
		cs.output();
		cout<<endl;
		flag=cs.pan1();
		if(flag==true)
		{
			cout<<"���ʤ"<<endl;
			break;
		}
	}
}
chess::chess(void)
{
	int i,j;
	for(i=0;i<3;i++)
		for(j=0;j<3;j++)
		{
			str[i][j]="*";
			a[i][j]=0;
		}
	str2="o";
	str1="x";
}
chess::~chess(void)
{
}
