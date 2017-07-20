#include<iostream>
using namespace std;
void main()
{
	double man,women,children;
	for(man=0;man<=9;man++)
		for(women=0;women<=12;women++)
			for(children=0;children<=36;children++)
				if(man+women+children==36 && 4*man+3*women+children/2==36)
				{
					cout<<"男女小孩人数分别为"<<endl;
					cout<<man<<" "<<women<<" "<<children<<endl;
				}
}