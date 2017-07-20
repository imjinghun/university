#include<iostream>
using namespace std;

void quicksort(int a[], int low, int high,int num)
{
	if (low >= high)
		return;
	int first = low;
	int last = high;
	int key = a[first];
	while (first<last)
	{
		while (first<last&&a[last]>=key) //从右向左找比key大的值
			--last;
		a[first] = a[last];
		while (first<last&&a[first] <= key)//从左向右找比key小的值
			++first;
		a[last] = a[first];
	}
	cout<<"枢轴为 "<<key<<" 排序结果为：";//输出每一次的结果
	for(int i=0;i<num;i++)
		cout<<a[i]<<" ";
	cout<<endl;
	a[first] = key;
	quicksort(a, low, first - 1,num);//递归调用
	quicksort(a, first + 1, high,num);
}
void quicksort2(int a[], int low, int high,int num)
{
	if (low >= high)
		return;
	int first = low;
	int last = high;
	int key = a[first];
	while (first<last)
	{
		while (first<last&&a[last]<=key) //从右向左找比key小的值
			--last;
		a[first] = a[last];
		while (first<last&&a[first] >= key)//从左向右找比key大的值
			++first;
		a[last] = a[first];
	}
	cout<<"枢轴为 "<<key<<" 排序结果为：";//输出每一次的结果
	for(int i=0;i<num;i++)
		cout<<a[i]<<" ";
	cout<<endl;
	a[first] = key;
	quicksort2(a, low, first - 1,num);//递归调用
	quicksort2(a, first + 1, high,num);
}

void main()
{
	int num,i,a[100];

	cout<<"输入排序个数"<<endl;
	cin>>num;
	cout<<"输入要排序的数"<<endl;
	for(i=0;i<num;i++)
		cin>>a[i];
	int choice=1;
	while(choice)
	{
		cout<<"选择排序方式 1 从小到大 2从大到小 0 退出"<<endl;
		cin>>choice;
		if(choice==1)
			quicksort(a,0,num-1,num);
		else if(choice==2)
			quicksort2(a,0,num-1,num);
		else if(choice==0)
			break;
		else
			cout<<"输入错误"<<endl;
	}
}