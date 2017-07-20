#pragma once
#include "SStack.h"
#include <iostream>
#include <string>

using namespace std;

class Functor
{
private:
	char ** table;
	string ** production;
	string prog;//待分析字符串
	int p;//字符指针
	int num;//终结符个数
	int num1;//产生式个数
	SStack <char> stack;
public:

	Functor(int m, int n, char **T, string **prod, string pr)
	{
		num = m;
		num1 = n;
		table = T;
		production = prod;
		prog = pr;
		p = 0;
		stack.push('#');
	}

	void traversal()
	{
		while (p<(prog.length()))
		{
			stack.display();
			cout << prog.substr(p) << " ";
			char ch;
			if (Getnum(stack.gettop()))
			{
				ch = stack.gettop();
			}
			else
			{
				ch = stack.getsecond();
			}
			switch (compare(ch, prog[p]))
			{
			case 1:
			case 2:stack.push(prog[p]); p++; cout << "移入" << endl; break;
			case 3:reduct(); cout << "归约" << endl; break;
			}

		}
		cout << "分析成功！" << endl;
	}

	int Getnum(char ch)
	{
		for (int i = 1; i<num; i++)
		{
			if (ch == table[i][0])
			{
				return i;
			}
		}
		return 0;
	}

	int compare(char col, char row)
	{
		int c = Getnum(col);
		int r = Getnum(row);
		switch (table[c][r])
		{
		case '>': return 3; break;
		case '<': return 2; break;
		case '=': return 1; break;
		default:cout << endl << "输入串有误，程序将终止！" << endl; system("pause"); exit(0); break;
		}
	}

	void reduct()
	{
		//待定
		string token = "";
		int temp;
		string str = "";
		if (!Getnum(stack.gettop()))
		{
			token += stack.gettop();
			stack.pop();
		}
		char ch = stack.gettop();
		str += ch;
		temp = Haven(str);
		if (temp != -1)
		{
			token += production[temp][0];
		}
		else
		{
			token += ch;
		}
		stack.pop();
		bool Nover = true;
		while (Nover)
		{
			if (Getnum(stack.gettop()))
			{
				if (compare(stack.gettop(), ch) == 2)
				{
					Nover = false;
				}
				else
				{
					ch = stack.gettop();
					str = "";
					str += ch;
					temp = Haven(str);
					if (temp != -1)
					{
						token += production[temp][0];
					}
					else
					{
						token += ch;
					}
					stack.pop();
				}
			}
			else
			{
				token += stack.gettop();
				stack.pop();
			}
		}

		string token2 = "";
		//cout<<token<<" ";
		for (int i = token.length() - 1; i >= 0; i--)
		{
			token2 += token[i];
		}
		//cout<<token2<<endl;
		if (Haven(token2) != -1)
		{
			stack.push(production[Haven(token2)][0][0]);
		}
		else
		{
			cout << "输入串有误！分析终止！" << endl;
			system("pause");
			exit(0);
		}
	}

	int Haven(string temp)
	{
		for (int i = 0; i<num1; i++)
		{
			int j = 1;
			while (production[i][j] != "")
			{
				if (temp == production[i][j])
				{
					return i;
				}
				j++;
			}
		}
		return -1;
	}
public:

	~Functor(void)
	{
	}
};
