//字符文件输入 王占京 2015 4 16

#include <fstream>
#include <iostream>
#include <string>
using namespace std;

struct student
{
	int num;
   string name;
   float score;
};

int main( )
{
	student stud[5]={1001,"Li",85, 1002,"Fun",97.5, 1004,"Wang",54,
   1006,"Tan",76.5, 1010,"ling",96};
	fstream iofile("C:\\stud.dat",ios::out|ios::binary|ios::in);  
   if(!iofile)
   {
	   cerr<<"open error!"<<endl;
       abort( );
   }
   for(int i=0;i<5;i++)//向磁盘文件输出5个学生的数据
          iofile.write((char *)&stud[i],sizeof(stud[i]));  

   student stud1[5];                  //用来存放从磁盘文件读入的数据
   for(int i=0;i<5;i=i+2)
   {
	   iofile.seekg(i*sizeof(stud[i]),ios::beg);  //定位于第0,2,4学生数据开头
       iofile.read((char *)&stud1[i/2],sizeof(stud1[0])); //先后读入3个学生的数据，存放在stud1[0],stud[1]和stud[2]中
       cout<<stud1[i/2].num<<" "<<stud1[i/2].name<<" "<<stud1[i/2].score<<endl;
     //输出stud1[0],stud[1]和stud[2]各成员的值
   }
   
   iofile.seekg(3*sizeof(stud[3]),ios::beg);
   iofile.read((char *)&stud1[3],sizeof(stud1[0]));
   cout<<stud1[3].num<<" "<<stud1[3].name<<" "<<stud1[3].score-1<<endl;

   iofile.close( );
   return 0;
}
