package ceshi;

import java.util.*;

public class SiZeYunSuan {

	void result()
	{
		Scanner sca=new Scanner(System.in);
		Operation op=new Operation();
		Result r=new Result();
		//确定出题数量
		System.out.println("输入出题数量 ");
		int num=sca.nextInt();
		while(num<=0)
		{
			System.out.println("输入不合法，重新输入");
			num=sca.nextInt();
		}
		r.init(num);
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
		//确定是否有乘除法
		int select;
		System.out.println("除加减法之外，选择运算是否有乘除法 ");
		System.out.println("输入  (0)无乘除法  (1)只有乘法  (2)只有除法(无余数)  (3)只有除法(有余数)  (4)混合运算");
		System.out.println("在等号后面输入结果,如果除法有余数以分数最间形式（否则视为错误）表示结果 ");
		select=sca.nextInt();
		if(select==0)
		{
			r.first(min, max, num, r);
			System.out.println("总共算对 "+r.right+" 道题");
		}
		else if(select==1)
		{
			r.first(min, max, 2*(num/3), r);
			r.second(min, max, num, r);
			System.out.println("总共算对 "+r.right+" 道题");
		}
		else if(select==2)
		{
			r.first(min, max, 2*(num/3), r);
			r.third(min, max, num, r);
			System.out.println("总共算对 "+r.right+" 道题");
		}
		else if(select==3)
		{
			r.first(min, max, 2*(num/3), r);
			r.third1(min, max, num, r);
			System.out.println("总共算对 "+r.right+" 道题");
		}
		else if(select==4)
		{
			r.fourth(min, max, num, r);
			System.out.println("总共算对 "+r.right+" 道题");
		}
		else
		{
			System.out.println("输入错误");
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
			System.out.println("输入不合法，请重新执行，按照要求输入");
		}
	}
}

