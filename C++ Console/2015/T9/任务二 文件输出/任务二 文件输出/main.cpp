//文件输出 王占京 2015 4 15
#include<iostream>
#include<fstream>
using namespace std;
void main()
{
	ofstream fileout("d:\\Prime.txt");
	int i,j;

	for(i=1;i<=1000;i++)
	{
		int a=0;
		for(j=1;j<=i;j++)
			if(i%j==0)
				a++;
		if(a<=2)
			fileout<<i<<endl;
	}
	fileout.close();
}