#pragma once

class fushu
{
	double real,image;
public:
	fushu(void);
	~fushu(void);
	fushu(double,double);
	friend fushu add(fushu,fushu);
	friend fushu jian(fushu,fushu);
	friend fushu cheng(fushu,fushu);
	friend fushu chu(fushu,fushu);
};
