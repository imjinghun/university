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
		while (first<last&&a[last]>=key) //���������ұ�key���ֵ
			--last;
		a[first] = a[last];
		while (first<last&&a[first] <= key)//���������ұ�keyС��ֵ
			++first;
		a[last] = a[first];
	}
	cout<<"����Ϊ "<<key<<" ������Ϊ��";//���ÿһ�εĽ��
	for(int i=0;i<num;i++)
		cout<<a[i]<<" ";
	cout<<endl;
	a[first] = key;
	quicksort(a, low, first - 1,num);//�ݹ����
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
		while (first<last&&a[last]<=key) //���������ұ�keyС��ֵ
			--last;
		a[first] = a[last];
		while (first<last&&a[first] >= key)//���������ұ�key���ֵ
			++first;
		a[last] = a[first];
	}
	cout<<"����Ϊ "<<key<<" ������Ϊ��";//���ÿһ�εĽ��
	for(int i=0;i<num;i++)
		cout<<a[i]<<" ";
	cout<<endl;
	a[first] = key;
	quicksort2(a, low, first - 1,num);//�ݹ����
	quicksort2(a, first + 1, high,num);
}

void main()
{
	int num,i,a[100];

	cout<<"�����������"<<endl;
	cin>>num;
	cout<<"����Ҫ�������"<<endl;
	for(i=0;i<num;i++)
		cin>>a[i];
	int choice=1;
	while(choice)
	{
		cout<<"ѡ������ʽ 1 ��С���� 2�Ӵ�С 0 �˳�"<<endl;
		cin>>choice;
		if(choice==1)
			quicksort(a,0,num-1,num);
		else if(choice==2)
			quicksort2(a,0,num-1,num);
		else if(choice==0)
			break;
		else
			cout<<"�������"<<endl;
	}
}