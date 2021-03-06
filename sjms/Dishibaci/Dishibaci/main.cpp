#include<iostream>
#include<string>
#include<vector>
#include<algorithm>
#include<functional>
using namespace std;

class Student
{
public:string ID;
	   string Name;
	   int Age;
public:Student(string id, string name, int age)
{
		   ID = id;
		   Name = name;
		   Age = age;
}
};

vector<Student> Sort(vector<Student> V, bool flag)
{
	vector<string> ID = vector<string>();
	for (vector<Student>::iterator iter = V.begin(); iter != V.end(); iter++)
	{
		ID.push_back(iter->ID);
	}
	if (flag)
	{
		sort(ID.begin(), ID.end(), less<string>());
	}
	else
	{
		sort(ID.begin(), ID.end(), greater<string>());
	}
	vector<Student> ReturnV = vector<Student>();
	for (vector<string>::iterator iter = ID.begin(); iter != ID.end(); iter++)
	{
		for (vector<Student>::iterator iter1 = V.begin(); iter1 != V.end(); iter1++)
		{
			if (*iter == iter1->ID)
			{
				ReturnV.push_back(Student(iter1->ID, iter1->Name, iter1->Age));
			}
		}
	}
	return ReturnV;
}

void main()
{
	vector<Student> V = vector<Student>();

	V.push_back(Student("20142803", "张三", 22));
	V.push_back(Student("20142802", "李四", 20));
	V.push_back(Student("20142801", "王五", 21));
	V.push_back(Student("20142804", "赵六", 21));

	cout << "原排列：" << endl;
	for (vector<Student>::iterator iter = V.begin(); iter != V.end(); iter++)
	{
		cout << iter->Name << " " << iter->ID << "  " << iter->Age << endl;
	}

	cout <<endl<< "按学号升序排列：" << endl;
	V = Sort(V, true);
	for (vector<Student>::iterator iter = V.begin(); iter != V.end(); iter++)
	{
		cout << iter->Name << " " << iter->ID << "  " << iter->Age << endl;
	}
	cout << endl << "按学号降序排列" << endl;
	V = Sort(V, false);
	for (vector<Student>::iterator iter = V.begin(); iter != V.end(); iter++)
	{
		cout << iter->Name << " " << iter->ID << "  " << iter->Age << endl;
	}
}