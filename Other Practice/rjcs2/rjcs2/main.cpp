#include<iostream>
using namespace std;

void main()
{
	float num;
	cout << "���������ѽ��:" <<endl ;
	cin >> num;
	
	while (num!=(int)num||num<1||num>100||!IsDigit2)
	{
		cout << "���ѽ��ӦΪ1-100�������������������ѽ��:" << endl;
		cin >> num;
	}
	int num2 = 0;
	num2 = 100 - num;
	cout << "Ӧ�ҽ��Ϊ" <<num2<< endl;
	int x1,y1,x2,y2,x3,y3;
	x1 = num2 / 50;
	y1 = num2 % 50;
	x2 = y1 / 10;
	y2 = y1 % 10;
	x3 = y2 / 5;
	y3 = y2 % 5;
	cout << "Ӧ��";
	if (x1 == 0) cout << "" ;
	else cout <<x1 << "��50Ԫ��" ;
	if (x2 == 0) cout << "";
	else cout << x2 << "��10Ԫ��";
	if (x3 == 0) cout << "";
	else cout << x3 << "��5Ԫ��";
	if (y3 == 0) cout << "��";
	else cout <<  y3 << "��1Ԫ��";
	
}