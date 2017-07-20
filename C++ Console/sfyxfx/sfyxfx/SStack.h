#pragma once
#include <iostream>
using namespace std;
template <typename T>
class SStack
{
private:
	T * base;
	T * top;
	int Size;
public:
	SStack(void)
	{
		base = new T[50];
		top = base;
		Size = 20;
		//stacksize=10;
	}
	SStack(int m)
	{
		base = new T[m];
		top = base;
		Size = m;
	}
	void SET(int m)
	{
		delete[]base;
		base = new T[m];
		top = base;
		Size = m;
	}
	int  push(T n)
	{
		if (top - base >= Size)
		{
			return -1;
		}
		else
		{
			*top++ = n;
			return 1;
		}
	}
	T gettop()
	{
		if (top == base)
		{
			cout << "对不起，栈已空！" << endl;
			return -1;
		}
		else
		{
			return *(top - 1);
		}
	}

	T getsecond()
	{
		if (top - 1 == base)
		{
			return NULL;
		}
		else
		{
			return *(top - 2);
		}
	}
	void pop()
	{
		if (top == base)
		{
			cout << "对不起，栈已空！" << endl;
		}
		else
		{
			top--;
			//cout<<"弹出成功！"<<endl;
		}
	}
	void display()
	{
		if (top == base)
		{
			cout << "栈已空！" << endl;
		}
		else
		{
			/*T * temp=top-1;
			int num=0;
			while(temp!=base)
			{
			num++;
			cout<<*temp--<<"   ";
			if(num%10==0)
			cout<<endl;
			}
			cout<<*temp<<endl;*/

			T*temp = base;
			int num = 0;
			while (temp != top)
			{
				num++;
				cout << *temp++;
			}
			cout << "  ";
		}
	}
public:
	~SStack(void)
	{
		delete[]base;
	}
};
