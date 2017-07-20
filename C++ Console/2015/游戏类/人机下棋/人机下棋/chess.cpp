#include "chess.h"

void chess::output()//输出
{
		cout<<"┌"<<"━"<<"┳"<<""<<"━"<<"┳"<<"━"<<"┓"<<endl;
		cout<<"│"<<str[0][0]<<" ┃"<<str[0][1]<<" ┃"<<str[0][2]<<" ┃"<<endl;
		cout<<"┣"<<"━"<<"╋"<<""<<"━"<<"╋"<<"━"<<"┫"<<endl;
		cout<<"│"<<str[1][0]<<" ┃"<<str[1][1]<<" ┃"<<str[1][2]<<" ┃"<<endl;
		cout<<"┣"<<"━"<<"╋"<<""<<"━"<<"╋"<<"━"<<"┫"<<endl;
		cout<<"│"<<str[2][0]<<" ┃"<<str[2][1]<<" ┃"<<str[2][2]<<" ┃"<<endl;
		cout<<"└"<<"━"<<"┴"<<""<<"━"<<"┻"<<"━"<<"┛"<<endl;
}
int suiji()//电脑随机获得位置
{
	int sj;
	srand((int)time(0));
	sj=rand()%3;
	return sj;
}
void chess::choose2()//电脑选择下棋
{
	int place1,place2;
	place1=suiji();
	place2=suiji();
	while(1)//电脑获得的位置和玩家或自己相同时，电脑重新获得位置
	{
		if(a[place1][place2]==0)
		{
			if(str1=="x")
				str[place1][place2]=str2;//str2代表o,已经初始化
			else
				str[place1][place2]=str1;
			break;
		}
		else
		{
			place1=suiji();
			place2=suiji();
		}
	}
	a[place1][place2]=4;
}
void chess::choose1(string s)//玩家选择下棋
{
	int place1,place2;
	cin>>place1>>place2;
	while(1)//玩家选择的位置和电脑或自己相同时，玩家重新选择位置
	{
		if(a[place1-1][place2-1]==0)
		{
			str[place1-1][place2-1]=s;//s为玩家选的棋子
			break;
		}
		else
		{
			cout<<"位置已被占，请重新选择位置"<<endl;
			cin>>place1>>place2;
		}
	}
	a[place1-1][place2-1]=1;
}
void chess::choose11()//玩家选择下棋(电脑先下时)
{
	int place1,place2;
	cin>>place1>>place2;
	while(1)//玩家选择的位置和电脑或自己相同时，玩家重新选择位置
	{	
		if(a[place1-1][place2-1]==0)
		{
			str[place1-1][place2-1]=str1;//s为玩家选的棋子
			break;
		}
		else
		{
			cout<<"位置已被占，请重新选择位置"<<endl;
			cin>>place1>>place2;
		}
	}
	a[place1-1][place2-1]=1;
}
bool chess::pan1()//玩家胜
{
	bool f=false;
	int sum=0,i,j;
	for(i=0;i<3;i++)//判断行
	{
		for(j=0;j<3;j++)
			sum+=a[i][j];
		if(sum==3)
		{
			f=true;
			break;
		}
	}
	sum=0;
	for(i=0;i<3;i++)//判断列
	{
		for(j=0;j<3;j++)
			sum+=a[j][i];
		if(sum==3)
		{
			f=true;
			break;
		}
	}
	sum=0;
	for(i=0;i<3;i++)//判断主对角线
	{
		sum+=a[i][i];
		if(sum==3)
			f=true;
	}
	sum=0;
	j=3;
	for(i=0;i<3;i++)//判断次对角线
	{
		j--;
		sum+=a[i][j];
		if(sum==3)
			cout<<"玩家胜"<<endl;
	}
	return f;
}
bool chess::pan2()//电脑胜
{
	bool f=false;
	int sum=0,i,j;
	for(i=0;i<3;i++)//判断行
	{
		for(j=0;j<3;j++)
			sum+=a[i][j];
		if(sum==12)
		{
			f=true;
			break;
		}
	}
	sum=0;
	for(i=0;i<3;i++)//判断列
	{
		for(j=0;j<3;j++)
			sum+=a[j][i];
		if(sum==12)
		{
			f=true;
			break;
		}
	}
	sum=0;
	for(i=0;i<3;i++)//判断主对角线
	{
		sum+=a[i][i];
		if(sum==12)
			f=true;
	}
	sum=0;
	j=3;
	for(i=0;i<3;i++)//判断次对角线
	{
		j--;
		sum+=a[i][j];
		if(sum==12)
			f=true;
	}
	return f;
}
void chess::start1()//开始游戏(玩家先下)
{
	bool flag;
	string str3;
	chess cs;
	cout<<"选择你要使用的棋子 'X' 或 'O'"<<endl;//试试双引号
	cin>>str3;
	cout<<"初始状态"<<endl;
	cs.output();
	cout<<"选择你要下的位置(从带有“*”号的位置选) 输入行列位置"<<endl;
	while(1)
	{
		cout<<"玩家下"<<endl;
		cout<<endl;
		cs.choose1(str3);
		cs.output();
		flag=cs.pan1();
		if(flag==true)
		{
			cout<<"玩家胜"<<endl;
			break;
		}
		cout<<endl;
		cout<<"电脑下"<<endl;
		cout<<endl;
		cs.choose2();
		cs.output();
		flag=cs.pan2();
		if(flag==true)
		{
			cout<<"电脑胜"<<endl;
			break;
		}
	}
}
void chess::start2()//开始游戏(电脑先下)
{
	int m=1;
	bool flag;
	string str3;
	chess cs;
	cout<<"初始状态"<<endl;
	cs.output();
	while(1)
	{
		cout<<"电脑下"<<endl;
		cout<<endl;
		cs.choose2();
		cs.output();
		flag=cs.pan2();
		if(flag==true)
		{
			cout<<"电脑胜"<<endl;
			break;
		}
		if(m==1)
		{
			cout<<"选择你要下的位置(从带有“*”号的位置选) 输入行列位置"<<endl;
			m=0;
		}
		cout<<"玩家下"<<endl;
		cout<<endl;
		cs.choose11();
		cs.output();
		cout<<endl;
		flag=cs.pan1();
		if(flag==true)
		{
			cout<<"玩家胜"<<endl;
			break;
		}
	}
}
chess::chess(void)
{
	int i,j;
	for(i=0;i<3;i++)
		for(j=0;j<3;j++)
		{
			str[i][j]="*";
			a[i][j]=0;
		}
	str2="o";
	str1="x";
}
chess::~chess(void)
{
}
