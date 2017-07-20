#include"chess.h"
void main()
{
	chess ch;
	string fs;
	cout<<"选择先下后下 按‘f'先下，'s'后下"<<endl;
	cin>>fs;
	if(fs=="f")
		ch.start1();
	if(fs=="s")
		ch.start2();
}