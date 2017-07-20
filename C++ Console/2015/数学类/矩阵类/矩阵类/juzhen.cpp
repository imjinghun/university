#include "juzhen.h"

void juzhen::gethl(int r,int c)
{
	row=r;
	col=c;
}
void juzhen::shenqing() //申请方阵行列数
{
	int i;
	a=new double*[row];
	for(i=0;i<row;i++)
		*(a+i)=new double[col];
}
void juzhen::input ()//输入矩阵
{
	int i,j;
	cout<<"输入行为 "<<row<<" 列为 "<<col<<" 的方阵"<<endl;
	for(i=0;i<row;i++)
		for(j=0;j<col;j++)
			cin>>a[i][j];
}
void juzhen::output(juzhen A) // 输出运算结果
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

juzhen operator+(juzhen A,juzhen B)//方阵加法
{
	juzhen b;	//此处有b的空间也得申请
	b.row=A.row;
	b.col=A.col;
	b.shenqing();
	int i,j;
	for(i=0;i<A.row;i++)
		for(j=0;j<A.col;j++)
			b.a[i][j]=A.a[i][j]+B.a[i][j];
	return b;
}

juzhen operator-(juzhen A,juzhen B)//方阵减法
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

juzhen operator*(juzhen A,juzhen B)//方阵乘法
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
void juzhen::ji(int rr,int cc,juzhen A)//矩阵的迹(只有方阵中有迹)
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
		cout<<"不是方阵，没有迹"<<endl;
}
bool juzhen::det1(juzhen A)//判断是否是方阵
{
	bool f;
	if(A.row!=A.col)
		f=true;
	else
		f=false;
	return f;
}
double juzhen::det(juzhen A)//行列式及是否可逆
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
		if(zj.a[i][i]==0)//第i行i列为0
		{
			for(j=i+1;j<A.row;j++)//当第j行第i列不为0时循环停止
				if(zj.a[j][i]!=0)		//得到第一个不为0的值
					break;
			if(j==A.row)		//如果j和行数相等时表示第i列的所有行值均为0，行列式值为0
				return 0;
			for(k=i;k<A.row;k++)//比如第一行第一列值为0，第n行第一列为首个不为0的值，则第n行和第一行互换
			{
				t=zj.a[i][k];
				zj.a[i][k]=zj.a[j][k];
				zj.a[j][k]=t;
			}
			s++;	//表示换了多少次行
		}
		r*=zj.a[i][i]; //每换一次行乘一次
		for(k=i+1;k<A.row;k++)//判断倍数 消元
			zj.a[i][k]/=zj.a[i][i];

		for(j=i+1;j<A.row;j++)
			for(k=i+1;k<A.row;k++)
				zj.a[j][k]-=zj.a[j][i]*zj.a[i][k];//可以化成下三角
	}
	if(s%2!=0)//s换行次数为奇数，行列式值变号
		r=-r;
	zj.qingchu();
	return r;
}
void juzhen::qingchu()  //释放空间
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
