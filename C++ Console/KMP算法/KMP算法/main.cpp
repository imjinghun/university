#include<iostream>
#include<string>
using namespace std;

void getNext(const char P[],int next[])
{
    int q,k;//q:子串下标；k:最大前后缀长度
    int m = strlen(P);//子串长度
    next[0] = 0;
    for (q = 1,k = 0; q < m; ++q)//从第二个字符开始，依次计算每一个字符对应的next值
    {
        while(k > 0 && P[q] != P[k])//求出P[0]···P[q]的最大的相同的前后缀长度k
            k = next[k-1];          
        if (P[q] == P[k])//如果相等，那么最大相同前后缀长度加1
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
    n = strlen(T);//得到长度
    m = strlen(P);
    getNext(P,next);
	cout<<endl<<"next值：";
	for(i=0;i<m;i++)
	{
		cout<<next[i]<<" ";
	}
	cout<<endl<<endl<<"匹配成功位置：";
    for (i = 0,q = 0; i < n; ++i)
    {
        while(q > 0 && P[q] != T[i])//不相等，则q等于next值
            q = next[q-1];
        if (P[q] == T[i])//相等一位加1
        {
            q++;
        }
        if (q == m)//q和子串长度相等，则找到匹配位置
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

	cout<<"输入主串"<<endl;
	cin>>t;
	cout<<"输入子串"<<endl;
	cin>>p;
	strcpy(T,t.c_str());//将字符串转换为字符数组
	strcpy(P,p.c_str());
	kmp(T,P,next);
}