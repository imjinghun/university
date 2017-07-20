#include"tongxun.h"
void main()
{
	tongxun tx1;
	int c=0;
	while(1)
	{
		int xh;//序号xh
		cout<<"输入你想要的操作序号 1创建 2添加 3查询 4修改 5删除 6显示 7退出"<<endl;
		cin>>xh;
		if(xh==1)
		{
			int d;
			cout<<"输入你想要创建的个数"<<endl;
			cin>>d;
			tx1.apply(d);
			cout<<"输入 编号 年龄 姓名 性别 宅电 手机号码"<<endl;
			tx1.input1(c,d);
			c=d;
		}
		else if(xh==2)
		{
			int in,n;
			cout<<"输入想要添加的个数"<<endl;
			cin>>in;
			n=c+in;
			tx1.apply(n);
			cout<<"输入 编号 年龄 姓名 性别 宅电 手机号码"<<endl;
			tx1.input1(c,n);
			c=n;
		}
		else if(xh==3)
		{
			string cha;
			cout<<"输入被查找者的姓名或手机号"<<endl;
			cin>>cha;
			tx1.chazhao(c,cha);
		}
		else if(xh==4)
		{
			string gai;
			cout<<"输入被修改者的姓名"<<endl;
			cin>>gai;
			tx1.xiugai(c,gai);
		}
		else if(xh==5)
		{
			string shan;
			cout<<"输入被删除者的姓名"<<endl;
			cin>>shan;
			tx1.apply(c+1);
			tx1.shanchu(c,shan);
			c--;
		}
		else if(xh==6)
		{
			cout<<"输出 编号 年龄 姓名 性别 宅电 手机号码"<<endl;
			tx1.output1(0,c);
		}
		else if(xh==7)
			break;
		else
			cout<<"无此功能"<<endl;
	}
}