package first;

public class ComplexPhone extends PhoneDecorator{

	public ComplexPhone(Phone phone) {
		super(phone);
	}
	public String upgrade(String g)
	{
		return addFun(g);
	}
	public String addFun(String fun)
	{
		return fun+"灯光闪烁";
	}

}
