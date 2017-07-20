package operation;

class Operation {
	Random1 ran1=new Random1();
	
	String bra(int min,int max)//有括号
	{
		String str="";
		int a[];
		a=new int[10];
		int d=ran1.setRandom0(8)+3;//算式内数的个数
		for(int i=0;i<d;i++)
		{
			int c1=ran1.setRandom0(4);//确定运算符号
			a[i]=ran1.setRandom(min,max);//确定参加运算的数
				
			if(i==0)
			{
				str+="(";
			}
			str+=a[i];
			if(i==(d/2))
			{
				str+=")";
			}
			if(c1==0&&i!=d-1)
			{
				str+="+";
			}
			if(c1==1&&i!=d-1)
			{
				str+="-";
			}
			if(c1==2&&i!=d-1)
			{
				str+="x";
			}
			if(c1==3&&i!=d-1)
			{
				str+="÷";
			}
			if(i==d-1)
			{
				str+="=";
			}
		}
		return str;
	}
				
	String mixop(int min,int max)//混合运算
	{
		String str="";
		int a[];
		a=new int[10];
		int d=ran1.setRandom0(8)+3;//算式内数的个数
		for(int i=0;i<d;i++)
		{
			int c1=ran1.setRandom0(4);//确定运算符号
			a[i]=ran1.setRandom(min,max);//确定参加运算的数
			str+=a[i];
			if(c1==0&&i!=d-1)
			{
				str+="+";
			}
			if(c1==1&&i!=d-1)
			{
				str+="-";
			}
			if(c1==2&&i!=d-1)
			{
				str+="x";
			}
			if(c1==3&&i!=d-1)
			{
				str+="÷";
			}
			if(i==d-1)
			{
				str+="=";
			}
		}
		return str;
	}
	
String addition(int min,int max)//加法
	{
		String str="";
		int a[],c,i;
		c=ran1.setRandom(2, 4);//加法运算的个数，最少2个，最多4个
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
		}
		return str;
	}
	
	String subtraction(int min,int max)//减法无负数
	{
		String str="";
		int a[],c,i,re=0;//a[]随机数存放的数组  
		c=ran1.setRandom(2, 4);//减法运算的个数，最少2个，最多4个
		a=new int[c];
		for(i=0;i<c;i++)
		{
			a[i]=ran1.setRandom(min,max);
			if(i>0)
				re+=a[i];
		}
		while(a[0]<re)//当最大值比其他值的和小时，重新随机c个数
		{
			re=0;
			for(i=0;i<c;i++)
			{
				a[i]=ran1.setRandom(min,max);
				if(i>0)
				{
					re+=a[i];
				}
			}
		}
		for(i=0;i<c;i++)
		{
			if(i<c-1)
			{
				str+=a[i]+" - ";
			}
			else
			{
				str+=a[i]+" =";
			}
		}
		return str;
	}
	String subtraction1(int min,int max)//减法有负数
	{
		String str="";
		int a[],c,i,re=0;//a[]随机数存放的数组  
		c=ran1.setRandom(2, 4);//减法运算的个数，最少2个，最多4个
		a=new int[c];
		for(i=0;i<c;i++)
		{
			a[i]=ran1.setRandom(min,max);
		}
		for(i=0;i<c;i++)
		{
			if(i<c-1)
			{
				str+=a[i]+" - ";
			}
			else
			{
				str+=a[i]+" =";
			}
		}
		return str;
	}
	
	String multiplication(int min,int max)//乘法
	{
		String str="";
		int a[],c,i;
		c=ran1.setRandom(2, 4);//乘法运算的个数，最少2个，最多4个
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
		}
		return str;
	}
	
	String division(int min,int max)//除法无余数
	{
		String str="";
		int a[],c,i,re=1;
		c=ran1.setRandom(2, 4);//除法运算的个数，最少2个，最多4个
		a=new int[c];
		for(i=0;i<c;i++)
		{
			a[i]=ran1.setRandom(min,max);
			if(i>0)
			{
				re*=a[i];
			}
		}
		while((re==0)||(a[0]%re!=0))
		{
			re=1;
			for(i=0;i<c;i++)
			{
				a[i]=ran1.setRandom(min,max);
				if(i>0)
				{
					re*=a[i];
				}
			}
		}
		for(i=c-1;i>=0;i--)
		{
			if(i>0)
			{
				str+=a[i]+" ÷ ";
			}
			else
			{
				str+=a[i]+" =";
			}
		}
		return str;
	}

	String division1(int min,int max)//除法有余数
	{
		String str="";
		int a[],c,i;
		c=ran1.setRandom(2, 4);//除法运算的个数，最少2个，最多4个
		a=new int[c];
		for(i=0;i<c;i++)
		{
			a[i]=ran1.setRandom(min,max);
			while(a[i]==0)
			{
				a[i]=ran1.setRandom(min,max);
			}
		}
		for(i=0;i<c;i++)
		{
			if(i<(c-1))
			{
				str+=a[i]+" ÷ ";
			}
			else
			{
				str+=a[i]+" =";
			}
		}
		return str;
	}
}
