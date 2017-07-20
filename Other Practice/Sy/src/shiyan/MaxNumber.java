package shiyan;
import java.util.*;

public class MaxNumber {

	public static void main(String[] args) {
		Scanner sca=new Scanner(System.in);
		System.out.println("输入数的数量");
		int length=sca.nextInt();//确定数组长度
		int list[]=new int[length];
		System.out.println("输入要比较的数");
		for(int i=0;i<length;i++)
			list[i]=sca.nextInt();
		MaxNumber s=new MaxNumber();
		System.out.println("最大值 "+s.Largest(list, length));
	}
	int Largest(int list[],int length){
		int i,max;
		if(list==null||length==0)
		{
			System.out.println("输入不合法，接下来的值是由于输入不合法造成的");
			return 0;
		}
		else
		{
			max=list[length-1];
			for(i=0;i<length-1;i++)
			{
				if(list[i]>max)
				{
					max=list[i];
				}
			}
			return max;
		}
	}
}
