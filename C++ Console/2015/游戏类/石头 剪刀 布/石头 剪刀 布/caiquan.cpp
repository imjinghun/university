#include "caiquan.h"
int caiquan::getn()//获得随机数
{
	int n;
	srand((int)time(0));
	n=rand()%2+1;
	return n;
}
int caiquan::playerinput()//玩家输入
{
	int m;
	cout<<"从1到3输入一个数，其中1代表石头，2代表剪刀，3代表布"<<endl;
	cin>>m;
	while(m<1||m>3)
	{
		cout<<"输入不合法请重新输入"<<endl;
		cin>>m;
	}
	return m;
}
void caiquan::begin(caiquan cq)
{
	int n,m,x=0,i=0,c=0,a=0,b=0;
	n=cq.getn();
	m=cq.playerinput();
	while(1)
	{
		
		if(n==1&&m==1)//计算机和玩家都出石头
		{
			i++;
			cout<<"这是第 "<<i<<" 局"<<endl;
			cout<<"计算机和玩家都出石头，平局"<<endl;
			c++;
			while(1)
			{
				cout<<endl<<"选择接下来的操作 1新游戏 2游戏结束"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"总共玩了 "<<i<<" 局"<<endl;
					cout<<"平局总共 "<<c<<" 局"<<endl;
					cout<<"玩家胜利 "<<a<<" 局"<<endl;
					cout<<"玩家失败 "<<b<<" 局"<<endl;
					break;
				}
				else
					cout<<"无此功能!"<<endl;
			}
			if(x==2)
				break;
		}
		if(n==2&&m==2)//计算机和玩家都出剪刀
		{
			i++;
			cout<<"这是第 "<<i<<" 局"<<endl;
			cout<<"计算机和玩家都出剪刀，平局"<<endl;
			c++;
			while(1)
			{
				cout<<endl<<"选择接下来的操作 1新游戏 2游戏结束"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"总共玩了 "<<i<<" 局"<<endl;
					cout<<"平局总共 "<<c<<" 局"<<endl;
					cout<<"玩家胜利 "<<a<<" 局"<<endl;
					cout<<"玩家失败 "<<b<<" 局"<<endl;
					break;
				}
				else
					cout<<"无此功能!"<<endl;
			}
			if(x==2)
				break;
		}
		if(n==3&&m==3)//计算机和玩家都出布
		{
			i++;
			cout<<"这是第 "<<i<<" 局"<<endl;
			cout<<"计算机和玩家都出布，平局"<<endl;
			c++;
			while(1)
			{
				cout<<endl<<"选择接下来的操作 1新游戏 2游戏结束"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"总共玩了 "<<i<<" 局"<<endl;
					cout<<"平局总共 "<<c<<" 局"<<endl;
					cout<<"玩家胜利 "<<a<<" 局"<<endl;
					cout<<"玩家失败 "<<b<<" 局"<<endl;
					break;
				}
				else
					cout<<"无此功能!"<<endl;
			}
			if(x==2)
				break;
		}
		if(n==1&&m==2)//计算机出石头，玩家出剪刀
		{
			i++;
			cout<<"这是第 "<<i<<" 局"<<endl;
			cout<<"计算机出石头，玩家出剪刀，玩家失败"<<endl;
			b++;
			while(1)
			{
				cout<<endl<<"选择接下来的操作 1新游戏 2游戏结束"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"总共玩了 "<<i<<" 局"<<endl;
					cout<<"平局总共 "<<c<<" 局"<<endl;
					cout<<"玩家胜利 "<<a<<" 局"<<endl;
					cout<<"玩家失败 "<<b<<" 局"<<endl;
					break;
				}
				else
					cout<<"无此功能!"<<endl;
			}
			if(x==2)
				break;
		}
		if(n==1&&m==3)//计算机出石头，玩家出布
		{
			i++;
			cout<<"这是第 "<<i<<" 局"<<endl;
			cout<<"计算机出石头，玩家出布，玩家胜利"<<endl;
			a++;
			while(1)
			{
				cout<<endl<<"选择接下来的操作 1新游戏 2游戏结束"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"总共玩了 "<<i<<" 局"<<endl;
					cout<<"平局总共 "<<c<<" 局"<<endl;
					cout<<"玩家胜利 "<<a<<" 局"<<endl;
					cout<<"玩家失败 "<<b<<" 局"<<endl;
					break;
				}
				else
					cout<<"无此功能!"<<endl;
			}
			if(x==2)
				break;
		}
		if(n==2&&m==3)//计算机出剪刀，玩家出布
		{
			i++;
			cout<<"这是第 "<<i<<" 局"<<endl;
			cout<<"计算机出剪刀，玩家出布，玩家失败"<<endl;
			b++;
			while(1)
			{
				cout<<endl<<"选择接下来的操作 1新游戏 2游戏结束"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"总共玩了 "<<i<<" 局"<<endl;
					cout<<"平局总共 "<<c<<" 局"<<endl;
					cout<<"玩家胜利 "<<a<<" 局"<<endl;
					cout<<"玩家失败 "<<b<<" 局"<<endl;
					break;
				}
				else
					cout<<"无此功能!"<<endl;
			}
			if(x==2)
				break;
		}
		if(n==2&&m==1)//计算机出剪刀，玩家出石头
		{
			i++;
			cout<<"这是第 "<<i<<" 局"<<endl;
			cout<<"计算机出剪刀，玩家出石头，玩家胜利"<<endl;
			a++;
			while(1)
			{
				cout<<endl<<"选择接下来的操作 1新游戏 2游戏结束"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"总共玩了 "<<i<<" 局"<<endl;
					cout<<"平局总共 "<<c<<" 局"<<endl;
					cout<<"玩家胜利 "<<a<<" 局"<<endl;
					cout<<"玩家失败 "<<b<<" 局"<<endl;
					break;
				}
				else
					cout<<"无此功能!"<<endl;
			}
			if(x==2)
				break;
		}
		if(n==3&&m==1)//计算机出布，玩家出石头
		{
			i++;
			cout<<"这是第 "<<i<<" 局"<<endl;
			cout<<"计算机出布，玩家出石头，玩家失败"<<endl;
			b++;
			while(1)
			{
				cout<<endl<<"选择接下来的操作 1新游戏 2游戏结束"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"总共玩了 "<<i<<" 局"<<endl;
					cout<<"平局总共 "<<c<<" 局"<<endl;
					cout<<"玩家胜利 "<<a<<" 局"<<endl;
					cout<<"玩家失败 "<<b<<" 局"<<endl;
					break;
				}
				else
					cout<<"无此功能!"<<endl;
			}
			if(x==2)
				break;
		}
		if(n==3&&m==2)//计算机出布，玩家出剪刀
		{
			i++;
			cout<<"这是第 "<<i<<" 局"<<endl;
			cout<<"计算机出布，玩家出剪刀，玩家胜利"<<endl;
			a++;
			while(1)
			{
				cout<<endl<<"选择接下来的操作 1新游戏 2游戏结束"<<endl;
				cin>>x;
				system("cls");
				if(x==1)
				{
					n=cq.getn();
					m=cq.playerinput();
					break;
				}
				else if(x==2)
				{
					cout<<"总共玩了 "<<i<<" 局"<<endl;
					cout<<"平局总共 "<<c<<" 局"<<endl;
					cout<<"玩家胜利 "<<a<<" 局"<<endl;
					cout<<"玩家失败 "<<b<<" 局"<<endl;
					break;
				}
				else
					cout<<"无此功能!"<<endl;
			}
			if(x==2)
				break;
		}
	}
}
caiquan::caiquan(void)
{
}


caiquan::~caiquan(void)
{
}