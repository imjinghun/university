package shiyan;

import java.util.Scanner;
import java.util.InputMismatchException;
public class Cheicp {

	public static void main(String[] args) {
		int count,yu,shang;//count 书数   yu 余数  shang 商
		double money;//钱数
		Scanner sca=new Scanner(System.in);
		System.out.println("输入购买的数量（整数）");
	try{
		count=sca.nextInt();
		while(count<=0)
		{
			System.out.println("请重新输入购买的数量（整数）");
			count=sca.nextInt();
		}
		yu=count%10;
		if(count<=5)
		{
			if(count==1)
			{
				System.out.println("最低价格为 "+8+" 元");
			}
			if(count==2)
			{
				System.out.println("最低价格为 "+2*8*0.95+" 元");
			}
			if(count==3)
			{
				System.out.println("最低价格为 "+3*8*0.9+" 元");
			}
			if(count==4)
			{
				System.out.println("最低价格为 "+4*8*0.8+" 元");
			}
			if(count==5)
			{
				System.out.println("最低价格为 "+5*8*0.75+" 元");
			}
		}
		else if(count>5&&yu==8)
		{
			shang=count/10;
			money=51.2+60*shang;
			System.out.println("最低价格为 "+money+" 元");
		}
		else if(count>5&&yu!=8)
		{
			yu=count%5;
			shang=count/5;
			if(yu==0)
			{
				money=30*shang;
				System.out.println("最低价格为 "+money+" 元");
			}
			if(yu==1)
			{
				money=8+30*shang;
				System.out.println("最低价格为 "+money+" 元");
			}
			if(yu==2)
			{
				money=15.2+30*shang;
				System.out.println("最低价格为 "+money+" 元");
			}
			if(yu==3)
			{
				money=21.6+30*shang;
				System.out.println("最低价格为 "+money+" 元");
			}
			if(yu==4)
			{
				money=25.6+30*shang;
				System.out.println("最低价格为 "+money+" 元");
			}
		}
	}
	catch(InputMismatchException e)
	{
		System.out.println("输入不符合要求，请按要求输入");
	}
		
	}
}
