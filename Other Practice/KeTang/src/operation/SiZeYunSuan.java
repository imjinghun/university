package operation;

import java.util.*;

public class SiZeYunSuan {

	void result()
	{
		Scanner sca=new Scanner(System.in);
		Operation op=new Operation();
		//ȷ����������
		System.out.println("����������� ");
		int num=sca.nextInt();
		while(num<=0)
		{
			System.out.println("���벻�Ϸ�����������");
			num=sca.nextInt();
		}
		String s[]=new String[num];
		//ȷ����ֵ��Χ
		System.out.println("��������������ͺ������ֵ��Χ(������Ϊ�����������ֵ������Сֵ)");
		int min,max;
		min=sca.nextInt();
		max=sca.nextInt();
		while((min<0)||(max<=min))
		{
			System.out.println("���벻�Ϸ�����������");
			min=sca.nextInt();
			max=sca.nextInt();
		}
		//ȷ���Ƿ�������
		System.out.println("����  (0)������  (1)������ ");
		int k=sca.nextInt();
		int i,j;
		//������
		if(k==0)
		{
			for(i=0;i<num;i++)
			{
				j=0;
				boolean bool=true;
				s[i]=op.bra(min, max);
				//�ж��Ƿ��ظ�
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
			//ȷ���Ƿ��г˳���
			int select;
			System.out.println("���Ӽ���֮�⣬ѡ�������Ƿ��г˳��� ");
			System.out.println("����  (0)�޳˳���(�Ӽ��޸���)  (1)�޳˳���(�Ӽ��и���)  "
					+"\n"+"(2)ֻ�г˷�  (3)ֻ�г���(������)  (4)ֻ�г���(������)  (5)������� ");
			select=sca.nextInt();
			if(select==0)
			{
				for(i=0;i<(num/2);i++)
				{
					j=0;
					boolean bool=true;
					s[i]=op.addition(min, max);
					//�ж��Ƿ��ظ�
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
					//�ж��Ƿ��ظ�
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
					//�ж��Ƿ��ظ�
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
					//�ж��Ƿ��ظ�
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
					//�ж��Ƿ��ظ�
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
					//�ж��Ƿ��ظ�
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
					//�ж��Ƿ��ظ�
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
					//�ж��Ƿ��ظ�
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
					//�ж��Ƿ��ظ�
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
					//�ж��Ƿ��ظ�
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
					//�ж��Ƿ��ظ�
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
					//�ж��Ƿ��ظ�
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
					//�ж��Ƿ��ظ�
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
					//�ж��Ƿ��ظ�
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
				System.out.println("�������");
			}
		}
		else
		{
			System.out.println("���벻�Ϸ�");
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
			System.out.println("���벻�Ϸ���������ִ�У�����Ҫ������");
		}
	}

}
