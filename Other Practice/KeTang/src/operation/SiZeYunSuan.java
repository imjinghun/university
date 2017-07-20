package operation;

import java.util.*;

public class SiZeYunSuan {

	void result()
	{
		Scanner sca=new Scanner(System.in);
		Operation op=new Operation();
		//确定出题数量
		System.out.println("输入出题数量 ");
		int num=sca.nextInt();
		while(num<=0)
		{
			System.out.println("输入不合法，重新输入");
			num=sca.nextInt();
		}
		String s[]=new String[num];
		//确定数值范围
		System.out.println("输入进行运算的最低和最高数值范围(整数不为负数，且最大值大于最小值)");
		int min,max;
		min=sca.nextInt();
		max=sca.nextInt();
		while((min<0)||(max<=min))
		{
			System.out.println("输入不合法，重新输入");
			min=sca.nextInt();
			max=sca.nextInt();
		}
		//确定是否有括号
		System.out.println("输入  (0)有括号  (1)无括号 ");
		int k=sca.nextInt();
		int i,j;
		//有括号
		if(k==0)
		{
			for(i=0;i<num;i++)
			{
				j=0;
				boolean bool=true;
				s[i]=op.bra(min, max);
				//判断是否重复
				while(bool&&(i!=0))
				{
					while(s[i].equals(s[j]))
					{
						s[i]=op.bra(min, max);
						j=0;
					}
					j++;
					if(j==i)
					{
						bool=false;
					}
				}
				System.out.println("("+(i+1)+") "+s[i]);
			}
		}
		else if(k==1)
		{
			//确定是否有乘除法
			int select;
			System.out.println("除加减法之外，选择运算是否有乘除法 ");
			System.out.println("输入  (0)无乘除法(加减无负数)  (1)无乘除法(加减有负数)  "
					+"\n"+"(2)只有乘法  (3)只有除法(无余数)  (4)只有除法(有余数)  (5)混合运算 ");
			select=sca.nextInt();
			if(select==0)
			{
				for(i=0;i<(num/2);i++)
				{
					j=0;
					boolean bool=true;
					s[i]=op.addition(min, max);
					//判断是否重复
					while(bool&&(i!=0))
					{
						while(s[i].equals(s[j]))
						{
							s[i]=op.addition(min, max);
							j=0;
						}
						j++;
						if(j==i)
						{
							bool=false;
						}
					}
					System.out.println("("+(i+1)+") "+s[i]);
				}
				for(i=(num/2);i<num;i++)
				{
					j=num/2;
					boolean bool=true;
					s[i]=op.subtraction(min, max);
					//判断是否重复
					while(bool&&(i!=num/2))
					{
						while(s[i].equals(s[j]))
						{
							s[i]=op.subtraction(min, max);
							j=num/2;
						}
						j++;
						if(j==i)
						{
							bool=false;
						}
					}
					System.out.println("("+(i+1)+") "+s[i]);
				}
			}
			else if(select==1)
			{
				for(i=0;i<(num/2);i++)
				{
					j=0;
					boolean bool=true;
					s[i]=op.addition(min, max);
					//判断是否重复
					while(bool&&(i!=0))
					{
						while(s[i].equals(s[j]))
						{
							s[i]=op.addition(min, max);
							j=0;
						}
						j++;
						if(j==i)
						{
							bool=false;
						}
					}
					System.out.println("("+(i+1)+") "+s[i]);
				}
				for(i=(num/2);i<num;i++)
				{
					j=num/2;
					boolean bool=true;
					s[i]=op.subtraction1(min, max);
					//判断是否重复
					while(bool&&(i!=num/2))
					{
						while(s[i].equals(s[j]))
						{
							s[i]=op.subtraction1(min, max);
							j=num/2;
						}
						j++;
						if(j==i)
						{
							bool=false;
						}
					}
					System.out.println("("+(i+1)+") "+s[i]);
				}
			}
			else if(select==2)
			{
				for(i=0;i<(num/3);i++)
				{
					j=0;
					boolean bool=true;
					s[i]=op.addition(min, max);
					//判断是否重复
					while(bool&&(i!=0))
					{
						while(s[i].equals(s[j]))
						{
							s[i]=op.addition(min, max);
							j=0;
						}
						j++;
						if(j==i)
						{
							bool=false;
						}
					}
					System.out.println("("+(i+1)+") "+s[i]);
				}
				for(i=num/3;i<(2*(num/3));i++)
				{
					j=num/3;
					boolean bool=true;
					s[i]=op.subtraction(min, max);
					//判断是否重复
					while(bool&&(i!=num/3))
					{
						while(s[i].equals(s[j]))
						{
							s[i]=op.subtraction(min, max);
							j=num/3;
						}
						j++;
						if(j==i)
						{
							bool=false;
						}
					}
					System.out.println("("+(i+1)+") "+s[i]);
				}
				for(i=(2*(num/3));i<num;i++)
				{
					j=(2*(num/3));
					boolean bool=true;
					s[i]=op.multiplication(min, max);
					//判断是否重复
					while(bool&&(i!=(2*(num/3))))
					{
						while(s[i].equals(s[j]))
						{
							s[i]=op.multiplication(min, max);
							j=(2*(num/3));
						}
						j++;
						if(j==i)
						{
							bool=false;
						}
					}
					System.out.println("("+(i+1)+") "+s[i]);
				}
			}
			else if(select==3)
			{
				for(i=0;i<(num/3);i++)
				{
					j=0;
					boolean bool=true;
					s[i]=op.addition(min, max);
					//判断是否重复
					while(bool&&(i!=0))
					{
						while(s[i].equals(s[j]))
						{
							s[i]=op.addition(min, max);
							j=0;
						}
						j++;
						if(j==i)
						{
							bool=false;
						}
					}
					System.out.println("("+(i+1)+") "+s[i]);
				}
				for(i=num/3;i<(2*(num/3));i++)
				{
					j=num/3;
					boolean bool=true;
					s[i]=op.subtraction(min, max);
					//判断是否重复
					while(bool&&(i!=num/3))
					{
						while(s[i].equals(s[j]))
						{
							s[i]=op.subtraction(min, max);
							j=num/3;
						}
						j++;
						if(j==i)
						{
							bool=false;
						}
					}
					System.out.println("("+(i+1)+") "+s[i]);
				}
				for(i=(2*(num/3));i<num;i++)
				{
					j=(2*(num/3));
					boolean bool=true;
					s[i]=op.division(min, max);
					//判断是否重复
					while(bool&&(i!=(2*(num/3))))
					{
						while(s[i].equals(s[j]))
						{
							s[i]=op.division(min, max);
							j=(2*(num/3));
						}
						j++;
						if(j==i)
						{
							bool=false;
						}
					}
					System.out.println("("+(i+1)+") "+s[i]);
				}
			}
			else if(select==4)
			{
				for(i=0;i<(num/3);i++)
				{
					j=0;
					boolean bool=true;
					s[i]=op.addition(min, max);
					//判断是否重复
					while(bool&&(i!=0))
					{
						while(s[i].equals(s[j]))
						{
							s[i]=op.addition(min, max);
							j=0;
						}
						j++;
						if(j==i)
						{
							bool=false;
						}
					}
					System.out.println("("+(i+1)+") "+s[i]);
				}
				for(i=num/3;i<(2*(num/3));i++)
				{
					j=num/3;
					boolean bool=true;
					s[i]=op.subtraction(min, max);
					//判断是否重复
					while(bool&&(i!=num/3))
					{
						while(s[i].equals(s[j]))
						{
							s[i]=op.subtraction(min, max);
							j=num/3;
						}
						j++;
						if(j==i)
						{
							bool=false;
						}
					}
					System.out.println("("+(i+1)+") "+s[i]);
				}
				for(i=(2*(num/3));i<num;i++)
				{
					j=(2*(num/3));
					boolean bool=true;
					s[i]=op.division1(min, max);
					//判断是否重复
					while(bool&&(i!=(2*(num/3))))
					{
						while(s[i].equals(s[j]))
						{
							s[i]=op.division1(min, max);
							j=(2*(num/3));
						}
						j++;
						if(j==i)
						{
							bool=false;
						}
					}
					System.out.println("("+(i+1)+") "+s[i]);
				}
			}
			else if(select==5)
			{
				for(i=0;i<num;i++)
				{
					j=0;
					boolean bool=true;
					s[i]=op.mixop(min, max);
					//判断是否重复
					while(bool&&(i!=0))
					{
						while(s[i].equals(s[j]))
						{
							s[i]=op.mixop(min, max);
							j=0;
						}
						j++;
						if(j==i)
						{
							bool=false;
						}
					}
					System.out.println("("+(i+1)+") "+s[i]);
				}
			}
			else
			{
				System.out.println("输入错误");
			}
		}
		else
		{
			System.out.println("输入不合法");
		}
	}
	public static void main(String[] args) {
		try
		{
			SiZeYunSuan s=new SiZeYunSuan();
			s.result();
		}
		catch(Exception e)
		{
			System.out.println("输入不合法，请重新执行，按照要求输入");
		}
	}

}
