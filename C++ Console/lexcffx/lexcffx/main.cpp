#include <string> 
#include<iostream>
#include <fstream> 
using namespace std;

void main()
{
	cout << "原内容：" << endl << endl;
	ifstream ifile;
	ifile.open("in.txt");//读入的文件名
	if (ifile.is_open())
	{
		string line1, line2;
		while (!ifile.eof())
		{
			getline(ifile, line1);
			cout << line1 << endl;
			line2 = line2 + "\n" + line1;
		}
		ifile.close();
		cout << "将int改为float后：" << endl;
		string::size_type pos = line2.find("int", 0);
		while (pos != line2.npos)
		{
			line2.replace(pos, 3, "float");
			fstream ofile;
			ofile.open("out.txt");
			if (ofile.is_open())
			{
				ofile << line2;
			}
			ofile.close();
			pos = line2.find("int", 0);
		}
		cout << line2 << endl;
	}
}
