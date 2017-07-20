#include<iostream>
#include<string>
#include<stack>
using namespace std;

bool isoperator(char ch)//判断是否是运算符
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
int priority(char ch) //确定优先级
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
void infix_to_postfix(char infix[],char postfix[])//中缀转后缀
{
	stack<char> s1;//定义字符栈
	s1.push('#');// '#'入栈，表达式开始
	int i=0,j=0;
	while(infix[i]!='\0')
	{
		if(infix[i]>='0'&&infix[i]<='9')//如果是数字存入postfix字符数组
		{
			postfix[j++]=infix[i];
		}
		else if(infix[i]=='(')//如果是“(”，则进栈
		{
			s1.push(infix[i]);
		}
		else if(infix[i]==')')//如果是“)”
		{
			while(s1.top()!='(')//如果栈顶!=“(”
			{
				postfix[j++]=' ';//postfix字符数组增加一个空字符
				postfix[j++]=s1.top();//将栈顶的运算符加入postfix字符数组
				s1.pop();//栈顶出栈
			}
			s1.pop();//栈顶为“(”时，出栈
		}
		else if(isoperator(infix[i]))//如果是运算符
		{
			postfix[j++]=' ';
			if(infix[i]=='-')
			{
				if(i==0)
				{
					postfix[j++]=infix[i];
				}
				else if(isoperator(infix[i-1]) || infix[i-1]=='(')//如果 - 左侧是运算符或者是（
				{
					postfix[j++]=infix[i];
				}
				else
				{
					if(s1.empty())//栈空则入栈
					{
						s1.push(infix[i]);
					}
					else
					{
						while(priority(infix[i])<=priority(s1.top()))//infix[i]优先级<=栈顶运算符优先级时
						{
							postfix[j++]=s1.top();
							postfix[j++]=' ';
							s1.pop();
						}
						s1.push(infix[i]);//运算符入栈
					}
				}
			}
			else
			{
				if(s1.empty())//栈空则入栈
				{
					s1.push(infix[i]);
				}
				else
				{
					while(priority(infix[i])<=priority(s1.top()))//infix[i]优先级<=栈顶运算符优先级时
					{
						postfix[j++]=s1.top();
						postfix[j++]=' ';
						s1.pop();
					}
					s1.push(infix[i]);//运算符入栈
				}
			}
		}
		i++;
	}
	while(s1.size())//当栈的长度不为0时
	{
		postfix[j++]=' ';
		postfix[j++]=s1.top();
		s1.pop();
	}
	postfix[j-1]='\0';//存入结束符
}
int getpostfix_value(char postfix[])//求值
{
	stack<int> s1;//定义整型栈
	int i=0,result=0;
	int x1=0,x2=0;
	while(postfix[i]!='\0')
	{
		if(postfix[i]=='-' && (postfix[i+1]>='0'&&postfix[i+1]<='9'))// - 和数字紧挨着
		{
			int x=0;
			i++;
			while(postfix[i]>='0'&&postfix[i]<='9')
			{
				x=x*10+(postfix[i]-'0');
				i++;
			}
			x=-x;
			s1.push(x);//将运算结果入栈
		}
		else if(postfix[i]>='0'&&postfix[i]<='9')
		{
			int x=0;
			while(postfix[i]>='0'&&postfix[i]<='9')
			{
				x=x*10+(postfix[i]-'0');
				i++;
			}
			s1.push(x);//将运算结果入栈
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
				cout<<"有除数为0，不可运算，下面显示的结果为错误结果"<<endl;
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
	cout<<"输入四则表达式"<<endl;
	cin>>exp;
	char infix[1024];
	strcpy(infix,exp.c_str());//字符串转换为字符数组

	char postfix[1024];
	infix_to_postfix(infix,postfix);

	cout<<"后缀表达式 "<<postfix<<endl;

	int result=getpostfix_value(postfix);
	cout<<"运算结果 "<<result<<endl;
}