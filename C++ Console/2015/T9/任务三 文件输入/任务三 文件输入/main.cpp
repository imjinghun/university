//文件输入 王占京 2015 4 16
#include<iostream>
#include<fstream>
using namespace std;
void main()
{
	ifstream infile("D:\\cube.off");
	int i,b[25],a=0;
	for(i=0;i<25;i++)
	{
		infile>>b[i];
	}
	cout<<b[0]<<endl;
	for(i=1;i<25;i++)
	{
		if((i-1)%3==0)
			cout<<"(";
		cout<<b[i];
		if(i%3!=0)
			cout<<",";
		a++;
		if(a%3==0)
			cout<<")"<<endl;
	}

}