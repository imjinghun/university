#include<iostream>
#include<string>
using namespace std;

typedef struct//�߽ṹ��
{
    string v1;	//���������Ȩֵ
	string v2;
	int weight;   
}Edge;

int vexset[100];

int LocateVex(string a[],string b,int vexnum)//�õ������±�
{
    int i,k=0;
	for(i=0;i<vexnum;i++)
	{
		if(b==a[i])
	    {
		    k=i;
			break;
		}
	}
	return k;
}

void main()
{
	int vexnum,arcnum,i,j;//vexnum������ arcnum���� 
	Edge edge[100],t;
	string a[100];
	cout<<"���붥�����ͱ���"<<endl;
	cin>>vexnum>>arcnum;
	cout<<"���붥������"<<endl;
	for(i=0;i<vexnum;i++)
		cin>>a[i];
	cout<<"��������ߵ����������Ȩֵ"<<endl;
	for(i=0;i<arcnum;i++)
	{
		cin>>edge[i].v1>>edge[i].v2>>edge[i].weight;
	}
	//��Ȩֵ��С��������
	for(i=0;i<arcnum;i++)
		for(j=i+1;j<arcnum;j++)
			if(edge[i].weight>=edge[j].weight)
			{
				t=edge[i];
				edge[i]=edge[j];
				edge[j]=t;
			}
	for(i=0;i<vexnum;i++)//��ʼ����ͨ����
	{
		vexset[i]=i;
	}
	cout<<endl<<"��С����������ɱ߼�Ȩֵ"<<endl;
	for(i=0;i<vexnum;i++)
	{
		int v11,v22;//�����±�
		int s1,s2;//��ͨ����

		v11=LocateVex(a,edge[i].v1,vexnum);//�õ�����������±�
		v22=LocateVex(a,edge[i].v2,vexnum);

		s1=vexset[v11];//�õ������������ͨ����
		s2=vexset[v22];
		
		if(s1!=s2)//����������ͬ��ͨ����
		{
			cout<<edge[i].v1<<" "<<edge[i].v2<<" "<<edge[i].weight<<endl;
			for(j=0;j<vexnum;j++)
			 {
			     if(vexset[j]==s2)//����ͨ��������s2�ĸ�Ϊs1
				 {
				     vexset[j]=s1;
				 }
			}
		}
	}
	cout<<endl;
}