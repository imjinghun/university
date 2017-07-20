#include<iostream>
using namespace std;
//四位数，它的9倍恰好是其反序数
void main()
{
	
	int i,j,q,k,l,a[4],b[4],c;
	for(i=1000;i<10000;i++)
	{  
		c=0;
		q=i;
		j=9*q;
		if(j<10000)
		{
			a[0]=j%10;//个位
			for(k=1;k<4;k++)
			{
				j=j/10;
				a[k]=j%10;//依次为十百千位
			}

			b[3]=q%10;
			for(k=2;k>=0;k--)
			{
				q=q/10;
				b[k]=q%10;//依次为十百千位
			}
			
			for(l=0;l<4;l++)
				if(b[l]==a[l])
					c++;
			if(c==4)
				cout<<i<<endl;
		}
	}
}