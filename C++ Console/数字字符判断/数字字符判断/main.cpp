#include<iostream>
using namespace std;
void main()
{
	char a;
	cout<<"����char�ַ�����"<<endl;
	cin>>a;
	if(a>='0'&&a<='9')//ֻ��ʶ������ĵ�һ���ַ�  ������|| ��������һ����ĸA��ת��������Ϊ65 
		cout<<"����"<<endl;//��Ȼ���������ĸ �������������
	else
		cout<<"�ַ�"<<endl;
	char b;
	int i;
	cout<<"�ַ�ת�������ͣ�����һ���ַ�"<<endl;
	cin>>b;
	i=b;
	cout<<i<<endl;
}