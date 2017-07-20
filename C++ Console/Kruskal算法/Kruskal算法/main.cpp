#include<iostream>
#include<string>
using namespace std;

typedef struct//边结构体
{
    string v1;	//两个顶点和权值
	string v2;
	int weight;   
}Edge;

int vexset[100];

int LocateVex(string a[],string b,int vexnum)//得到顶点下标
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
	int vexnum,arcnum,i,j;//vexnum顶点数 arcnum边数 
	Edge edge[100],t;
	string a[100];
	cout<<"输入顶点数和边数"<<endl;
	cin>>vexnum>>arcnum;
	cout<<"输入顶点名称"<<endl;
	for(i=0;i<vexnum;i++)
		cin>>a[i];
	cout<<"依次输入边的两个顶点和权值"<<endl;
	for(i=0;i<arcnum;i++)
	{
		cin>>edge[i].v1>>edge[i].v2>>edge[i].weight;
	}
	//将权值由小到大排序
	for(i=0;i<arcnum;i++)
		for(j=i+1;j<arcnum;j++)
			if(edge[i].weight>=edge[j].weight)
			{
				t=edge[i];
				edge[i]=edge[j];
				edge[j]=t;
			}
	for(i=0;i<vexnum;i++)//初始化连通分量
	{
		vexset[i]=i;
	}
	cout<<endl<<"最小生成树的组成边及权值"<<endl;
	for(i=0;i<vexnum;i++)
	{
		int v11,v22;//顶点下标
		int s1,s2;//连通分量

		v11=LocateVex(a,edge[i].v1,vexnum);//得到两个顶点的下标
		v22=LocateVex(a,edge[i].v2,vexnum);

		s1=vexset[v11];//得到两个顶点的连通分量
		s2=vexset[v22];
		
		if(s1!=s2)//所属两个不同连通分量
		{
			cout<<edge[i].v1<<" "<<edge[i].v2<<" "<<edge[i].weight<<endl;
			for(j=0;j<vexnum;j++)
			 {
			     if(vexset[j]==s2)//将连通分量等于s2的改为s1
				 {
				     vexset[j]=s1;
				 }
			}
		}
	}
	cout<<endl;
}