package first;

public class PhoneDecorator implements Phone{
	private Phone phone;
	public PhoneDecorator(Phone phone)
	{
		this.phone=phone;
	}
	public String upgrade(String g)
	{
		return phone.upgrade(g);
	}
}
