#include "juzhen.h"

void juzhen::gethl(int r,int c)
{
	row=r;
	col=c;
}
void juzhen::shenqing() //���뷽��������
{
	int i;
	a=new double*[row];
	for(i=0;i<row;i++)
		*(a+i)=new double[col];
}
void juzhen::input ()//�������
{
	int i,j;
	cout<<"������Ϊ "<<row<<" ��Ϊ "<<col<<" �ķ���"<<endl;
	for(i=0;i<row;i++)
		for(j=0;j<col;j++)
			cin>>a[i][j];
}
void juzhen::output(juzhen A) // ���������
{
	int i,j;
	for(i=0;i<row;i++)
	{
		for(j=0;j<col;j++)
			cout<<A.a[i][j]<<" ";
		cout<<endl;
	}
	A.qingchu();
}

juzhen operator+(juzhen A,juzhen B)//����ӷ�
{
	juzhen b;	//�˴���b�Ŀռ�Ҳ������
	b.row=A.row;
	b.col=A.col;
	b.shenqing();
	int i,j;
	for(i=0;i<A.row;i++)
		for(j=0;j<A.col;j++)
			b.a[i][j]=A.a[i][j]+B.a[i][j];
	return b;
}

juzhen operator-(juzhen A,juzhen B)//�������
{
	juzhen b;
	b.row=A.row;
	b.col=A.col;
	b.shenqing();
	int i,j;
	for(i=0;i<A.row;i++)
		for(j=0;j<A.col;j++)
			b.a[i][j]=A.a[i][j]-B.a[i][j];
	return b;
}

juzhen operator*(juzhen A,juzhen B)//����˷�
{
	juzhen b;
	b.row=A.row;
	b.col=A.col;
	b.shenqing();
	int i,j,k;
	for(i=0;i<A.row;i++)
		for(j=0;j<A.col;j++)
		{
			b.a[i][j]=0;
			for(k=0;k<A.col;k++)
				b.a[i][j]+=A.a[i][k]*B.a[k][i]; 
		}
	return b;
}
void juzhen::ji(int rr,int cc,juzhen A)//����ļ�(ֻ�з������м�)
{
	if(rr==cc)
	{
		int i;
		double d=0;
		for(i=0;i<rr;i++)
			d+=A.a[i][i];
		cout<<d<<endl;
	}
	else
		cout<<"���Ƿ���û�м�"<<endl;
}
bool juzhen::det1(juzhen A)//�ж��Ƿ��Ƿ���
{
	bool f;
	if(A.row!=A.col)
		f=true;
	else
		f=false;
	return f;
}
double juzhen::det(juzhen A)//����ʽ���Ƿ����
{
	int i,j,k,s= 0;
	double r=1,t;
	juzhen zj;
	zj.row=A.row;
	zj.col=A.col;
	zj.shenqing();

	for(i=0;i<A.row;i++)
		for(j=0;j<A.col;j++)
			zj.a[i][j]=A.a[i][j];

	for(i=0;i<A.row;i++)
	{
		if(zj.a[i][i]==0)//��i��i��Ϊ0
		{
			for(j=i+1;j<A.row;j++)//����j�е�i�в�Ϊ0ʱѭ��ֹͣ
				if(zj.a[j][i]!=0)		//�õ���һ����Ϊ0��ֵ
					break;
			if(j==A.row)		//���j���������ʱ��ʾ��i�е�������ֵ��Ϊ0������ʽֵΪ0
				return 0;
			for(k=i;k<A.row;k++)//�����һ�е�һ��ֵΪ0����n�е�һ��Ϊ�׸���Ϊ0��ֵ�����n�к͵�һ�л���
			{
				t=zj.a[i][k];
				zj.a[i][k]=zj.a[j][k];
				zj.a[j][k]=t;
			}
			s++;	//��ʾ���˶��ٴ���
		}
		r*=zj.a[i][i]; //ÿ��һ���г�һ��
		for(k=i+1;k<A.row;k++)//�жϱ��� ��Ԫ
			zj.a[i][k]/=zj.a[i][i];

		for(j=i+1;j<A.row;j++)
			for(k=i+1;k<A.row;k++)
				zj.a[j][k]-=zj.a[j][i]*zj.a[i][k];//���Ի���������
	}
	if(s%2!=0)//s���д���Ϊ����������ʽֵ���
		r=-r;
	zj.qingchu();
	return r;
}
void juzhen::qingchu()  //�ͷſռ�
{
	int i;
	for(i=0;i<row;i++)
		delete[]a[i];
	delete []a;
}
juzhen::juzhen(void)
{
}
juzhen::~juzhen(void)
{

}
