package ceshi;

import java.util.Arrays;
import java.util.Vector;

class Operation {
	Random1 ran1=new Random1();
	
    String addition(int min,int max,Result r)//�ӷ�
	{
		String str="";
		int a[],c,i,re=0;
		c=ran1.setRandom(2, 4);//�ӷ�����ĸ���������2�������4��
		a=new int[c];
		for(i=0;i<c;i++)
		{
			a[i]=ran1.setRandom(min,max);
			if(i<(c-1))
			{
				str+=a[i]+" + ";
			}
			else
			{
				str+=a[i]+" =";
			}
			re+=a[i];//���
		}
		r.r1=""+re;
		return str;
	}
	
	String subtraction(int min,int max,Result r)//�����޸���
	{
		String str="";
		int a[],c,i,re=0;//a[]�������ŵ�����  
		c=ran1.setRandom(2, 4);//��������ĸ���������2�������4��
		a=new int[c];
		for(i=0;i<c;i++)
		{
			a[i]=ran1.setRandom(min,max);
		}
		Arrays.sort(a);//�������������С��������
		for(i=0;i<c-1;i++)//�����ֵ�������ֵ���
		{
			re+=a[i];
		}
		while(a[c-1]<re)//�����ֵ������ֵ�ĺ�Сʱ���������c����
		{
			re=0;
			for(i=0;i<c;i++)
			{
				a[i]=ran1.setRandom(min,max);
			}
			Arrays.sort(a);//�������������С��������
			for(i=0;i<c-1;i++)//�����ֵ�������ֵ���
			{
				re+=a[i];
			}
		}
		for(i=c-1;i>=0;i--)
		{
			if(i>0)
			{
				str+=a[i]+" - ";
			}
			else
			{
				str+=a[i]+" =";
			}
		}
		r.r1=""+(a[c-1]-re);
		return str;
	}
	
	String multiplication(int min,int max,Result r)//�˷�
	{
		String str="";
		int a[],c,i,re=1;
		c=ran1.setRandom(2, 4);//�˷�����ĸ���������2�������4��
		a=new int[c];
		for(i=0;i<c;i++)
		{
			a[i]=ran1.setRandom(min,max);
			if(i<(c-1))
			{
				str+=a[i]+" x ";
			}
			else
			{
				str+=a[i]+" =";
			}
			re*=a[i];
		}
		r.r1=""+re;
		return str;
	}
	
	String division(int min,int max,Result r)//����������
	{
		String str="";
		int a[],c,i,re=1;
		c=ran1.setRandom(2, 4);//��������ĸ���������2�������4��
		a=new int[c];
		for(i=0;i<c;i++)
		{
			a[i]=ran1.setRandom(min,max);
		}
		Arrays.sort(a);
		for(i=0;i<c-1;i++)
		{
			re*=a[i];
		}
		while((re==0)||(a[c-1]%re!=0))
		{
			re=1;
			for(i=0;i<c;i++)
			{
				a[i]=ran1.setRandom(min,max);
			}
			Arrays.sort(a);
			for(i=0;i<c-1;i++)
			{
				re*=a[i];
			}
		}
		for(i=c-1;i>=0;i--)
		{
			if(i>0)
			{
				str+=a[i]+" �� ";
			}
			else
			{
				str+=a[i]+" =";
			}
		}
		r.r1=""+(a[c-1]/re);
		return str;
	}

	String division1(int min,int max,Result r)//����������
	{
		String str="";
		int a[],c,i,re=1;
		c=ran1.setRandom(2, 4);//��������ĸ���������2�������4��
		a=new int[c];
		for(i=0;i<c;i++)
		{
			a[i]=ran1.setRandom(min,max);
			while(a[i]==0)
			{
				a[i]=ran1.setRandom(min,max);
			}
		}
		for(i=1;i<c;i++)
		{
			re*=a[i];
		}
		for(i=0;i<c;i++)
		{
			if(i<(c-1))
			{
				str+=a[i]+" �� ";
			}
			else
			{
				str+=a[i]+" =";
			}
		}
		int m;//���Լ��
		if(a[0]<re)
		{
			m=a[0];
		}
		else
		{
			m=re;
		}
		for(i=m;i>0;i--)
		{
			if((a[0]%i==0)&&(re%i==0))
			{
				m=i;
				break;
			}
		}
		r.r1=(a[0]/m)+"/"+(re/m);
		if((a[0]/m)%(re/m)==0)
		{
			r.r1=""+((a[0]/m)/(re/m));
		}
		return str;
	}
	
	String mixop(int min,int max,Result r)//�������
	{
		Vector aa=new Vector();
		String a[]=new String[5],str="";
		int i,c;
		aa.add(ran1.setRandom(min, max));
		for(i=1;i<5;i++)
		{
			c=ran1.setRandom0(3);
			if(c==0)
			{
				aa.add(" + ");
				aa.add(ran1.setRandom(min, max));
			}
			if(c==1)
			{
				aa.add(" - ");
				aa.add(ran1.setRandom(min, max));
			}
			if(c==2)
			{
				aa.add(" x ");
				aa.add(ran1.setRandom(min, max));
			}
			if(c==3)
			{
				aa.add(" �� ");
				aa.add(ran1.setRandom(min, max));
			}
		}
		
		return str;
	}
}
