#include "teacher.h"
#include<fstream>

teacher::~teacher(void)
{
}

void teacher::paixu(teacher a[])
{
	int i,j;
	teacher m[4];
	for(i=0;i<4;i++)
		for(j=i+1;j<4;j++)
			if(a[i].salary<a[j].salary)
			{
				m[i]=a[i];
				a[i]=a[j];
				a[j]=m[i];
			}
			ofstream outfile("d:\\tian.txt",ios::out);
		if(!outfile)
		{
			cerr<<"error"<<endl;
			abort();
		}

		outfile<<a[0].num<<" "<<a[0].name<<" "<<a[0].salary<<endl;
		outfile.close();

}