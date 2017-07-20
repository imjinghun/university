#pragma once
#include"animal.h"
class leopard:public animal
{
public:
	leopard(void);
	leopard(string ani)
	{
		this->ani=ani;
	}
	~leopard(void);
	void speak();
};
