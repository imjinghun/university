package shiyan;

import java.util.*;

public class ShiYan {

	public static void main(String[] args) {
		Scanner sca=new Scanner(System.in);
		System.out.println("输入帖子总数");
		int num=sca.nextInt();
		int a[]=new int[num];int b[]=new int[3];
		int i,j,k,m=0,sw;
		System.out.println("输入帖子ID");
		for(i=0;i<num;i++)
		{
			a[i]=sca.nextInt();
		}
		for(i=0;i<num;i++)
		{
			if(m!=0)
			{
				while(a[i]==b[m-1])
				{
					i++;
				}
			}
			sw=a[i];
			k=1;
			for(j=i+1;j<num;j++)
			{
				if(sw==a[j])//记录ID出现次数
				{
					k++;
				}
				if(k>(num/4))//ID数超过1/4为一个水王
				{
					b[m]=sw;
					m++;
					break;
				}
			}
			if(m==3)
			{
				break;
			}
		}
		System.out.println("水王ID ");
		for(i=0;i<3;i++)
		{
			System.out.println(b[i]);
		}
	}
}