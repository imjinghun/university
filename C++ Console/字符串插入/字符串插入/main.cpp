#include<iostream>
#include<string>
using namespace std;
void main()
{
	string s,t;
	int i,j;
	cout<<"输入两个字符串，及第二个字符串所要插入到第一个字符串的位置"<<endl;
	cin>>s>>t>>i;
	j=s.length();
	while(1)
	{
		if(i>j)
		{	cout<<"所插入的位置超过字符串长度，请重新输入所要插入的位置"<<endl;
			cin>>i;
		}
		else
			break;
	}
	cout<<"插入后的字符串"<<endl;
	cout<<s.insert(i,t,0,t.length())<<endl;

	string s1="somestring";//一个空格算一个字节（即字节）
	string s2="some other string";
	s1.insert(6,s2,0,4);//表示从s1的第6位开始将s2的从0开始4个字符长度的字符串插到其中
	cout<<s1<<endl;
}
