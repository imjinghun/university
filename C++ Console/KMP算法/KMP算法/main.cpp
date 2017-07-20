#include<iostream>
#include<string>
using namespace std;

void getNext(const char P[],int next[])
{
    int q,k;//q:�Ӵ��±ꣻk:���ǰ��׺����
    int m = strlen(P);//�Ӵ�����
    next[0] = 0;
    for (q = 1,k = 0; q < m; ++q)//�ӵڶ����ַ���ʼ�����μ���ÿһ���ַ���Ӧ��nextֵ
    {
        while(k > 0 && P[q] != P[k])//���P[0]������P[q]��������ͬ��ǰ��׺����k
            k = next[k-1];          
        if (P[q] == P[k])//�����ȣ���ô�����ͬǰ��׺���ȼ�1
        {
            k++;
        }
        next[q] = k;
    }
}

void kmp(const char T[],const char P[],int next[])
{
    int n,m;
    int i,q;
    n = strlen(T);//�õ�����
    m = strlen(P);
    getNext(P,next);
	cout<<endl<<"nextֵ��";
	for(i=0;i<m;i++)
	{
		cout<<next[i]<<" ";
	}
	cout<<endl<<endl<<"ƥ��ɹ�λ�ã�";
    for (i = 0,q = 0; i < n; ++i)
    {
        while(q > 0 && P[q] != T[i])//����ȣ���q����nextֵ
            q = next[q-1];
        if (P[q] == T[i])//���һλ��1
        {
            q++;
        }
        if (q == m)//q���Ӵ�������ȣ����ҵ�ƥ��λ��
        {
			cout<<i-m+1<<" ";
        }
    }
	cout<<endl<<endl;
}

void main()
{
	string t,p;
	char T[100],P[100];
	int next[100];

	cout<<"��������"<<endl;
	cin>>t;
	cout<<"�����Ӵ�"<<endl;
	cin>>p;
	strcpy(T,t.c_str());//���ַ���ת��Ϊ�ַ�����
	strcpy(P,p.c_str());
	kmp(T,P,next);
}