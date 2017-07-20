package first;
public class Client
{
	public static void main(String a[])
	{
		DBOperator db;
		db=(DBOperator)XMLUtil.getBean();
		db.process();
		System.out.println("---------------------------------------");
	}
}
