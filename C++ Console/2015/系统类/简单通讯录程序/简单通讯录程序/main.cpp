#include"tongxun.h"
void main()
{
	tongxun tx1;
	int c=0;
	while(1)
	{
		int xh;//���xh
		cout<<"��������Ҫ�Ĳ������ 1���� 2��� 3��ѯ 4�޸� 5ɾ�� 6��ʾ 7�˳�"<<endl;
		cin>>xh;
		if(xh==1)
		{
			int d;
			cout<<"��������Ҫ�����ĸ���"<<endl;
			cin>>d;
			tx1.apply(d);
			cout<<"���� ��� ���� ���� �Ա� լ�� �ֻ�����"<<endl;
			tx1.input1(c,d);
			c=d;
		}
		else if(xh==2)
		{
			int in,n;
			cout<<"������Ҫ��ӵĸ���"<<endl;
			cin>>in;
			n=c+in;
			tx1.apply(n);
			cout<<"���� ��� ���� ���� �Ա� լ�� �ֻ�����"<<endl;
			tx1.input1(c,n);
			c=n;
		}
		else if(xh==3)
		{
			string cha;
			cout<<"���뱻�����ߵ��������ֻ���"<<endl;
			cin>>cha;
			tx1.chazhao(c,cha);
		}
		else if(xh==4)
		{
			string gai;
			cout<<"���뱻�޸��ߵ�����"<<endl;
			cin>>gai;
			tx1.xiugai(c,gai);
		}
		else if(xh==5)
		{
			string shan;
			cout<<"���뱻ɾ���ߵ�����"<<endl;
			cin>>shan;
			tx1.apply(c+1);
			tx1.shanchu(c,shan);
			c--;
		}
		else if(xh==6)
		{
			cout<<"��� ��� ���� ���� �Ա� լ�� �ֻ�����"<<endl;
			tx1.output1(0,c);
		}
		else if(xh==7)
			break;
		else
			cout<<"�޴˹���"<<endl;
	}
}