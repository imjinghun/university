#include<iostream>
using namespace std;
#define n 3
void main()
{
	double i, a=0;
	//int i;
	//double d=1;        或者把//和 double中的i去掉  把循环{}中的i变为d
	for(i=1;i<n+1;i=i+2)
	{   //d++;
		a=a+(1/(i*(i+1)));
	}
	cout<<a<<endl;
}