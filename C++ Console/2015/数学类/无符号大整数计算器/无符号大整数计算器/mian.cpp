#include"sizeyunsuan.h"
void main()
{
	sizeyunsuan e;
	string c,d;
	cout<<"����������"<<endl;
	cin>>c>>d;
	int i;
	while(1)
	{
		int ii1=0,ii2=0;
		for(i=0;i<c.length();i++)
		{
			string ss(c,i,1);
			if(ss>="0"&&ss<="9")
				ii1++;
		}
		if(ii1==c.length())
				break;
		else
		{
			cout<<"��һ���������Ϲ������������һ����"<<endl;
			cin>>c;
		}
	}
	while(1)
	{
		int ii2=0;
		for(i=0;i<d.length();i++)
		{
			string ss(d,i,1);
			if(ss>="0"&&ss<="9")
				ii2++;
		}
		if(ii2==d.length())
				break;
		else
		{
			cout<<"�ڶ����������Ϲ�����������ڶ�����"<<endl;
			cin>>d;
		}
	}
		
	e.addition(c,d);
	cout<<"�������"<<endl;
	e.subtraction(c,d);
}