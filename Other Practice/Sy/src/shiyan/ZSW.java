package shiyan;
import java.util.*;
public class ZSW {

	public static void main(String[] args) {
		Scanner sca=new Scanner(System.in);
		System.out.println("������������");
		int count=sca.nextInt();
		int a[]=new int[count];
		int i,j=1,sw;//jΪĳ��ID���ֵĴ���������Ϊsw��ˮ��ID�����ֵĴ���
		System.out.println("��������ID");
		for(i=0;i<count;i++)
		{
			a[i]=sca.nextInt();
		}
		sw=a[0];//�����һ����Ϊˮ��ID
		for(i=1;i<count;i++)
		{
			if(sw!=a[i])
			{
				j=j-1;
				if(j<=0)	//���j<=0�����ʾsw����ˮ��ID����Ϊˮ������������һ�룬������ô������������С�ڵ���0
				{
					sw=a[i+1];	//����Ҫ������IDΪˮ����ID
					j=1;		//���¶���ˮ��ID���ִ���
					i++;
				}
			}
			else
			{
				sw=a[i];
				j=j+1;//ͳ��ˮ��������
			}
		}
		System.out.println("ˮ��ID�� "+sw);
	}
}
