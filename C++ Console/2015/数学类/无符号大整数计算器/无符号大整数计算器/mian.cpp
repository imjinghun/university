#include"sizeyunsuan.h"
void main()
{
	sizeyunsuan e;
	string c,d;
	cout<<"输入两个数"<<endl;
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
			cout<<"第一个数不符合规则，重新输入第一个数"<<endl;
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
			cout<<"第二个数不符合规则，重新输入第二个数"<<endl;
			cin>>d;
		}
	}
		
	e.addition(c,d);
	cout<<"减法结果"<<endl;
	e.subtraction(c,d);
}