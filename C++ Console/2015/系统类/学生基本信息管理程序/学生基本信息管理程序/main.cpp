#include"xinguan.h"
void main()
{
	xinguan xg1;
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
			xg1.apply(d);
			cout<<"���� ѧ�š��������Ա����䡢�༶��ѧԺ��רҵ"<<endl;
			xg1.input1(c,d);
			c=d;
		}
		else if(xh==2)
		{
			int in,n;
			cout<<"������Ҫ��ӵĸ���"<<endl;
			cin>>in;
			n=c+in;
			xg1.apply(n);
			cout<<"���� ѧ�š��������Ա����䡢�༶��ѧԺ��רҵ"<<endl;
			xg1.input1(c,n);
			c=n;
		}
		else if(xh==3)
		{
			string cha;
			cout<<"���뱻���ҵ�ѧ�Ű༶��רҵ"<<endl;
			cin>>cha;
			xg1.chazhao(c,cha);
		}
		else if(xh==4)
		{
			string gai;
			cout<<"���뱻�޸��ߵ�ѧ��"<<endl;
			cin>>gai;
			xg1.xiugai(c,gai);
		}
		else if(xh==5)
		{
			string shan;
			cout<<"���뱻ɾ���ߵ�����"<<endl;
			cin>>shan;
			xg1.apply(c+1);
			xg1.shanchu(c,shan);
			c--;
		}
		else if(xh==6)
		{
			cout<<"��� ѧ�š��������Ա����䡢�༶��ѧԺ��רҵ"<<endl;
			xg1.output1(0,c);
		}
		else if(xh==7)
			break;
		else
			cout<<"�޴˹���"<<endl;
	}
}