package shiyan;
import java.util.*;

public class MaxNumber {

	public static void main(String[] args) {
		Scanner sca=new Scanner(System.in);
		System.out.println("������������");
		int length=sca.nextInt();//ȷ�����鳤��
		int list[]=new int[length];
		System.out.println("����Ҫ�Ƚϵ���");
		for(int i=0;i<length;i++)
			list[i]=sca.nextInt();
		MaxNumber s=new MaxNumber();
		System.out.println("���ֵ "+s.Largest(list, length));
	}
	int Largest(int list[],int length){
		int i,max;
		if(list==null||length==0)
		{
			System.out.println("���벻�Ϸ�����������ֵ���������벻�Ϸ���ɵ�");
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
