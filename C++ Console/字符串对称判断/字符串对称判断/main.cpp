#include<iostream>
#include<string>
using namespace std;
bool duic(string a)
{
	string b;
	bool f;
	int d,i;
	d=a.length();
	if(d%2==0)
	{
		string c(a,0,d/2);
		for(i=d-1;i>=d/2;i--)
		{
			string e(a,i,1);
			b=b+e;
		}
		if(c==b)
			f=true;
		else
			f=false;
	}
	if(d%2!=0)
	{
		string c(a,0,d/2);
		for(i=d-1;i>d/2;i--)
		{
			string e(a,i,1);
			b=b+e;
		}
		if(c==b)
			f=true;
		else
			f=false;
	}
	return f;
}
void main()
{
	string a;
	cout<<"输入一个字符串"<<endl;
	cin>>a;
	bool f;
	f=duic(a);
	if(f==true)
		cout<<"对称"<<endl;
	else
		cout<<"不对称"<<endl;
}