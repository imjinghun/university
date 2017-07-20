#include"gauss.h"
void main()
{
	gauss jz0,jz1,jz2;;
	int r0,c0;
	cout<<"输入线性方程组等号前的行列数"<<endl;
	cin>>r0>>c0;

	jz0.gethl(r0,c0);
	jz0.shenqing();
	jz0.input();

	cout<<"输入等号后面的数"<<endl;
	jz1.gethl(r0,1);
	jz1.shenqing();
	jz1.input();

	if(r0!=c0)
		cout<<"第一个矩阵输入的不是方阵，无法计算"<<endl;
	else
		output(jz0,jz1);
}