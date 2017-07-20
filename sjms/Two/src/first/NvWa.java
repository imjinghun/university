package first;

public class NvWa {
	public static Human MakePeople(String sex) throws Exception
	{
		if(sex.equalsIgnoreCase("m"))
		{
			System.out.println("女娲制造男人");
			return new Man();
		}
		else if(sex.equalsIgnoreCase("w"))
		{
			System.out.println("女娲制造女人");
			return new Woman();
		}
		else if(sex.equalsIgnoreCase("r"))
		{
			System.out.println("女娲制造机器人");
			return new Robot();
		}
		else
		{
			throw new Exception("不制造其他人");
		}
	}
}
