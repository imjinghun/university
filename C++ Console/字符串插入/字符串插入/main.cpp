#include<iostream>
#include<string>
using namespace std;
void main()
{
	string s,t;
	int i,j;
	cout<<"���������ַ��������ڶ����ַ�����Ҫ���뵽��һ���ַ�����λ��"<<endl;
	cin>>s>>t>>i;
	j=s.length();
	while(1)
	{
		if(i>j)
		{	cout<<"�������λ�ó����ַ������ȣ�������������Ҫ�����λ��"<<endl;
			cin>>i;
		}
		else
			break;
	}
	cout<<"�������ַ���"<<endl;
	cout<<s.insert(i,t,0,t.length())<<endl;

	string s1="somestring";//һ���ո���һ���ֽڣ����ֽڣ�
	string s2="some other string";
	s1.insert(6,s2,0,4);//��ʾ��s1�ĵ�6λ��ʼ��s2�Ĵ�0��ʼ4���ַ����ȵ��ַ����嵽����
	cout<<s1<<endl;
}
