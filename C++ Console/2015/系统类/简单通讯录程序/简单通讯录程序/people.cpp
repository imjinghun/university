#include "people.h"

void people::input()
{
	cin>>bianh>>age>>name>>sex>>zhaid>>shouji;
}
void people::output()
{
	cout<<bianh<<" "<<age<<" "<<name<<" "<<sex<<" "<<zhaid<<" "<<shouji<<endl;
}

people::people(void)
{
}

people::~people(void)
{
}
