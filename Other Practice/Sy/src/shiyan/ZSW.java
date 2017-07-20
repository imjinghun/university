package shiyan;
import java.util.*;
public class ZSW {

	public static void main(String[] args) {
		Scanner sca=new Scanner(System.in);
		System.out.println("输入帖子总数");
		int count=sca.nextInt();
		int a[]=new int[count];
		int i,j=1,sw;//j为某个ID出现的次数，假设为sw（水王ID）出现的次数
		System.out.println("输入帖子ID");
		for(i=0;i<count;i++)
		{
			a[i]=sca.nextInt();
		}
		sw=a[0];//假设第一个数为水王ID
		for(i=1;i<count;i++)
		{
			if(sw!=a[i])
			{
				j=j-1;
				if(j<=0)	//如果j<=0，则表示sw不是水王ID。因为水王发帖数大于一半，无论怎么抵消，都不会小于等于0
				{
					sw=a[i+1];	//所有要换其他ID为水王的ID
					j=1;		//重新定义水王ID出现次数
					i++;
				}
			}
			else
			{
				sw=a[i];
				j=j+1;//统计水王帖子数
			}
		}
		System.out.println("水王ID是 "+sw);
	}
}
