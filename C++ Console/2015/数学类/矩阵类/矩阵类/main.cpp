#include"juzhen.h"
void main()
{
	juzhen jz0,jz1,jz2,jz3,jz4;;
	int r0,c0,r1,c1;
	cout<<"输入第一个矩阵行列数"<<endl;
	cin>>r0>>c0;
	
	jz0.gethl(r0,c0);
	jz0.shenqing();
	jz0.input();
	
	cout<<"输入第二个矩阵行列数"<<endl;
	cin>>r1>>c1;
	jz1.gethl(r1,c1);
	jz1.shenqing();
	jz1.input();
	
	if(r0==r1&&c0==c1)
	{
		cout<<"加法结果为"<<endl;
		jz2=jz0+jz1;
		jz2.output(jz2);
		cout<<endl;

		cout<<"减法结果为"<<endl;
		jz3=jz0-jz1;
		jz3.output(jz3);
		cout<<endl;
	}
	else
		cout<<"两个矩阵行列数不一一对应，不能算加减法"<<endl;
	cout<<endl;

	if(r0==c1)
	{
		cout<<"乘法结果为"<<endl;
		jz4=jz0*jz1;
		jz4.output(jz4);
		cout<<endl;
	}
	else
		cout<<"第一个矩阵行数不等于第二个矩阵列数，不能算乘法"<<endl;
	cout<<endl;

	cout<<"方阵的迹依次为"<<endl;
	cout<<endl;
	jz0.ji(r0,c0,jz0);
	jz1.ji(r1,c1,jz1);
	cout<<endl;

	cout<<"行列式值依次为"<<endl;
	cout<<endl;
	double zh[2];
	int i;
	bool flag[2];
	for(i=0;i<2;i++)
	{
		flag[0]=jz0.det1(jz0);
		zh[0]=jz0.det(jz0);

		flag[1]=jz1.det1(jz1);
		zh[1]=jz1.det(jz1);

		if(flag[i]==true)
			cout<<"该矩阵不是方阵，不存在行列式，故不可逆。"<<endl;
		else
		{
			if(zh[i]==0)
				cout<<"行列式值为 "<<zh[i]<<" 矩阵不可逆"<<endl;
			else
				cout<<"行列式值为 "<<zh[i]<<" 矩阵可逆"<<endl;
		}
	}

}