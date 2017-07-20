//文件输入以及数据处理 王占京 2015 4 16
#include <iostream>
#include <fstream>
using namespace std;

int main( )
{
	int a[10],i,t,j;
	ifstream infile;
	infile.open("D:\\f1.txt", ios::in);
    if(infile.is_open() == false)
   {
	   cerr << "open error!" << endl;
       exit(1);
   }

   for(i=0;i<10;i++) 
   {
	   infile >> a[i];
    }          
  for(j=0;j<10;j++)
  {
   for(i = j+1;i < 10;i++)
     if(a[i] > a[j])
    {
		t=a[i];
		a[i]=a[j];
		a[j] = t;                                
    }
	 cout<<a[j]<<" ";
  }
  ofstream outfile("D:\\f2.txt");
  for(i=0;i<10;i++)
	outfile<<a[i]<<" ";
   infile.close();
   outfile.close();
   return 0;
}
