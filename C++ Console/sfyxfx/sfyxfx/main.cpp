#include<iostream>
#include<string>
#include<algorithm>
#include"functor.h"
using namespace std;
//要分析的文法
string E[8] = { "E->E+T", "E->T", "T->T*F", "T->F", "F->P!F", "F->P", "P->(E)", "P->i" };
char upper[4] = { 'E', 'T', 'F', 'P' };
char lower[6] = { '+', '*', '!', '(', ')', 'i' };
class CreateFirstvt               //构造FIRSTVT的类
{
public:
	CreateFirstvt();
	~CreateFirstvt()
	{}
	void insert(char T, char n);
	bool SignArray[20][20];
	void CreateFIRSTVT();    //构造FIRSTVT的函数
	void PrintFirstvt();
	bool IsT(char);         //判断是否为终结符
	bool IsN(char);         //判断是否为非终结符
private:
	string stack[50];
	int top;
};
CreateFirstvt::CreateFirstvt()
{
	top = 0;
	for (int i = 0; i<20; i++)
	{
		for (int j = 0; j<20; j++)
		{
			SignArray[i][j] = false;
		}
	}
}
void CreateFirstvt::insert(char T, char n)
{
	int j, k;
	for (j = 0; j<4; j++)
	{
		if (T == upper[j])
			break;
	}
	for (k = 0; k<6; k++)
	{
		if (n == lower[k])
			break;
	}
	if (SignArray[j][k] == false)
	{
		SignArray[j][k] = true;
		stack[top] = "(";
		stack[top].append(1, T);
		stack[top] += ",";
		stack[top].append(1, n);
		stack[top] += ")";
		top++;
	}
}
void CreateFirstvt::CreateFIRSTVT()
{
	for (int i = 0; i<8; i++)
	{
		if (IsT(E[i].at(3)))               //处理P->a.....这种情况
		{
			char pos1, pos2;
			pos1 = E[i].at(0);
			pos2 = E[i].at(3);
			insert(pos1, pos2);
		}
		if (IsN(E[i].at(3)) && E[i].length()>4 && IsT(E[i].at(4)))    //处理P->Qa.......这种情况
		{
			char pos1, pos2;
			pos1 = E[i].at(0);
			pos2 = E[i].at(4);
			insert(pos1, pos2);
		}
	}
	while (top != 0)                            //处理P->Q......这种情况
	{
		string PopElement = stack[--top];
		stack[top] = "";
		char pos1, pos2;
		for (int i = 0; i<8; i++)
		{
			if (PopElement.at(1) == E[i].at(3))
			{
				pos1 = E[i].at(0);
				pos2 = PopElement.at(3);
				insert(pos1, pos2);
			}
		}
	}
}
void CreateFirstvt::PrintFirstvt()
{
	cout << endl;
	cout << "每个非终结符的FIRSTVT集为：" << endl;
	cout << "E:";
	for (int i = 0; i<4; i++)
	{
		for (int j = 0; j<6; j++)
		{
			if (SignArray[i][j] == true && upper[i] == 'E')
			{
				cout << lower[j] << " ";
			}
		}
		if (upper[i] == 'E')
			break;
	}
	cout << endl;
	cout << "T:";
	for (int i = 0; i<4; i++)
	{
		for (int j = 0; j<6; j++)
		{
			if (SignArray[i][j] == true && upper[i] == 'T')
			{
				cout << lower[j] << " ";
			}
		}
		if (upper[i] == 'T')                     //如果找到了，就退出本次循环
			break;
	}
	cout << endl;
	cout << "F:";
	for (int i = 0; i<4; i++)
	{
		for (int j = 0; j<6; j++)
		{
			if (SignArray[i][j] == true && upper[i] == 'F')
			{
				cout << lower[j] << " ";
			}
		}
		if (upper[i] == 'F')
			break;
	}
	cout << endl;
	cout << "P:";
	for (int i = 0; i<4; i++)
	{
		for (int j = 0; j<6; j++)
		{
			if (SignArray[i][j] == true && upper[i] == 'P')
			{
				cout << lower[j] << " ";
			}
		}
		if (upper[i] == 'P')
			break;
	}
	cout << endl;
}
bool CreateFirstvt::IsT(char ch)
{
	for (int i = 0; i<6; i++)
	{
		if (ch == lower[i])
		{
			return true;
		}
	}
	return false;
}
bool CreateFirstvt::IsN(char ch)
{
	for (int i = 0; i<4; i++)
	{
		if (ch == upper[i])
		{
			return true;
		}
	}
	return false;
}
class CreateLastvt               //构造LASTVT的类
{
public:
	CreateLastvt();
	~CreateLastvt()
	{}
	void insert(char T, char n);
	bool SignArray[20][20];
	void CreateLASTVT();    //构造LASTVT的函数
	void PrintLastvt();
	bool IsT(char);         //判断是否为终结符
	bool IsN(char);         //判断是否为非终结符
private:
	string stack[50];
	int top;
};
CreateLastvt::CreateLastvt()
{
	top = 0;
	for (int i = 0; i<20; i++)
	{
		for (int j = 0; j<20; j++)
		{
			SignArray[i][j] = false;
		}
	}
}
void CreateLastvt::insert(char T, char n)
{
	int j, k;
	for (j = 0; j<4; j++)
	{
		if (T == upper[j])
			break;
	}
	for (k = 0; k<6; k++)
	{
		if (n == lower[k])
			break;
	}
	if (SignArray[j][k] == false)
	{
		SignArray[j][k] = true;
		stack[top] = "(";
		stack[top].append(1, T);
		stack[top] += ",";
		stack[top].append(1, n);
		stack[top] += ")";
		top++;
	}
}
void CreateLastvt::CreateLASTVT()
{
	for (int i = 0; i<8; i++)
	{
		if (IsT(E[i].at(E[i].length() - 1)) == true)               //处理P->.....a这种情况
		{
			char pos1, pos2;
			pos1 = E[i].at(0);
			pos2 = E[i].at(E[i].length() - 1);
			insert(pos1, pos2);
		}
		if (IsT(E[i].at(E[i].length() - 2)) == true && IsN(E[i].at(E[i].length() - 1)) == true)   //处理P->.......aQ这种情况
		{
			char pos1, pos2;
			pos1 = E[i].at(0);
			pos2 = E[i].at(E[i].length() - 2);
			insert(pos1, pos2);
		}
	}
	while (top != 0)                            //处理P->......Q这种情况
	{
		string PopElement = stack[--top];
		stack[top] = "";
		char pos1, pos2;
		for (int i = 0; i<8; i++)
		{
			if (PopElement.at(1) == E[i].at(E[i].length() - 1))
			{
				pos1 = E[i].at(0);
				pos2 = PopElement.at(3);
				insert(pos1, pos2);
			}
		}
	}
}
void CreateLastvt::PrintLastvt()
{
	cout << "每个非终结符的LASTVT集为:" << endl;
	cout << "E:";
	for (int i = 0; i<4; i++)
	{
		for (int j = 0; j<6; j++)
		{
			if (SignArray[i][j] == true && upper[i] == 'E')
			{
				cout << lower[j] << " ";
			}
		}
		if (upper[i] == 'E')
			break;
	}
	cout << endl;
	cout << "T:";
	for (int i = 0; i<4; i++)
	{
		for (int j = 0; j<6; j++)
		{
			if (SignArray[i][j] == true && upper[i] == 'T')
			{
				cout << lower[j] << " ";
			}
		}
		if (upper[i] == 'T')
			break;
	}
	cout << endl;
	cout << "F:";
	for (int i = 0; i<4; i++)
	{
		for (int j = 0; j<6; j++)
		{
			if (SignArray[i][j] == true && upper[i] == 'F')
			{
				cout << lower[j] << " ";
			}
		}
		if (upper[i] == 'F')
			break;
	}
	cout << endl;
	cout << "P:";
	for (int i = 0; i<4; i++)
	{
		for (int j = 0; j<6; j++)
		{
			if (SignArray[i][j] == true && upper[i] == 'P')
			{
				cout << lower[j] << " ";
			}
		}
		if (upper[i] == 'P')
			break;
	}
	cout << endl;
}
bool CreateLastvt::IsT(char ch)
{
	for (int i = 0; i<6; i++)
	{
		if (ch == lower[i])
		{
			return true;
		}
	}
	return false;
}
bool CreateLastvt::IsN(char ch)
{
	for (int i = 0; i<4; i++)
	{
		if (ch == upper[i])
		{
			return true;
		}
	}
	return false;
}


class CreatePreTable
{
public:
	CreatePreTable();
	~CreatePreTable()
	{}
	void CreatePreCedentTable();
	void PrintPreTable();
	bool IsT(char);
	bool IsN(char);
	int GetLocation(char);

	private:char PreTable[6][6];
};
CreatePreTable::CreatePreTable()
{
	for (int i = 0; i<6; i++)
	for (int j = 0; j<6; j++)
	{
		PreTable[i][j] = ' ';
	}
}
bool CreatePreTable::IsT(char ch)
{
	for (int i = 0; i<6; i++)
	{
		if (ch == lower[i])
			return true;
	}
}
bool CreatePreTable::IsN(char ch)
{
	for (int i = 0; i<4; i++)
	{
		if (ch == upper[i])
			return true;
	}
}
void CreatePreTable::CreatePreCedentTable()
{
	CreateFirstvt firstvt;
	firstvt.CreateFIRSTVT();
	CreateLastvt lastvt;
	lastvt.CreateLASTVT();
	for (int i = 0; i<8; i++)
	for (int j = 1; j<(E[i].length() - 3); j++)
	{
		if (IsT(E[i].at(j + 2)) == true)
		{
			if (IsT(E[i].at(j + 3)) == true)
			{
				PreTable[GetLocation(E[i].at(j + 2))][GetLocation(E[i].at(j + 3))] = '=';
			}
			if (IsN(E[i].at(j + 3)) == true && j <= (E[i].length() - 5) && IsT(E[i].at(j + 4)) == true)
			{
				PreTable[GetLocation(E[i].at(j + 2))][GetLocation(E[i].at(j + 4))] = '=';
			}
			if (IsN(E[i].at(j + 3)) == true)
			{
				int loc = GetLocation(E[i].at(j + 2));
				for (int m = 0; m<4; m++)
				{
					for (int k = 0; k<6; k++)
					{
						if (firstvt.SignArray[m][k] == true && upper[m] == E[i].at(j + 3))
						{
							PreTable[loc][k] = '<';
						}

					}
					if (upper[m] == E[i].at(j + 3))
						break;
				}
			}
		}
		else
		{
			if (IsT(E[i].at(j + 3)) == true)
			{
				int loc = GetLocation(E[i].at(j + 3));
				for (int m = 0; m<4; m++)
				{
					for (int k = 0; k<6; k++)
					{
						if (lastvt.SignArray[m][k] == true && upper[m] == E[i].at(j + 2))
						{
							PreTable[k][loc] = '>';
						}
					}
					if (upper[m] == E[i].at(j + 2))
						break;
				}
			}
		}
	}
}
void CreatePreTable::PrintPreTable()
{
	int j, k;
	cout << "算符优先分析表:" << endl<<endl;
	cout << "  " << "+ * ! ( ) i" << endl;
	cout << "+ ";
	for (j = 0; j<6; j++)
	{
		cout << PreTable[0][j] << " ";
	}
	cout << endl;
	cout << "* ";
	for (j = 0; j<6; j++)
	{
		cout << PreTable[1][j] << " ";
	}
	cout << endl;
	cout << "! ";
	for (j = 0; j<6; j++)
	{
		cout << PreTable[2][j] << " ";
	}
	cout << endl;
	cout << "( ";
	for (j = 0; j<6; j++)
	{
		cout << PreTable[3][j] << " ";
	}
	cout << endl;
	cout << ") ";
	for (j = 0; j<6; j++)
	{
		cout << PreTable[4][j] << " ";
	}
	cout << endl;
	cout << "i ";
	for (j = 0; j<6; j++)
	{
		cout << PreTable[5][j] << " ";
	}
	cout << endl;
}

int CreatePreTable::GetLocation(char ch)
{
	for (int i = 0; i<6; i++)
	{
		if (lower[i] == ch)
		{
			return i;
		}
	}
}



void main()
{
	CreateFirstvt firstvt;
	firstvt.CreateFIRSTVT();
	firstvt.PrintFirstvt();
	CreateLastvt lastvt;
	lastvt.CreateLASTVT();
	lastvt.PrintLastvt();
	CreatePreTable pretable;
	pretable.CreatePreCedentTable();
	pretable.PrintPreTable();

/*	string prog;
	cout << "输入文法符号串，以#结束：" ;
	cin >> prog;
	Functor functor(6, 8, &pretable.PreTable,&E, prog);
	*/
}