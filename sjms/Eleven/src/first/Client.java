package first;
public class Client
{
	public static void main(String args[])
	{
		String fun="声音";
		String result;
		Phone sp,jp,cp;
		
		sp=new SimplePhone();
		result=sp.upgrade(fun);
		System.out.println(result);
		System.out.println("---------------------");
		
		jp=new JarPhone(sp);
		result=jp.upgrade(fun);
	    System.out.println(result);
		System.out.println("---------------------");
		
		cp=new ComplexPhone(jp);
		result=cp.upgrade(fun);
	    System.out.println(result);
		System.out.println("---------------------");
		
	}
}
