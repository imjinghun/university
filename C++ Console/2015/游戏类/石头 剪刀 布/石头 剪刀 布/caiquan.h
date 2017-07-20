#pragma once
#include<iostream>
#include<time.h>
#include<stdlib.h>
using namespace std;
class caiquan
{
public:
	int getn();//获得随机数
	int playerinput();//玩家输入
	void begin(caiquan cq);//猜拳开始
	caiquan(void);
	~caiquan(void);
};
