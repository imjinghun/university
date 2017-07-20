package first;

public class StudentNo
{
	private static StudentNo instance=null;
	private String no;
	
	private StudentNo()
	{	
	}
	
	public static StudentNo getInstance()
	{
		if(instance==null)
		{
			System.out.println("新生入学，分配学号！");
		    instance=new StudentNo();
		    instance.setIdentityCardNo("20140000");		
		}
		else
		{
			System.out.println("转专业，学号不改变，获取旧学号！");  
		}
		return instance;
	}
	
	private void setIdentityCardNo(String no)
	{
	    this.no=no;
	}
	
	public String getIdentityCardNo()
	{
		return this.no;
	}
	
}