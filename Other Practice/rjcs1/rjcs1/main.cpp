#include<iostream>
#include<string>
#include<stdlib.h>
using namespace std;
void CaculateWeekDay(int y, int m, int d)
{
	if (m == 1 || m == 2) {
		m += 12;
		y--;
	}
	int iWeek = (d + 2 * m + 3 * (m + 1) / 5 + y + y / 4 - y / 100 + y / 400) % 7;
	switch (iWeek)
	{
	case 0: cout << "����һ" << endl; break;
	case 1: cout << "���ڶ�" << endl; break;
	case 2: cout << "������" << endl; break;
	case 3: cout << "������" << endl; break;
	case 4: cout << "������" << endl; break;
	case 5: cout << "������" << endl; break;
	case 6: cout << "������" << endl; break;
	}
}
bool IsDigit2(string str)
{
	for (int i = 0; i<str.size(); i++)
	{
		if ((str.at(i)>'9') || (str.at(i)<'0'))
		{
			return   false;
		}
	}
	return   true;
}
int main()
{
	string year, month, day;
	cout << "���������" << endl;
	cin >> year;
	cout << "�������·�" << endl;
	cin >> month;
	cout << "����������" << endl;
	cin >> day;
	while (!IsDigit2(year))
	{
		cout << "���ӦΪ����" << endl;
		cout << "���������" << endl;
		cin >> year;
	}
	while (!IsDigit2(month))
	{
		cout << "�·�ӦΪ����" << endl;
		cout << "�������·�" << endl;
		cin >> month;
	}
	while (!IsDigit2(day))
	{
		cout << "����ӦΪ����" << endl;
		cout << "����������" << endl;
		cin >> day;
	}
	int y = atoi(year.c_str());
	int m = atoi(month.c_str());
	int d = atoi(day.c_str());
	while (y<1990||y>2200)
	{
		cout << "���Ӧ��1990-2200֮��" << endl;
		cin >> year;
		while (!IsDigit2(year))
		{
			cout << "���ӦΪ����" << endl;
			cout << "���������" << endl;
			cin >> year;
		}
		y = atoi(year.c_str());
	}
	while (m>12||m<0)
	{
		cout << "�·�ӦΪ1-12" << endl;
		cin >> month;
		while (!IsDigit2(month))
		{
			cout << "�·�ӦΪ����" << endl;
			cout << "�������·�" << endl;
			cin >> month;
		}
		m = atoi(month.c_str());
	}
	if (m == 1 || m == 3 || m == 7 || m == 8 || m == 10 || m == 12)
	{
		while (d<0||d>31)
		{
			cout << "����ӦΪ1-31" << endl;
			cin >> day;
			while (!IsDigit2(day))
			{
				cout << "����ӦΪ����" << endl;
				cout << "����������" << endl;
				cin >> day;
			}
			d = atoi(day.c_str());
		}
	}
	else if (m == 4 || m == 6 || m == 9 || m == 11)
	{
		while (d<0 || d>30)
		{
			cout << "����ӦΪ1-30" << endl;
			cin >> day;
			while (!IsDigit2(day))
			{
				cout << "����ӦΪ����" << endl;
				cout << "����������" << endl;
				cin >> day;
			}
			d = atoi(day.c_str());
		}
	}
	else if ( m == 2)
	{
		if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0)
		{
			while (d<0 || d>29)
			{
				cout << "����ӦΪ1-29" << endl;
				cin >> day;
				while (!IsDigit2(day))
				{
					cout << "����ӦΪ����" << endl;
					cout << "����������" << endl;
					cin >> day;
				}
				d = atoi(day.c_str());
			}
		}
		else
		{
			while (d<0 || d>28)
			{
				cout << "����ӦΪ1-28" << endl;
				cin >> day;
				while (!IsDigit2(day))
				{
					cout << "����ӦΪ����" << endl;
					cout << "����������" << endl;
					cin >> day;
				}
				d = atoi(day.c_str());
			}
		}
	}
	
	CaculateWeekDay(y, m, d);
	system("pause");
	return 0;
}
