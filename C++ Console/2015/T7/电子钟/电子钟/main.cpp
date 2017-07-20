#include"clock.h"

istream& operator>>(istream&input,clock&a)
{cout<<"please input the hour: ";
input>>a.hou;
cout<<"please input the minute: ";
input>>a.min;
cout<<"please input the second: ";
input>>a.sec;
return input;}
ostream& operator<<(ostream&output,clock&a)
{if(a.sec>=60) {a.sec-=60;a.min+=1;}
if(a.min>=60) {a.min-=60;a.hou+=1;}
if(a.hou>=24){a.hou-=24;}
output<<a.hou<<":"<<a.min<<":"<<a.sec<<endl;
return output;
}


void main()
{clock A;
cin>>A;
cout<<A;
cout<<endl;

cout<<++A<<endl;
cout<<--A<<endl;
++A;
cout<<A<<endl;
}