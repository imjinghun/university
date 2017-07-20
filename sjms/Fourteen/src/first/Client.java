package first;

public class Client
{
	public static void main(String args[])
	{
		AbstractDating date;
		date=(AbstractDating)XMLUtil.getBean();

		date.blindDate();
		date.viewInfo();
		date.publishInfo();
		date.modifyInfo();
		System.out.println("----------------------------");
		date.setAge(20);
		date.blindDate();
		date.viewInfo();
		date.publishInfo();
		date.modifyInfo();
	} 
}