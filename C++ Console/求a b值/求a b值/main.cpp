#include<iostream>
using namespace std;
//ab*ba=1855 求 a b值
void main()
{
	cout<<"ab*ba=1855 求 a b值"<<endl;
	cout<<"a b值为"<<endl;
	int i,j,b[2],c[2];
	for(i=10;i<100;i++)
		for(j=i;j<100;j++)
			if(i*j==1855)
			{
				b[0]=i%10;		//个位
				b[1]=(i/10)%10; //十位
				c[0]=j%10;		//个位
				c[1]=(j/10)%10; //十位
				if(b[0]==c[1]&&b[1]==c[0])
					cout<<b[1]<<" "<<b[0]<<endl;
			}
}