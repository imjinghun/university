//返回一个一维整数数组最大子数组和最大值（有环）
package ketang;
import java.util.*;
public class SumArray {
	public static void main(String[] args) {
		Scanner sca=new Scanner(System.in);
		System.out.println("输入整数数组数的个数");
		int num=sca.nextInt();
		int a[],b[];
		a=new int[num];
		b=new int[num];
		System.out.println("输入数组的数");
		int i;
		for(i=0;i<num;i++)
		{
			a[i]=sca.nextInt();
		}
		int t,j=0,sum=0,max=a[0];
		for(i=0;i<num;i++)  //未成环之前找最大值
		{
			sum+=a[i];
			if(max<sum)
			{
				max=sum;
			}
			if(sum<0)
			{
				sum=0;
			}
		}
		/* 实现首尾相接  */
		int min=a[0];
		for(i=0;i<num;i++) //找到最小值
		{
			if(min>a[i])
			{
				min=a[i];
				j=i;
			}
		}
		t=j;    //将最小值下标j值赋给t
		i=0;
		while(j<num)
		{
			b[i]=a[j];
			i++;
			j++;
		}
		j=0;
		while(j<t)
		{
			b[i]=a[j];
			i++;
			j++;
		}
		sum=0; //接着初始化sum为0
		for(i=0;i<num;i++)  //连成环之后找最大值
		{
			sum+=b[i];
			if(max<sum)
			{
				max=sum;
			}
			if(sum<0)
			{
				sum=0;
			}
		}
		System.out.println("最大子数组和为 "+max);
	}
}
