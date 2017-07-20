#pragma once
#include"animal.h"
class cat:public animal
{
public:
	cat(void);
	cat(string ani)
	{this->ani=ani;}
	~cat(void);
	void speak();
};
