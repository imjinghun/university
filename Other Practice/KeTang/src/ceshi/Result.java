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
	void init(int num)//��ʼ������
	{
		s=new String[num];
	}
	void first(int min,int max,int num,Result r)
	{
		for(i=0;i<(num/2);i++)//�ӷ�
		{
			j=0;
			boolean bool=true;
			s[i]=op.addition(min, max,r);
			//�ж��Ƿ��ظ�
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
				System.out.println("�� "+(i+1)+" ���������ȷ��Ϊ "+a);
			}
		}
		for(i=(num/2);i<num;i++)//����
		{
			j=num/2;
			boolean bool=true;
			s[i]=op.subtraction(min, max, r);
			//�ж��Ƿ��ظ�
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
				System.out.println("�� "+(i+1)+" ���������ȷ��Ϊ "+a);
			}
		}
	}
	void second(int min,int max,int num,Result r)
	{
		for(i=2*(num/3);i<num;i++)//�˷�
		{
			j=2*(num/3);
			boolean bool=true;
			s[i]=op.multiplication(min, max, r);
			//�ж��Ƿ��ظ�
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
				System.out.println("�� "+(i+1)+" ���������ȷ��Ϊ "+a);
			}
		}
	}
	void third(int min,int max,int num,Result r)//����������
	{
		for(i=2*(num/3);i<num;i++)//����
		{
			j=2*(num/3);
			boolean bool=true;
			s[i]=op.division(min, max, r);
			//�ж��Ƿ��ظ�
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
				System.out.println("�� "+(i+1)+" ���������ȷ��Ϊ "+a);
			}
		}
	}
	void third1(int min,int max,int num,Result r)//����������
	{
		for(i=2*(num/3);i<num;i++)//����
		{
			j=2*(num/3);
			boolean bool=true;
			s[i]=op.division1(min, max, r);
			//�ж��Ƿ��ظ�
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
				System.out.println("�� "+(i+1)+" ���������ȷ��Ϊ "+a);
			}
		}
	}
	
	void fourth(int min,int max,int num,Result r)//�������
	{
		for(i=0;i<num;i++)
		{
			j=0;
			boolean bool=true;
			s[i]=op.mixop(min, max, r);
			//�ж��Ƿ��ظ�
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
				System.out.println("�� "+(i+1)+" ���������ȷ��Ϊ "+a);
			}
		}
	}
}
