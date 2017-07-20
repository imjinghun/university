#include "sizeyunsuan.h"

void sizeyunsuan::addition(string a1,string b1)//加法
{
	str1=a1; str2=b1;
	int a,b,i;
	string str11[1000],str22[1000];

	a=str1.length();//计算输入的字符长度
	b=str2.length();

	if(a>b)	//在字符前面加上一个0，以防第一位相加时>10
	{
		str1.insert(0,"0");
		a=str1.length();
		int c=a-b;
		for(i=0;i<c;i++)
			str2.insert(0,"0");
		b=str2.length();
	}
	else if(a<b)
	{
		str2.insert(0,"0");
		b=str2.length();
		int c=b-a;
		for(i=0;i<c;i++)
			str1.insert(0,"0");
		a=str1.length();
	}
	else
	{
		str1.insert(0,"0");
		str2.insert(0,"0");
		a=str1.length();
		b=str2.length();
	}
	for(i=0;i<a;i++)//把输入的字符拆分
	{
		string s(str1,i,1);	
		str11[i]=s;
		string s1(str2,i,1);
		str22[i]=s1;
	}

	int t1[1000],t2[1000]; //把字符转换成整数
	for(i=0;i<a;i++)  
	{
		t1[i]=atoi(str11[i].c_str());
		t2[i]=atoi(str22[i].c_str());
	}
	string str33[1000];	//运算后把整型转换成字符型
	char ch[10];
	for(i=a-1;i>=0;i--)
	{
		int yu;
		if(t1[i]+t2[i]>=10)
		{
			yu=(t1[i]+t2[i])%10;
			itoa(yu,ch,10);
			str33[i]=ch;
			t2[i-1]++;
		}
		else
		{
			yu=t1[i]+t2[i];
			itoa(yu,ch,10);
			str33[i]=ch;
		}
	}
	string str4,str5;			//输出结果
	for(i=0;i<a;i++)
		str4+=str33[i];
	string s5(str4,0,1);       
	cout<<"加法结果为"<<endl;
	if(s5=="0")				//输出
	{
		for(i=1;i<a;i++)
			str5+=str33[i];
		cout<<str5<<endl;
	}
	else
		cout<<str4<<endl;
}
void sizeyunsuan::subtraction(string a1,string b1)//减法
{
	str1=a1; str2=b1;
	int a,b,i,aa,bb;
	string str11[1000],str22[1000];

	a=str1.length();//计算输入的字符长度
	b=str2.length();
	aa=a;
	bb=b;
	int t1[1000],t2[1000]; 
	string str33[1000];	//运算后把整型转换成字符型
	char ch[10];
    if(aa>bb)	//a大于b时
	{
		int c=a-b;
		for(i=0;i<c;i++)
			str2.insert(0,"0");
		b=str2.length();
		for(i=0;i<a;i++)//把输入的字符拆分
		{
			string s(str1,i,1);	
			str11[i]=s;
			string s1(str2,i,1);
			str22[i]=s1;
		}
		for(i=0;i<a;i++)  //把字符转换成整数
		{
			t1[i]=atoi(str11[i].c_str());
			t2[i]=atoi(str22[i].c_str());
		}
		for(i=a-1;i>=0;i--)
		{
			int yu;
			if(t1[i]<t2[i])
			{
				yu=t1[i]+10-t2[i];
				itoa(yu,ch,10);
				str33[i]=ch;
				t1[i-1]--;
			}
			else
			{
				yu=t1[i]-t2[i];
				itoa(yu,ch,10);
				str33[i]=ch;
			}
		}
		int m=0;
		string str4; 
		for(i=0;i<a;i++)
			str4+=str33[i];
		for(i=0;i<a;i++)//找到字符串第一个不为0的位置
		{
			string s5(str4,i,1);
			if(s5=="0")
				m++;
			else
				break;
		}
		if(m==a)	//输出		
			cout<<"0"<<endl;
		else
		{
			for(i=m;i<a;i++)
				cout<<str33[i];
			cout<<endl;
		}
	}
	 if(aa<bb)	//a小于b时
	{
		string sab;
		sab=str1;
		str1=str2;
		str2=sab;
		a=str1.length();//计算输入的字符长度
		b=str2.length();
		int c=a-b;
		for(i=0;i<c;i++)
			str2.insert(0,"0");
		b=str2.length();
		for(i=0;i<a;i++)//把输入的字符拆分
		{
			string s(str1,i,1);	
			str11[i]=s;
			string s1(str2,i,1);
			str22[i]=s1;
		}
		for(i=0;i<a;i++)  //把字符转换成整数
		{
			t1[i]=atoi(str11[i].c_str());
			t2[i]=atoi(str22[i].c_str());
		}
		for(i=a-1;i>=0;i--)
		{
			int yu;
			if(t1[i]<t2[i])
			{
				yu=t1[i]+10-t2[i];
				itoa(yu,ch,10);
				str33[i]=ch;
				t1[i-1]--;
			}
			else
			{
				yu=t1[i]-t2[i];
				itoa(yu,ch,10);
				str33[i]=ch;
			}
		}
		int m=0;
		string str4; 
		for(i=0;i<a;i++)
			str4+=str33[i];
		for(i=0;i<a;i++)//找到字符串第一个不为0的位置
		{
			string s5(str4,i,1);
			if(s5=="0")
				m++;
			else
				break;
		}
		if(m==a)	//输出		
			cout<<"0"<<endl;
		else
		{
			cout<<"-";
			for(i=m;i<a;i++)
				cout<<str33[i];
			cout<<endl;
		}
	}
	 if(aa==bb)	//a等于b时
	{
		for(i=0;i<a;i++)//把输入的字符拆分
		{
			string s(str1,i,1);	
			str11[i]=s;
			string s1(str2,i,1);
			str22[i]=s1;
		}
		bool f;
		for(i=0;i<a;i++)
		{
			if(str11[i]>str22[i])
			{
				f=true;
				break;
			}
			else
			{
				f=false;
				break;
			}
		}
		if(f==false)
		{
		string sab;
		sab=str1;
		str1=str2;
		str2=sab;
		a=str1.length();//计算输入的字符长度
		b=str2.length();
		int c=a-b;
		for(i=0;i<c;i++)
			str2.insert(0,"0");
		b=str2.length();
		for(i=0;i<a;i++)//把输入的字符拆分
		{
			string s(str1,i,1);	
			str11[i]=s;
			string s1(str2,i,1);
			str22[i]=s1;
		}
		for(i=0;i<a;i++)  //把字符转换成整数
		{
			t1[i]=atoi(str11[i].c_str());
			t2[i]=atoi(str22[i].c_str());
		}
		for(i=a-1;i>=0;i--)
		{
			int yu;
			if(t1[i]<t2[i])
			{
				yu=t1[i]+10-t2[i];
				itoa(yu,ch,10);
				str33[i]=ch;
				t1[i-1]--;
			}
			else
			{
				yu=t1[i]-t2[i];
				itoa(yu,ch,10);
				str33[i]=ch;
			}
		}
		int m=0;
		string str4; 
		for(i=0;i<a;i++)
			str4+=str33[i];
		for(i=0;i<a;i++)//找到字符串第一个不为0的位置
		{
			string s5(str4,i,1);
			if(s5=="0")
				m++;
			else
				break;
		}
		if(m==a)	//输出		
			cout<<"0"<<endl;
		else
		{
			cout<<"-";
			for(i=m;i<a;i++)
				cout<<str33[i];
			cout<<endl;
		}
		}
		if(f==true)
		{
		int c=a-b;
		for(i=0;i<c;i++)
			str2.insert(0,"0");
		b=str2.length();
		for(i=0;i<a;i++)//把输入的字符拆分
		{
			string s(str1,i,1);	
			str11[i]=s;
			string s1(str2,i,1);
			str22[i]=s1;
		}
		for(i=0;i<a;i++)  //把字符转换成整数
		{
			t1[i]=atoi(str11[i].c_str());
			t2[i]=atoi(str22[i].c_str());
		}
		for(i=a-1;i>=0;i--)
		{
			int yu;
			if(t1[i]<t2[i])
			{
				yu=t1[i]+10-t2[i];
				itoa(yu,ch,10);
				str33[i]=ch;
				t1[i-1]--;
			}
			else
			{
				yu=t1[i]-t2[i];
				itoa(yu,ch,10);
				str33[i]=ch;
			}
		}
		int m=0;
		string str4; 
		for(i=0;i<a;i++)
			str4+=str33[i];
		for(i=0;i<a;i++)		//找到字符串第一个不为0的位置
		{
			string s5(str4,i,1);
			if(s5=="0")
				m++;
			else
				break;
		}
		if(m==a)	//输出		
			cout<<"0"<<endl;
		else
		{
			for(i=m;i<a;i++)
				cout<<str33[i];
			cout<<endl;
		}
		}
	}
}
sizeyunsuan::sizeyunsuan(void)
{
}
sizeyunsuan::~sizeyunsuan(void)
{
}
