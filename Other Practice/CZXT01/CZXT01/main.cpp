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
			cout << endl << "ע�⣺�������5������" << endl;
			cout << "ѡ���㷨�� 1 �����������㷨   2 ѭ����ת�����㷨   0 �˳� " << endl;
			cin >> sel;
			try{
				if (sel == 1)
				{
					//�����������㷨
					hpf();
				}
				if (sel == 2)
				{
					//ѭ����ת����
					tsr();
				}
			}
			catch (exception e)
			{
				cout << "�������" << endl;
				return;
			}
		}
	}
	catch (exception e)
	{
		cout << "�������" << endl;
		return;
	}
}