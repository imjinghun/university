#include"gauss.h"
void main()
{
	gauss jz0,jz1,jz2;;
	int r0,c0;
	cout<<"�������Է�����Ⱥ�ǰ��������"<<endl;
	cin>>r0>>c0;

	jz0.gethl(r0,c0);
	jz0.shenqing();
	jz0.input();

	cout<<"����Ⱥź������"<<endl;
	jz1.gethl(r0,1);
	jz1.shenqing();
	jz1.input();

	if(r0!=c0)
		cout<<"��һ����������Ĳ��Ƿ����޷�����"<<endl;
	else
		output(jz0,jz1);
}