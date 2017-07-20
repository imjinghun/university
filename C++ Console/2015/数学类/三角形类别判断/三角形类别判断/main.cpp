#include"point.h"
#include"triangle.h"
void main()
{
	point a[3],p;
	triangle t;
	int i;
	double b[3];
	cout<<"输入三角形三个点坐标"<<endl;
	for(i=0;i<3;i++)
		cin>>a[i];
	b[0]=p.juli(a[0],a[1]);
	b[1]=p.juli(a[0],a[2]);
	b[2]=p.juli(a[1],a[2]);
	t.biann(b);
	t.pan();
}