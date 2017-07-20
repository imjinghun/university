#include<iostream>
using namespace std;
void main()
{
	char a;
	cout<<"输入char字符类型"<<endl;
	cin>>a;
	if(a>='0'&&a<='9')//只能识别输入的第一个字符  不能用|| 比如输入一个字母A，转换成数字为65 
		cout<<"数字"<<endl;//虽然输入的是字母 但输出的是数字
	else
		cout<<"字符"<<endl;
	char b;
	int i;
	cout<<"字符转换成整型，输入一个字符"<<endl;
	cin>>b;
	i=b;
	cout<<i<<endl;
}