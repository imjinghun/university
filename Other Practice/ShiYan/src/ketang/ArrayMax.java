//返回一个一维整数数组最大子数组和最大值
package ketang;
import java.util.*;
public class ArrayMax {

	public static void main(String[] args) {
		Scanner sca=new Scanner(System.in);
		System.out.println("输入整数数组数的个数");
		int num=sca.nextInt();
		int a[];
		a=new int[num];
		System.out.println("输入数组的数");
		int i;
		for(i=0;i<num;i++)
		{
			a[i]=sca.nextInt();
		}
		int sum=0,max=a[0];
		for(i=0;i<num;i++)
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
		System.out.println("最大子数组和为 "+max);
	}
}
