#include<iostream>
using namespace std;
void main()
{
	int m=0;
	while(1)
	{
		m++;
		if(m%2==0 && m%3==0 && m%5==0 && m%6==0 && m%7==1)
		{
			cout<<m-1<<endl;
			break;
		}	
	}
}