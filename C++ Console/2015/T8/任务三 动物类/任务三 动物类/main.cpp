// 动物类 王占京 2015 4 14
#include"animal.h"
#include"cat.h"
#include"leopard.h"
void main()
{
	animal a;
	animal *p;
	cat c;
	leopard l;
	p=&a;
	p->speak();
	p=&c;
	p->speak();
	p=&l;
	p->speak();
}