package shiyan;

import java.util.*;

public class ShiYan {

	public static void main(String[] args) {
		Scanner sca=new Scanner(System.in);
		System.out.println("������������");
		int num=sca.nextInt();
		int a[]=new int[num];int b[]=new int[3];
		int i,j,k,m=0,sw;
		System.out.println("��������ID");
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
				if(sw==a[j])//��¼ID���ִ���
				{
					k++;
				}
				if(k>(num/4))//ID������1/4Ϊһ��ˮ��
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
		System.out.println("ˮ��ID ");
		for(i=0;i<3;i++)
		{
			System.out.println(b[i]);
		}
	}
}