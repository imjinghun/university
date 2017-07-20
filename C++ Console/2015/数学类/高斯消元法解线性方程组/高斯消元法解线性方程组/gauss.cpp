#include "gauss.h"
void gauss::gethl(int r,int c)
{
	row=r;
	col=c;
}
void gauss::shenqing() //申请方阵行列数
{
	int i;
	a=new double*[row];
	for(i=0;i<row;i++)
		*(a+i)=new double[col];
}
void gauss::qingchu()  //释放空间
{
	int i;
	for(i=0;i<row;i++)
		delete[]a[i];
	delete []a;
}
void gauss::input ()//输入矩阵
{
	int i,j;
	cout<<"输入行为 "<<row<<" 列为 "<<col<<" 的矩阵"<<endl;
	for(i=0;i<row;i++)
		for(j=0;j<col;j++)
			cin>>a[i][j];
}
double gauss::det(gauss A)//行列式
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
		if(ga.a[i][i]==0)//第i行i列为0
		{
			for(j=i+1;j<A.row;j++)//当第j行第i列不为0时循环停止
				if(ga.a[j][i]!=0)		//得到第一个不为0的值
					break;
			if(j==A.row)		//如果j和行数相等时表示第i列的所有行值均为0，行列式值为0
				return 0;
			for(k=i;k<A.row;k++)//比如第一行第一列值为0，第n行第一列为首个不为0的值，则第n行和第一行互换
			{
				t=ga.a[i][k];
				ga.a[i][k]=ga.a[j][k];
				ga.a[j][k]=t;
			}
			s++;	//表示换了多少次行
		}
		r*=ga.a[i][i]; //每换一次行乘一次
		for(k=i+1;k<A.row;k++)//判断倍数 消元
			ga.a[i][k]/=ga.a[i][i];

		for(j=i+1;j<A.row;j++)
			for(k=i+1;k<A.row;k++)
				ga.a[j][k]-=ga.a[j][i]*ga.a[i][k];//可以化成下三角
	}
	if(s%2!=0)//s换行次数为奇数，行列式值变号
		r=-r;
	ga.qingchu();
	return r;
}
void output(gauss A,gauss B)//输出结果
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
		cout<<"每个未知变量值为0"<<endl;
	else
	{
		for(i=0;i<A.row;i++)
		{
			for(m=0;m<A.row;m++)//先复制一次
				for(n=0;n<A.col;n++)
					g1.a[m][n]=A.a[m][n];
			for(k=0;k<A.row;k++)//列交换
				A.a[k][j]=B.a[k][0];
			ga.a[i][0]=A.det(A);
			for(m=0;m<A.row;m++)//把先前复制的再返回来，以保证等号前的方阵值不变
				for(n=0;n<A.col;n++)
					A.a[m][n]=g1.a[m][n];
			j++;
		}	
		cout<<"未知变量值依次为"<<endl;
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
