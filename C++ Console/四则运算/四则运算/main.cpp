#include<iostream>
#include<string>
#include<stack>
using namespace std;

bool isoperator(char ch)//�ж��Ƿ��������
{
	switch(ch)
	{
	case '+':
	case '-':
	case '*':
	case '/':
		return true;
	default:
		return false;
	}
}
int priority(char ch) //ȷ�����ȼ�
{
	switch(ch)
	{
	case '(':
		return 0;
	case '+':
	case '-':
		return 1;
	case '*':
	case '/':
		return 2;
	default:
		return -1;
	}
}
void infix_to_postfix(char infix[],char postfix[])//��׺ת��׺
{
	stack<char> s1;//�����ַ�ջ
	s1.push('#');// '#'��ջ�����ʽ��ʼ
	int i=0,j=0;
	while(infix[i]!='\0')
	{
		if(infix[i]>='0'&&infix[i]<='9')//��������ִ���postfix�ַ�����
		{
			postfix[j++]=infix[i];
		}
		else if(infix[i]=='(')//����ǡ�(�������ջ
		{
			s1.push(infix[i]);
		}
		else if(infix[i]==')')//����ǡ�)��
		{
			while(s1.top()!='(')//���ջ��!=��(��
			{
				postfix[j++]=' ';//postfix�ַ���������һ�����ַ�
				postfix[j++]=s1.top();//��ջ�������������postfix�ַ�����
				s1.pop();//ջ����ջ
			}
			s1.pop();//ջ��Ϊ��(��ʱ����ջ
		}
		else if(isoperator(infix[i]))//����������
		{
			postfix[j++]=' ';
			if(infix[i]=='-')
			{
				if(i==0)
				{
					postfix[j++]=infix[i];
				}
				else if(isoperator(infix[i-1]) || infix[i-1]=='(')//��� - ���������������ǣ�
				{
					postfix[j++]=infix[i];
				}
				else
				{
					if(s1.empty())//ջ������ջ
					{
						s1.push(infix[i]);
					}
					else
					{
						while(priority(infix[i])<=priority(s1.top()))//infix[i]���ȼ�<=ջ����������ȼ�ʱ
						{
							postfix[j++]=s1.top();
							postfix[j++]=' ';
							s1.pop();
						}
						s1.push(infix[i]);//�������ջ
					}
				}
			}
			else
			{
				if(s1.empty())//ջ������ջ
				{
					s1.push(infix[i]);
				}
				else
				{
					while(priority(infix[i])<=priority(s1.top()))//infix[i]���ȼ�<=ջ����������ȼ�ʱ
					{
						postfix[j++]=s1.top();
						postfix[j++]=' ';
						s1.pop();
					}
					s1.push(infix[i]);//�������ջ
				}
			}
		}
		i++;
	}
	while(s1.size())//��ջ�ĳ��Ȳ�Ϊ0ʱ
	{
		postfix[j++]=' ';
		postfix[j++]=s1.top();
		s1.pop();
	}
	postfix[j-1]='\0';//���������
}
int getpostfix_value(char postfix[])//��ֵ
{
	stack<int> s1;//��������ջ
	int i=0,result=0;
	int x1=0,x2=0;
	while(postfix[i]!='\0')
	{
		if(postfix[i]=='-' && (postfix[i+1]>='0'&&postfix[i+1]<='9'))// - �����ֽ�����
		{
			int x=0;
			i++;
			while(postfix[i]>='0'&&postfix[i]<='9')
			{
				x=x*10+(postfix[i]-'0');
				i++;
			}
			x=-x;
			s1.push(x);//����������ջ
		}
		else if(postfix[i]>='0'&&postfix[i]<='9')
		{
			int x=0;
			while(postfix[i]>='0'&&postfix[i]<='9')
			{
				x=x*10+(postfix[i]-'0');
				i++;
			}
			s1.push(x);//����������ջ
		}
		else if(postfix[i]==' ')
		{
			i++;
		}
		else if(postfix[i]=='+')
		{
			x1=s1.top();
			s1.pop();
			x2=s1.top();
			s1.pop();
			int temp=x2+x1;
			s1.push(temp);
			i++;
		}
		else if(postfix[i]=='-')
		{
			x1=s1.top();
			s1.pop();
			x2=s1.top();
			s1.pop();
			int temp=x2-x1;
			s1.push(temp);
			i++;
		}
		else if(postfix[i]=='*')
		{
			x1=s1.top();
			s1.pop();
			x2=s1.top();
			s1.pop();
			int temp=x2*x1;
			s1.push(temp);
			i++;
		}
		else if(postfix[i]=='/')
		{
			x1=s1.top();
			s1.pop();
			x2=s1.top();
			s1.pop();
			if(x1==0)
			{
				cout<<"�г���Ϊ0���������㣬������ʾ�Ľ��Ϊ������"<<endl;
				return 0;
			}
			int temp=x2/x1;
			s1.push(temp);
			i++;
		}
	}
	result=s1.top();
	return result;
}

void main(){
	string exp;
	cout<<"����������ʽ"<<endl;
	cin>>exp;
	char infix[1024];
	strcpy(infix,exp.c_str());//�ַ���ת��Ϊ�ַ�����

	char postfix[1024];
	infix_to_postfix(infix,postfix);

	cout<<"��׺���ʽ "<<postfix<<endl;

	int result=getpostfix_value(postfix);
	cout<<"������ "<<result<<endl;
}