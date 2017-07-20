package first;

public class JarPhone extends PhoneDecorator{

	public JarPhone(Phone phone) {
		super(phone);
	}
	public String upgrade(String g)
	{
		return addFun(g);
	}
	public String addFun(String fun)
	{
		return fun+"震动";
	}
}
