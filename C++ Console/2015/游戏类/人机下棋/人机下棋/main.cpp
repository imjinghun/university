#include"chess.h"
void main()
{
	chess ch;
	string fs;
	cout<<"ѡ�����º��� ����f'���£�'s'����"<<endl;
	cin>>fs;
	if(fs=="f")
		ch.start1();
	if(fs=="s")
		ch.start2();
}