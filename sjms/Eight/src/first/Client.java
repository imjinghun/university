package first;

public class Client
{
	public static void main(String args[])
	{
		Cat cat=(Cat)XMLUtil.getBean();
		cat.catchMouse();
		Dog dog=(Dog)XMLUtil.getBean();
		dog.wang();
	}
}