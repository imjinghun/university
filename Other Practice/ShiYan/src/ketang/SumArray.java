//����һ��һά���������������������ֵ���л���
package ketang;
import java.util.*;
public class SumArray {
	public static void main(String[] args) {
		Scanner sca=new Scanner(System.in);
		System.out.println("���������������ĸ���");
		int num=sca.nextInt();
		int a[],b[];
		a=new int[num];
		b=new int[num];
		System.out.println("�����������");
		int i;
		for(i=0;i<num;i++)
		{
			a[i]=sca.nextInt();
		}
		int t,j=0,sum=0,max=a[0];
		for(i=0;i<num;i++)  //δ�ɻ�֮ǰ�����ֵ
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
		/* ʵ����β���  */
		int min=a[0];
		for(i=0;i<num;i++) //�ҵ���Сֵ
		{
			if(min>a[i])
			{
				min=a[i];
				j=i;
			}
		}
		t=j;    //����Сֵ�±�jֵ����t
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
		sum=0; //���ų�ʼ��sumΪ0
		for(i=0;i<num;i++)  //���ɻ�֮�������ֵ
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
		System.out.println("����������Ϊ "+max);
	}
}
