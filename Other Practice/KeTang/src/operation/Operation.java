package operation;

class Operation {
	Random1 ran1=new Random1();
	
	String bra(int min,int max)//������
	{
		String str="";
		int a[];
		a=new int[10];
		int d=ran1.setRandom0(8)+3;//��ʽ�����ĸ���
		for(int i=0;i<d;i++)
		{
			int c1=ran1.setRandom0(4);//ȷ���������
			a[i]=ran1.setRandom(min,max);//ȷ���μ��������
				
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
				str+="��";
			}
			if(i==d-1)
			{
				str+="=";
			}
		}
		return str;
	}
				
	String mixop(int min,int max)//�������
	{
		String str="";
		int a[];
		a=new int[10];
		int d=ran1.setRandom0(8)+3;//��ʽ�����ĸ���
		for(int i=0;i<d;i++)
		{
			int c1=ran1.setRandom0(4);//ȷ���������
			a[i]=ran1.setRandom(min,max);//ȷ���μ��������
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
				str+="��";
			}
			if(i==d-1)
			{
				str+="=";
			}
		}
		return str;
	}
	
String addition(int min,int max)//�ӷ�
	{
		String str="";
		int a[],c,i;
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
		}
		return str;
	}
	
	String subtraction(int min,int max)//�����޸���
	{
		String str="";
		int a[],c,i,re=0;//a[]�������ŵ�����  
		c=ran1.setRandom(2, 4);//��������ĸ���������2�������4��
		a=new int[c];
		for(i=0;i<c;i++)
		{
			a[i]=ran1.setRandom(min,max);
			if(i>0)
				re+=a[i];
		}
		while(a[0]<re)//�����ֵ������ֵ�ĺ�Сʱ���������c����
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
	String subtraction1(int min,int max)//�����и���
	{
		String str="";
		int a[],c,i,re=0;//a[]�������ŵ�����  
		c=ran1.setRandom(2, 4);//��������ĸ���������2�������4��
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
	
	String multiplication(int min,int max)//�˷�
	{
		String str="";
		int a[],c,i;
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
		}
		return str;
	}
	
	String division(int min,int max)//����������
	{
		String str="";
		int a[],c,i,re=1;
		c=ran1.setRandom(2, 4);//��������ĸ���������2�������4��
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
				str+=a[i]+" �� ";
			}
			else
			{
				str+=a[i]+" =";
			}
		}
		return str;
	}

	String division1(int min,int max)//����������
	{
		String str="";
		int a[],c,i;
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
		return str;
	}
}
