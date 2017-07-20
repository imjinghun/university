#include "guess.h"

int guess::getn()//获得随机数
{
	int m;
	srand((int)time(0));//srand((int)time(0))表示以当前时间对应的int值为随机序列起点
	m=rand()%9999+1;	//time(0) time函数给出从1970年1月1日00:00:00至今的秒数
	return m;
}
int guess::settime()//设置游戏时间
{
	int s;
	cout<<"输入你所打算玩游戏猜数字的时间(秒)，输入后按下enter游戏开始"<<endl;
	cin>>s;
	return s;
}
int guess::playerinput()//玩家输入所猜数字
{
	int g;
	cout<<"输入所猜的数"<<endl;
	cin>>g;
	return g;
}
void guess::tishi(guess gu,int g,int m)//游戏提示
{
	int c,n;
	c=g;		//输入的数
	n=m;		//随机数
	if(c>n)
		cout<<"大了"<<endl;
	else if(c<n)
		cout<<"小了"<<endl;
	else 
		cout<<"恭喜！答对了！正确猜出数字  "<<n<<endl;
}
void guess::begin(guess gu)
{
	int m,g,s,x=0;// m随机数 g输入的数 s输入的时间
	m=gu.getn();	//获得随机数
	s=gu.settime();//设置游戏时间
	long t=clock();// 开始计时
	while((clock()-t)/CLOCKS_PER_SEC<=s)
	{
		cout<<"还剩时间 "<<s-(clock()-t)/CLOCKS_PER_SEC<<" 秒"<<endl;
		if(s-(clock()-t)/CLOCKS_PER_SEC==0)
			break;
		g=gu.playerinput();
		gu.tishi(gu,g,m);//游戏提示
		if(g==m)
		{
			int miao;
			cout<<endl;
			cout<<"输入停留在此界面的秒数，接下来按照提示操作"<<endl;
			cin>>miao;
			Sleep(1000*miao);//界面停留时长
			break;
		}
	}
	if((clock()-t)/CLOCKS_PER_SEC>=s)
	{
		int miao;
		cout<<"时间到，很遗憾未猜出数字 "<<s<<endl;
		cout<<endl;
		cout<<"输入停留在此界面的秒数，接下来按照提示操作"<<endl;
		cin>>miao;
		Sleep(1000*miao);//界面停留时长
	}
		
}
void guess::again()//新游戏
{
	system("cls");
	guess gu;
	int x;
	cout<<"选择接下来的操作 1新游戏 2结束游戏"<<endl;
	cin>>x;
	while(x==1)
	{
		gu.begin(gu);
		cout<<"选择接下来的操作 1新游戏 2结束游戏"<<endl;
		cin>>x;
	}
}
guess::guess(void)
{
}
guess::~guess(void)
{
}

