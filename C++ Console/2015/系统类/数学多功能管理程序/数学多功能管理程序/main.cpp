//��ѧ�๦�ܹ������
#include"shuguan.h"
void main()
{
	shuguan a;
	int n;

	while(1)
	{
		cout<<"��������Ҫ���ܵ���� 1�������(1000����) 2ˮ�ɻ��� 3�������(1000����)"<<endl;
		cout<<"4ð�ݷ����� 5�ַ�������Ϣ�������  6�˳�"<<endl;
		cin>>n;
		if(n==1)
		{
			cout<<"1000��������"<<endl;
			a.sushu();
		}

		else if(n==2)
		{
			cout<<"100--1000�ڵ�ˮ�ɻ���"<<endl;
			a.shuixianhua();
		}

		else if(n==3)
		{
			cout<<"1000���ڵ�����"<<endl;
			a.wanshu();
		}

		else if(n==4)
			a.paixu();
		else if(n==5)
			a.zxfh();
		else if(n==6)
			break;
		else
			cout<<"�޴˹��ܣ�"<<endl;

	}
}