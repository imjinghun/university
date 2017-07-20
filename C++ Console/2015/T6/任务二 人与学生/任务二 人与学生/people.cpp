#include "people.h"

people::people(int m, string str)
{
	age=m;
	name=str;
}
void people::setvalue(int m, string str)
{
	age=m;
	name=str;
}
void people::display()
{
	cout<<"Êä³öÄêÁäÐÕÃû"<<endl;
	cout<<age<<" "<<name<<endl;
}
people::people(void)
{
}

people::~people(void)
{
}
