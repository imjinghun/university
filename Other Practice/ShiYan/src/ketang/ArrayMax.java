//����һ��һά���������������������ֵ
package ketang;
import java.util.*;
public class ArrayMax {

	public static void main(String[] args) {
		Scanner sca=new Scanner(System.in);
		System.out.println("���������������ĸ���");
		int num=sca.nextInt();
		int a[];
		a=new int[num];
		System.out.println("�����������");
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
		System.out.println("����������Ϊ "+max);
	}
}
