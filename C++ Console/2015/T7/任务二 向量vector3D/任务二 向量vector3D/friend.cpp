#include"vector.h"
istream&operator>>(istream&input,vector&D)
{
	input>>D.x>>D.y>>D.z;
	return input;
}
ostream&operator<<(ostream&output,vector&D)
{
	output<<"("<<D.x<<","<<D.y<<","<<D.z<<")";
	return output;
}
vector operator+(vector A,vector B)
{
	vector C;
	C.x=A.x+B.x;
	C.y=A.y+B.y;
	C.z=A.z+B.z;
	return C;
}
vector operator-(vector A,vector B)
{
	vector C;
	C.x=A.x-B.x;
	C.y=A.y-B.y;
	C.z=A.z-B.z;
	return C;
}
double operator*(vector A,vector B)
{
	double C;
	C=A.x*B.x+A.y*B.y+A.z*B.z;
	
	return C;
}