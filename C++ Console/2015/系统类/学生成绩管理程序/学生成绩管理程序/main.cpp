#include"xjguan.h"

void main()
{
	xjguan xj1;
	int c=0;
	while(1)
	{
		int xh;//���xh
		cout<<"��������Ҫ�Ĳ������ 1���� 2��� 3���� 4���� 5��ѯ 6��ʾ 7�˳�"<<endl;
		cin>>xh;
		if(xh==1)
		{
			int d;
			cout<<"��������Ҫ�����ĸ���"<<endl;
			cin>>d;
			xj1.apply(d);
			cout<<"���� ѧ�� ���� ���� ��ѧ Ӣ��ɼ�"<<endl;
			xj1.input1(c,d);
			c=d;
		}
		else if(xh==2)
		{
			int choice,place;
			int in,n;
			cout<<"ѡ�����  1����ѧ����Ϣ��ĳλ�� 2�����е�ѧ����Ϣ����׷��"<<endl;
			while(1)
			{
				cin>>choice;
				if(choice==1)
				{
					cout<<"����Ҫ�����λ��"<<endl;
					cin>>place;
					cout<<"����Ҫ���������"<<endl;
					cin>>in;
					n=c+in;
					xj1.apply(n);
					xj1.charu(place,in,n);
					cout<<"���� ѧ�� ���� ���� ��ѧ Ӣ��ɼ�"<<endl;
					if(place>c)
						xj1.input1(c,n);
					else
						xj1.input1(place,place+in);
					c=n;
					break;
				}
				else if(choice==2)
				{
					cout<<"����Ҫ��ӵ�����"<<endl;
					cin>>in;
					n=c+in;
					xj1.apply(n);
					cout<<"���� ѧ�� ���� ��ѧ Ӣ�� ���ĳɼ�"<<endl;
					xj1.input1(c,n);
					c=n;
					break;
				}
				else
					cout<<"�޴˹��ܣ����������룡"<<endl;
			}
		}
		else if(xh==3)
		{
			cout<<"���ѧ�� ���� �ܷ�"<<endl;
			xj1.huizong(c);
		}
		else if(xh==4)
		{
			cout<<"���������ѧ�� ���� ���� ��ѧ Ӣ��ɼ� ƽ���� �ܷ�"<<endl;
			xj1.paixu(c);
		}
		else if(xh==5)
		{
			string cha;
			cout<<"���뱻������ѧ��"<<endl;
			cin>>cha;
			xj1.chazhao(c,cha);
		}
		else if(xh==6)
		{
			cout<<"��� ѧ�� ���� ���� ��ѧ Ӣ��ɼ� ƽ���� �ܷ�"<<endl;
			xj1.output1(0,c);
		}
		else if(xh==7)
			break;
		else
			cout<<"�޴˹���"<<endl;
	}
}