#include<iostream>
#include<iomanip>
using namespace std;

char StateStack[6]; //状态栈  
int SSPointer;
char CharStack[6];  //符号栈	
int CSPointer;
char Input[10];  //输入串 
int InPointer;
char *M[][9] = {  //00的ascII码是48  9的是89  :(10)的是90  ;(11)的是91 
	"S5", "", "", "S4", "", "", "1", "2", "3",
	"", "S6", "", "", "", "acc", "", "", "",
	"", "r2", "S7", "", "r2", "r2", "", "", "",
	"", "r4", "r4", "", "r4", "r4", "", "", "",
	"S5", "", "", "S4", "", "", "8", "2", "3",
	"", "r6", "r6", "", "r6", "r6", "", "", "",
	"S5", "", "", "S4", "", "", "", "9", "3",
	"S5", "", "", "S4", "", "", "", "", ":",
	"", "S6", "", "", "S;", "", "", "", "",
	"", "r1", "S7", "", "r1", "r1", "", "", "",
	"", "r3", "r3", "", "r3", "r3", "", "", "",
	"", "r5", "r5", "", "r5", "r5", "", "", "",
};

int Lie(char c)
{
	switch (c)
	{
	case 'i':return 0; break;
	case '+':return 1; break;
	case '*':return 2; break;
	case '(':return 3; break;
	case ')':return 4; break;
	case '#':return 5; break;
	case 'E':return 6; break;
	case 'T':return 7; break;
	case 'F':return 8;
	}
	return 0;
}

void main()
{
	int stage = 1, i, a, b, p, q;
	char GoTo;
	cout << "输入一以#结束的符号串(包括+—*/（）i#)：" << endl;
	gets_s(Input);

	cout << setiosflags(ios::left) << setw(4) << "步骤" << " "
		<< setw(6) << "状态栈" << " "
		<< setw(6) << "符号栈" << " "
		<< resetiosflags(ios::left) << setw(6) << "剩余输入串" << " "
		<< setiosflags(ios::left) << setw(6) << "Action" << " "
		<< setw(4) << "GOTO" << endl;

	SSPointer = 0;
	CSPointer = 0;
	InPointer = 0;
	for (i = 0; i<6; i++)
		StateStack[i] = '\0';
	for (i = 0; i<6; i++)
		CharStack[i] = '\0';
	StateStack[SSPointer++] = '0';
	CharStack[CSPointer++] = '#';

	while (1)
	{
		p = SSPointer - 1;
		q = CSPointer - 1;
		cout << setiosflags(ios::left) << setw(4) << stage++ << " "
			<< setw(6) << StateStack << " "
			<< setw(6) << CharStack << " "
			<< resetiosflags(ios::left) << setw(6) << Input + InPointer << " ";
		a = StateStack[p] - 48;
		b = Lie(Input[InPointer]);
		if (M[a][b][0] == 'S')
		{
			StateStack[SSPointer++] = M[a][b][1];
			CharStack[CSPointer++] = Input[InPointer++];
			cout << setiosflags(ios::left) << setw(6) <<"     "<<M[a][b] << " "
				<< setw(4) << " " << endl;
		}
		else if (M[a][b][0] == 'r')
		{
			switch (M[a][b][1] - 48)
			{
			case 0:{ //S'-->E
					   CharStack[--CSPointer] = 's';
					   CSPointer++;
					   SSPointer = SSPointer - 2;
					   GoTo = M[StateStack[SSPointer++] - 48][Lie('s')][0];
					   StateStack[SSPointer++] = GoTo;
					   cout << setiosflags(ios::left) << setw(6) << "      r0" << " "
						   << setw(4) << "     " << GoTo << endl;
					   break;
			};
			case 1:{  //E-->E+T
					   CSPointer = CSPointer - 3;
					   CharStack[CSPointer++] = 'E';
					   CharStack[CSPointer] = '\0';
					   SSPointer = SSPointer - 4;
					   GoTo = M[StateStack[SSPointer++] - 48][Lie('E')][0];
					   StateStack[SSPointer++] = GoTo;
					   cout << setiosflags(ios::left) << setw(6) << "      r1" << " "
						   << setw(4) << "     " << GoTo << endl;
					   break;
			};
			case 2:{	//E-->T
					   CharStack[--CSPointer] = 'E';
					   CSPointer++;
					   SSPointer = SSPointer - 2;
					   GoTo = M[StateStack[SSPointer++] - 48][Lie('E')][0];
					   StateStack[SSPointer++] = GoTo;
					   cout << setiosflags(ios::left) << setw(6) << "      r2" << " "
						   << setw(4) << "     " << GoTo << endl;
					   break;
			};
			case 3:{	//T-->T*F
					   CSPointer = CSPointer - 3;
					   CharStack[CSPointer++] = 'T';
					   CharStack[CSPointer] = '\0';
					   SSPointer = SSPointer - 4;
					   GoTo = M[StateStack[SSPointer++] - 48][Lie('T')][0];
					   StateStack[SSPointer++] = GoTo;
					   cout << setiosflags(ios::left) << setw(6) << "      r3" << " "
						   << setw(4) << "     " << GoTo << endl;
					   break;
			};
			case 4:{	//T-->F
					   CharStack[--CSPointer] = 'T';
					   CSPointer++;
					   SSPointer = SSPointer - 2;
					   GoTo = M[StateStack[SSPointer++] - 48][Lie('T')][0];
					   StateStack[SSPointer++] = GoTo;
					   cout << setiosflags(ios::left) << setw(6) << "      r4" << " "
						   << setw(4) << "     " << GoTo << endl;
					   break;
			};
			case 5:{	//F-->(E)
					   CSPointer = CSPointer - 3;
					   CharStack[CSPointer++] = 'F';
					   CharStack[CSPointer] = '\0';
					   SSPointer = SSPointer - 4;
					   GoTo = M[StateStack[SSPointer++] - 48][Lie('F')][0];
					   StateStack[SSPointer++] = GoTo;
					   cout << setiosflags(ios::left) << setw(6) << "      r5" << " "
						   << setw(4) << "     " << GoTo << endl;
					   break;
			};
			case 6:{	//F-->i
					   CharStack[--CSPointer] = 'F';
					   CSPointer++;
					   SSPointer = SSPointer - 2;
					   GoTo = M[StateStack[SSPointer++] - 48][Lie('F')][0];
					   StateStack[SSPointer++] = GoTo;
					   cout << setiosflags(ios::left) << setw(6) << "      r6" << " "
						   << setw(4) << "     " << GoTo << endl;
					   break;
			};
			}
		}
		else //等于acc
		{
			cout << setiosflags(ios::left) << setw(6) << "      acc" << " "
				<< setw(4) << " " << endl;
			break;
		}
	}
	cout << "注意“;”代表数字“10”" << endl;
}