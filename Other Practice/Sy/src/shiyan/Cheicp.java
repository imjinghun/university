package shiyan;

import java.util.Scanner;
import java.util.InputMismatchException;
public class Cheicp {

	public static void main(String[] args) {
		int count,yu,shang;//count ����   yu ����  shang ��
		double money;//Ǯ��
		Scanner sca=new Scanner(System.in);
		System.out.println("���빺���������������");
	try{
		count=sca.nextInt();
		while(count<=0)
		{
			System.out.println("���������빺���������������");
			count=sca.nextInt();
		}
		yu=count%10;
		if(count<=5)
		{
			if(count==1)
			{
				System.out.println("��ͼ۸�Ϊ "+8+" Ԫ");
			}
			if(count==2)
			{
				System.out.println("��ͼ۸�Ϊ "+2*8*0.95+" Ԫ");
			}
			if(count==3)
			{
				System.out.println("��ͼ۸�Ϊ "+3*8*0.9+" Ԫ");
			}
			if(count==4)
			{
				System.out.println("��ͼ۸�Ϊ "+4*8*0.8+" Ԫ");
			}
			if(count==5)
			{
				System.out.println("��ͼ۸�Ϊ "+5*8*0.75+" Ԫ");
			}
		}
		else if(count>5&&yu==8)
		{
			shang=count/10;
			money=51.2+60*shang;
			System.out.println("��ͼ۸�Ϊ "+money+" Ԫ");
		}
		else if(count>5&&yu!=8)
		{
			yu=count%5;
			shang=count/5;
			if(yu==0)
			{
				money=30*shang;
				System.out.println("��ͼ۸�Ϊ "+money+" Ԫ");
			}
			if(yu==1)
			{
				money=8+30*shang;
				System.out.println("��ͼ۸�Ϊ "+money+" Ԫ");
			}
			if(yu==2)
			{
				money=15.2+30*shang;
				System.out.println("��ͼ۸�Ϊ "+money+" Ԫ");
			}
			if(yu==3)
			{
				money=21.6+30*shang;
				System.out.println("��ͼ۸�Ϊ "+money+" Ԫ");
			}
			if(yu==4)
			{
				money=25.6+30*shang;
				System.out.println("��ͼ۸�Ϊ "+money+" Ԫ");
			}
		}
	}
	catch(InputMismatchException e)
	{
		System.out.println("���벻����Ҫ���밴Ҫ������");
	}
		
	}
}
