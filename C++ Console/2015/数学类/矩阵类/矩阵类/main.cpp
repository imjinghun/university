#include"juzhen.h"
void main()
{
	juzhen jz0,jz1,jz2,jz3,jz4;;
	int r0,c0,r1,c1;
	cout<<"�����һ������������"<<endl;
	cin>>r0>>c0;
	
	jz0.gethl(r0,c0);
	jz0.shenqing();
	jz0.input();
	
	cout<<"����ڶ�������������"<<endl;
	cin>>r1>>c1;
	jz1.gethl(r1,c1);
	jz1.shenqing();
	jz1.input();
	
	if(r0==r1&&c0==c1)
	{
		cout<<"�ӷ����Ϊ"<<endl;
		jz2=jz0+jz1;
		jz2.output(jz2);
		cout<<endl;

		cout<<"�������Ϊ"<<endl;
		jz3=jz0-jz1;
		jz3.output(jz3);
		cout<<endl;
	}
	else
		cout<<"����������������һһ��Ӧ��������Ӽ���"<<endl;
	cout<<endl;

	if(r0==c1)
	{
		cout<<"�˷����Ϊ"<<endl;
		jz4=jz0*jz1;
		jz4.output(jz4);
		cout<<endl;
	}
	else
		cout<<"��һ���������������ڵڶ�������������������˷�"<<endl;
	cout<<endl;

	cout<<"����ļ�����Ϊ"<<endl;
	cout<<endl;
	jz0.ji(r0,c0,jz0);
	jz1.ji(r1,c1,jz1);
	cout<<endl;

	cout<<"����ʽֵ����Ϊ"<<endl;
	cout<<endl;
	double zh[2];
	int i;
	bool flag[2];
	for(i=0;i<2;i++)
	{
		flag[0]=jz0.det1(jz0);
		zh[0]=jz0.det(jz0);

		flag[1]=jz1.det1(jz1);
		zh[1]=jz1.det(jz1);

		if(flag[i]==true)
			cout<<"�þ����Ƿ��󣬲���������ʽ���ʲ����档"<<endl;
		else
		{
			if(zh[i]==0)
				cout<<"����ʽֵΪ "<<zh[i]<<" ���󲻿���"<<endl;
			else
				cout<<"����ʽֵΪ "<<zh[i]<<" �������"<<endl;
		}
	}

}