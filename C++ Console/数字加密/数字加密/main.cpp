#include<iostream>
using namespace std;
void main()
{
	int i,j,n,a[4],b[4];
	cout<<"����Ҫ���ܵ���λ����"<<endl;
	cin>>n;
	j=n;
	a[3]=n%10;
	for(i=2;i>=0;i--)//�ó�ÿλ�ϵ�����
	{
		j=j/10;
		a[i]=j%10;
	}
	for(i=0;i<4;i++)
		a[i]=(a[i]+5)%10;
	b[0]=a[3];
	b[3]=a[0];
	b[1]=a[2];
	b[2]=a[1];
	cout<<"������ܺ������"<<endl;
	for(i=0;i<4;i++)
		cout<<b[i]<<" ";
	cout<<endl;
}