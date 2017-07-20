//数学多功能管理程序
#include"shuguan.h"
void main()
{
	shuguan a;
	int n;

	while(1)
	{
		cout<<"输入你需要功能的序号 1素数输出(1000以内) 2水仙花数 3完数输出(1000以内)"<<endl;
		cout<<"4冒泡法排序 5字符串中信息分类汇总  6退出"<<endl;
		cin>>n;
		if(n==1)
		{
			cout<<"1000以内素数"<<endl;
			a.sushu();
		}

		else if(n==2)
		{
			cout<<"100--1000内的水仙花数"<<endl;
			a.shuixianhua();
		}

		else if(n==3)
		{
			cout<<"1000以内的完数"<<endl;
			a.wanshu();
		}

		else if(n==4)
			a.paixu();
		else if(n==5)
			a.zxfh();
		else if(n==6)
			break;
		else
			cout<<"无此功能！"<<endl;

	}
}