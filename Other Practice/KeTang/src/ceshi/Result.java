package ceshi;

import java.util.Scanner;

class Result {
	
	static int right;
	int i,j;
	String r1,a,b,s[];
	Scanner sca=new Scanner(System.in);
	Operation op=new Operation();
	Result()
	{
		right=0;
	}
	void init(int num)//初始化数组
	{
		s=new String[num];
	}
	void first(int min,int max,int num,Result r)
	{
		for(i=0;i<(num/2);i++)//加法
		{
			j=0;
			boolean bool=true;
			s[i]=op.addition(min, max,r);
			//判断是否重复
			while(bool&&(i!=0))
			{
				while(s[i].equals(s[j]))
				{
					s[i]=op.addition(min, max,r);
					j=0;
				}
				j++;
				if(j==i)
				{
					bool=false;
				}
			}
			a=r.r1;
			System.out.println("("+(i+1)+") "+s[i]);
			b=sca.nextLine();
			if(a.equals(b))
			{
				right++;
			}
			else
			{
				System.out.println("第 "+(i+1)+" 道题算错，正确答案为 "+a);
			}
		}
		for(i=(num/2);i<num;i++)//减法
		{
			j=num/2;
			boolean bool=true;
			s[i]=op.subtraction(min, max, r);
			//判断是否重复
			while(bool&&(i!=num/2))
			{
				while(s[i].equals(s[j]))
				{
					s[i]=op.subtraction(min, max,r);
					j=num/2;
				}
				j++;
				if(j==i)
				{
					bool=false;
				}
			}
			a=r.r1;
			System.out.println("("+(i+1)+") "+s[i]);
			b=sca.nextLine();
			if(a.equals(b))
			{
				right++;
			}
			else
			{
				System.out.println("第 "+(i+1)+" 道题算错，正确答案为 "+a);
			}
		}
	}
	void second(int min,int max,int num,Result r)
	{
		for(i=2*(num/3);i<num;i++)//乘法
		{
			j=2*(num/3);
			boolean bool=true;
			s[i]=op.multiplication(min, max, r);
			//判断是否重复
			while(bool&&(i!=2*(num/3)))
			{
				while(s[i].equals(s[j]))
				{
					s[i]=op.multiplication(min, max, r);
					j=2*num/3;
				}
				j++;
				if(j==i)
				{
					bool=false;
				}
			}
			a=r.r1;
			System.out.println("("+(i+1)+") "+s[i]);
			b=sca.nextLine();
			if(a.equals(b))
			{
				right++;
			}
			else
			{
				System.out.println("第 "+(i+1)+" 道题算错，正确答案为 "+a);
			}
		}
	}
	void third(int min,int max,int num,Result r)//除法无余数
	{
		for(i=2*(num/3);i<num;i++)//除法
		{
			j=2*(num/3);
			boolean bool=true;
			s[i]=op.division(min, max, r);
			//判断是否重复
			while(bool&&(i!=2*(num/3)))
			{
				while(s[i].equals(s[j]))
				{
					s[i]=op.division(min, max, r);
					j=2*num/3;
				}
				j++;
				if(j==i)
				{
					bool=false;
				}
			}
			a=r.r1;
			System.out.println("("+(i+1)+") "+s[i]);
			b=sca.nextLine();
			if(a.equals(b))
			{
				right++;
			}
			else
			{
				System.out.println("第 "+(i+1)+" 道题算错，正确答案为 "+a);
			}
		}
	}
	void third1(int min,int max,int num,Result r)//除法有余数
	{
		for(i=2*(num/3);i<num;i++)//除法
		{
			j=2*(num/3);
			boolean bool=true;
			s[i]=op.division1(min, max, r);
			//判断是否重复
			while(bool&&(i!=2*(num/3)))
			{
				while(s[i].equals(s[j]))
				{
					s[i]=op.division1(min, max, r);
					j=2*num/3;
				}
				j++;
				if(j==i)
				{
					bool=false;
				}
			}
			a=r.r1;
			System.out.println("("+(i+1)+") "+s[i]);
			b=sca.nextLine();
			if(a.equals(b))
			{
				right++;
			}
			else
			{
				System.out.println("第 "+(i+1)+" 道题算错，正确答案为 "+a);
			}
		}
	}
	
	void fourth(int min,int max,int num,Result r)//混合运算
	{
		for(i=0;i<num;i++)
		{
			j=0;
			boolean bool=true;
			s[i]=op.mixop(min, max, r);
			//判断是否重复
			while(bool&&(i!=0))
			{
				while(s[i].equals(s[j]))
				{
					s[i]=op.addition(min, max,r);
					j=0;
				}
				j++;
				if(j==i)
				{
					bool=false;
				}
			}
			a=r.r1;
			System.out.println("("+(i+1)+") "+s[i]);
			b=sca.nextLine();
			if(a.equals(b))
			{
				right++;
			}
			else
			{
				System.out.println("第 "+(i+1)+" 道题算错，正确答案为 "+a);
			}
		}
	}
}
