#include"xjguan.h"

void main()
{
	xjguan xj1;
	int c=0;
	while(1)
	{
		int xh;//序号xh
		cout<<"输入你想要的操作序号 1创建 2添加 3汇总 4排序 5查询 6显示 7退出"<<endl;
		cin>>xh;
		if(xh==1)
		{
			int d;
			cout<<"输入你想要创建的个数"<<endl;
			cin>>d;
			xj1.apply(d);
			cout<<"输入 学号 姓名 语文 数学 英语成绩"<<endl;
			xj1.input1(c,d);
			c=d;
		}
		else if(xh==2)
		{
			int choice,place;
			int in,n;
			cout<<"选择操作  1插入学生信息到某位置 2在已有的学生信息后面追加"<<endl;
			while(1)
			{
				cin>>choice;
				if(choice==1)
				{
					cout<<"输入要插入的位置"<<endl;
					cin>>place;
					cout<<"输入要插入的人数"<<endl;
					cin>>in;
					n=c+in;
					xj1.apply(n);
					xj1.charu(place,in,n);
					cout<<"输入 学号 姓名 语文 数学 英语成绩"<<endl;
					if(place>c)
						xj1.input1(c,n);
					else
						xj1.input1(place,place+in);
					c=n;
					break;
				}
				else if(choice==2)
				{
					cout<<"输入要添加的人数"<<endl;
					cin>>in;
					n=c+in;
					xj1.apply(n);
					cout<<"输入 学号 姓名 数学 英语 语文成绩"<<endl;
					xj1.input1(c,n);
					c=n;
					break;
				}
				else
					cout<<"无此功能，请重新输入！"<<endl;
			}
		}
		else if(xh==3)
		{
			cout<<"输出学号 姓名 总分"<<endl;
			xj1.huizong(c);
		}
		else if(xh==4)
		{
			cout<<"输出排序后的学号 姓名 语文 数学 英语成绩 平均分 总分"<<endl;
			xj1.paixu(c);
		}
		else if(xh==5)
		{
			string cha;
			cout<<"输入被查找者学号"<<endl;
			cin>>cha;
			xj1.chazhao(c,cha);
		}
		else if(xh==6)
		{
			cout<<"输出 学号 姓名 语文 数学 英语成绩 平均分 总分"<<endl;
			xj1.output1(0,c);
		}
		else if(xh==7)
			break;
		else
			cout<<"无此功能"<<endl;
	}
}