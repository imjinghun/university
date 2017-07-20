package first;
public class Client
{
	public static void main(String a[])
	{
		Gupiao gp=new GpDetail();
		
		Gumin gm1,gm2;
		gm1=new Gumin1();
		gm2=new Gumin2();
		
		gp.attach(gm1);
		gp.attach(gm2);
	
		gp.fudong();		
	}
}