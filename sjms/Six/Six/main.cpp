#include "vector.h"
#include <iostream>
using namespace std;
int main(int argc, char* argv[]){
	
	int n;
	cout << "输入数组长度" << endl;
	cin >> n;

	Vector* p = new ConcreteVector(n);
	Vector* p1 = p->Clone();

	cout << "Before:" << endl;
	cout << "p:";
	p->showData();
	cout << endl;
	cout << "p1:";
	p1->showData();
	cout << endl;

	p1->addOne();


	cout << "After:" << endl;
	cout << "p:";
	p->showData();
	cout << endl;
	cout << "p1:";
	p1->showData();
	cout << endl;

	return 0;
}