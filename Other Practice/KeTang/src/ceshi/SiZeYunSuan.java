package ceshi;

import java.util.*;

public class SiZeYunSuan {

	void result()
	{
		Scanner sca=new Scanner(System.in);
		Operation op=new Operation();
		Result r=new Result();
		//ȷ����������
		System.out.println("����������� ");
		int num=sca.nextInt();
		while(num<=0)
		{
			System.out.println("���벻�Ϸ�����������");
			num=sca.nextInt();
		}
		r.init(num);
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
		//ȷ���Ƿ��г˳���
		int select;
		System.out.println("���Ӽ���֮�⣬ѡ�������Ƿ��г˳��� ");
		System.out.println("����  (0)�޳˳���  (1)ֻ�г˷�  (2)ֻ�г���(������)  (3)ֻ�г���(������)  (4)�������");
		System.out.println("�ڵȺź���������,��������������Է��������ʽ��������Ϊ���󣩱�ʾ��� ");
		select=sca.nextInt();
		if(select==0)
		{
			r.first(min, max, num, r);
			System.out.println("�ܹ���� "+r.right+" ����");
		}
		else if(select==1)
		{
			r.first(min, max, 2*(num/3), r);
			r.second(min, max, num, r);
			System.out.println("�ܹ���� "+r.right+" ����");
		}
		else if(select==2)
		{
			r.first(min, max, 2*(num/3), r);
			r.third(min, max, num, r);
			System.out.println("�ܹ���� "+r.right+" ����");
		}
		else if(select==3)
		{
			r.first(min, max, 2*(num/3), r);
			r.third1(min, max, num, r);
			System.out.println("�ܹ���� "+r.right+" ����");
		}
		else if(select==4)
		{
			r.fourth(min, max, num, r);
			System.out.println("�ܹ���� "+r.right+" ����");
		}
		else
		{
			System.out.println("�������");
		}
	}
	public static void main(String[] args){
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

