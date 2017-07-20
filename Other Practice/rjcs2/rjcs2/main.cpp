#include<iostream>
using namespace std;

void main()
{
	float num;
	cout << "请输入消费金额:" <<endl ;
	cin >> num;
	
	while (num!=(int)num||num<1||num>100||!IsDigit2)
	{
		cout << "消费金额应为1-100以内整数，请输入消费金额:" << endl;
		cin >> num;
	}
	int num2 = 0;
	num2 = 100 - num;
	cout << "应找金额为" <<num2<< endl;
	int x1,y1,x2,y2,x3,y3;
	x1 = num2 / 50;
	y1 = num2 % 50;
	x2 = y1 / 10;
	y2 = y1 % 10;
	x3 = y2 / 5;
	y3 = y2 % 5;
	cout << "应找";
	if (x1 == 0) cout << "" ;
	else cout <<x1 << "张50元，" ;
	if (x2 == 0) cout << "";
	else cout << x2 << "张10元，";
	if (x3 == 0) cout << "";
	else cout << x3 << "张5元，";
	if (y3 == 0) cout << "。";
	else cout <<  y3 << "张1元。";
	
}