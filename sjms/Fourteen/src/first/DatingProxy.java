package first;

public class DatingProxy implements AbstractDating{

	private Daters daters=new Daters();
	private int age=0;
	
	@Override
	public void blindDate() {
		if(age<18)
		{
			System.out.println("对不起，未满18岁，不能早恋");
		}
		else if(age>=18)
		{
			daters.blindDate();
		}
		else
		{
			System.out.println("年龄有误");
		}
		
	}

	public void viewInfo() {
		System.out.println("可以查看发布者信息");
	}

	public void publishInfo() {
		if(age<18)
		{
			System.out.println("对不起，未满18岁，不能早恋");
		}
		else if(age>=18)
		{
			daters.publishInfo();
		}
		else
		{
			System.out.println("年龄有误");
		}
	}

	public void modifyInfo() {
		if(age<18)
		{
			System.out.println("对不起，未满18岁，不能早恋");
		}
		else if(age>=18)
		{
			daters.modifyInfo();
		}
		else
		{
			System.out.println("年龄有误");
		}
	}

	public void setAge(int age) {
		this.age=age;
	}
	

}
