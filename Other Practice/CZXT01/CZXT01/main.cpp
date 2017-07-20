#include"common.h"
#include<iostream>
int hpf();
int tsr();
void main()
{
	int sel=3;
	try{
		while (sel != 0)
		{
			cout << endl << "注意：最多输入5个进程" << endl;
			cout << "选择算法： 1 优先数调度算法   2 循环轮转调度算法   0 退出 " << endl;
			cin >> sel;
			try{
				if (sel == 1)
				{
					//优先数调度算法
					hpf();
				}
				if (sel == 2)
				{
					//循环轮转调度
					tsr();
				}
			}
			catch (exception e)
			{
				cout << "输入错误" << endl;
				return;
			}
		}
	}
	catch (exception e)
	{
		cout << "输入错误" << endl;
		return;
	}
}