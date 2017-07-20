#pragma once
#include<iostream>
#include"time.h"//也可以写为#include<time.h>
#include<windows.h>
using namespace std;
class guess
{
public:
	int getn();//获得随机产生的数
	int settime();//设置游戏时间
	int playerinput();//玩家输入
	void tishi(guess gu,int g,int m);//游戏提示
	void begin(guess gu);//游戏进行
	void again();//新游戏
	guess(void);
	~guess(void);
};

