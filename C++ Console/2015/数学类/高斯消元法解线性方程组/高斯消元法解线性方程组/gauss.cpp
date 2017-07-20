#include "gauss.h"
void gauss::gethl(int r,int c)
{
	row=r;
	col=c;
}
void gauss::shenqing() //���뷽��������
{
	int i;
	a=new double*[row];
	for(i=0;i<row;i++)
		*(a+i)=new double[col];
}
void gauss::qingchu()  //�ͷſռ�
{
	int i;
	for(i=0;i<row;i++)
		delete[]a[i];
	delete []a;
}
void gauss::input ()//�������
{
	int i,j;
	cout<<"������Ϊ "<<row<<" ��Ϊ "<<col<<" �ľ���"<<endl;
	for(i=0;i<row;i++)
		for(j=0;j<col;j++)
			cin>>a[i][j];
}
double gauss::det(gauss A)//����ʽ
{
	int i,j,k,s= 0;
	double r=1,t;
	gauss ga;
	ga.row=A.row;
	ga.col=A.col;
	ga.shenqing();

	for(i=0;i<A.row;i++)
		for(j=0;j<A.col;j++)
			ga.a[i][j]=A.a[i][j];

	for(i=0;i<A.row;i++)
	{
		if(ga.a[i][i]==0)//��i��i��Ϊ0
		{
			for(j=i+1;j<A.row;j++)//����j�е�i�в�Ϊ0ʱѭ��ֹͣ
				if(ga.a[j][i]!=0)		//�õ���һ����Ϊ0��ֵ
					break;
			if(j==A.row)		//���j���������ʱ��ʾ��i�е�������ֵ��Ϊ0������ʽֵΪ0
				return 0;
			for(k=i;k<A.row;k++)//�����һ�е�һ��ֵΪ0����n�е�һ��Ϊ�׸���Ϊ0��ֵ�����n�к͵�һ�л���
			{
				t=ga.a[i][k];
				ga.a[i][k]=ga.a[j][k];
				ga.a[j][k]=t;
			}
			s++;	//��ʾ���˶��ٴ���
		}
		r*=ga.a[i][i]; //ÿ��һ���г�һ��
		for(k=i+1;k<A.row;k++)//�жϱ��� ��Ԫ
			ga.a[i][k]/=ga.a[i][i];

		for(j=i+1;j<A.row;j++)
			for(k=i+1;k<A.row;k++)
				ga.a[j][k]-=ga.a[j][i]*ga.a[i][k];//���Ի���������
	}
	if(s%2!=0)//s���д���Ϊ����������ʽֵ���
		r=-r;
	ga.qingchu();
	return r;
}
void output(gauss A,gauss B)//������
{
	gauss ga,g1;
	int i,k,j=0,m,n;
	double d;
	ga.col=1;
	ga.row=A.row;
	ga.shenqing();
	g1.row=A.row;
	g1.col=A.col;
	g1.shenqing();
	d=A.det(A);

	if(d==0)
		cout<<"ÿ��δ֪����ֵΪ0"<<endl;
	else
	{
		for(i=0;i<A.row;i++)
		{
			for(m=0;m<A.row;m++)//�ȸ���һ��
				for(n=0;n<A.col;n++)
					g1.a[m][n]=A.a[m][n];
			for(k=0;k<A.row;k++)//�н���
				A.a[k][j]=B.a[k][0];
			ga.a[i][0]=A.det(A);
			for(m=0;m<A.row;m++)//����ǰ���Ƶ��ٷ��������Ա�֤�Ⱥ�ǰ�ķ���ֵ����
				for(n=0;n<A.col;n++)
					A.a[m][n]=g1.a[m][n];
			j++;
		}	
		cout<<"δ֪����ֵ����Ϊ"<<endl;
		for(i=0;i<A.row;i++)
			cout<<ga.a[i][0]/d<<endl;
	}
	ga.qingchu();
	cout<<endl;
}
gauss::gauss(void)
{
}
gauss::~gauss(void)
{
}
