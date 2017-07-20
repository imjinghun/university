#pragma once
#include<iostream>
#include<string>
#include<time.h>
using namespace std;
class chess
{
	string str[3][3],str1,str2;
	int a[3][3];
public:
	friend int suiji();		//电脑获得随机数
	void choose1(string s); //玩家选下棋位置
	void choose11();
	void choose2();			//电脑选下棋位置
	bool pan1();			//判断玩家胜
	bool pan2();			//判断电脑胜
	void start1();			//开始游戏(玩家先下)
	void start2();			//开始游戏(电脑先下)
	void output();			//输出
	chess(void);			//初始化
	~chess(void);
};

