#include<iostream>
using namespace std;
void main()
{
	int i,j;
	for(i=1;i<=10000;i++)
	{
		int a=0,s=0;
		for(j=1;j<i;j++)
			if(i%j==0)
				a=a+j;
		for(j=1;j<a;j++)
			if(a%j==0)
				s+=j;
		if(s==i)
			cout<<i<<"和"<<a<<" 是相亲数"<<endl;
	}
}