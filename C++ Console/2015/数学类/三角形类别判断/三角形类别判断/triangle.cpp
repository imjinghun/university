#include "triangle.h"
void triangle::biann(double b[])
{
	int i;
	for(i=0;i<3;i++)
		bian[i]=b[i];
}
void triangle::pan()
{
	bool f;
	if(bian[0]+bian[1]>bian[2]&&bian[0]-bian[1]<bian[2])
		f=1;
	else 
		f=0;
	if(f==1)
	{
		if(bian[1]==bian[2]||bian[1]==bian[0]||bian[0]==bian[2])
		{
			if(bian[1]==bian[2]==bian[0])
				cout<<"������Ϊ�ȱ�������"<<endl;
			else if(sqrt(bian[1]*bian[1]+bian[2]*bian[2])==bian[0]||sqrt(bian[0]*bian[0]+bian[2]*bian[2])==bian[1]||sqrt(bian[1]*bian[1]+bian[0]*bian[0])==bian[2])
				cout<<"������Ϊ����ֱ��������"<<endl;
			else
				cout<<"������Ϊ����������"<<endl;
		}
		else if(sqrt(bian[1]*bian[1]+bian[2]*bian[2])==bian[0]||sqrt(bian[0]*bian[0]+bian[2]*bian[2])==bian[1]||sqrt(bian[1]*bian[1]+bian[0]*bian[0])==bian[2])
			cout<<"������Ϊֱ��������"<<endl;
		else
			cout<<"������Ϊ��ͨ������"<<endl;
	}
	else
		cout<<"������������"<<endl;
}
triangle::triangle(void)
{
}
triangle::~triangle(void)
{
}
