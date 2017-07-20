#include "vector.h"

//Prototype.cpp
#include "vector.h"
#include <iostream>
using namespace std;
Vector::Vector(){
}
Vector::~Vector(){
}
Vector* Vector::Clone() const{
	return 0;
}

ConcreteVector::ConcreteVector(int n){
	this->length = n;
	this->p = new int[length];
	for (int i = 0; i < length; i++)
		p[i] = i;
}
ConcreteVector::~ConcreteVector(){
	delete[] p;
}
ConcreteVector::ConcreteVector(const ConcreteVector& cp){

	cout << "ConcreteVector copy ..." << endl;
	/*//Ç³¸´ÖÆ
	this->length = cp.length;
	this->p = cp.p;*/

	//Éî¸´ÖÆ
	this->length = cp.length;
	this->p = new int[length];
	int i;
	for (i = 0; i < length; i++)
	this->p[i] = cp.p[i];
}
Vector* ConcreteVector::Clone() const{
	return new ConcreteVector(*this);
}

void ConcreteVector::showData()
{
	int i;
	for (i = 0; i < length; i++)
		cout << p[i] << " ";
}

void ConcreteVector::addOne()
{
	int i;
	for (i = 0; i < length; i++)
		p[i] += 10;
}