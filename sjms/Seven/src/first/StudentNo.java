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
			System.out.println("������ѧ������ѧ�ţ�");
		    instance=new StudentNo();
		    instance.setIdentityCardNo("20140000");		
		}
		else
		{
			System.out.println("תרҵ��ѧ�Ų��ı䣬��ȡ��ѧ�ţ�");  
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