#include<iostream>
using namespace std;
//ab*ba=1855 �� a bֵ
void main()
{
	cout<<"ab*ba=1855 �� a bֵ"<<endl;
	cout<<"a bֵΪ"<<endl;
	int i,j,b[2],c[2];
	for(i=10;i<100;i++)
		for(j=i;j<100;j++)
			if(i*j==1855)
			{
				b[0]=i%10;		//��λ
				b[1]=(i/10)%10; //ʮλ
				c[0]=j%10;		//��λ
				c[1]=(j/10)%10; //ʮλ
				if(b[0]==c[1]&&b[1]==c[0])
					cout<<b[1]<<" "<<b[0]<<endl;
			}
}