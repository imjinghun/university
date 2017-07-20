package first;

public class Account {
	private AccountState state;
	private String owner;
	public Account(String owner,double init)
	{
		this.owner=owner;
		state=new GreenState(init,this);
		state.balance=init;
		System.out.println(owner+" 开户成功，余额为 "+init+" 元");
	}
	public void setState(AccountState state)
	{
		this.state=state;
	}
	public String getowner()
	{
		return owner;
	}
	public void deposit(double amount)
	{
		state.deposit(amount);
	}
	public void withdraw(double amount)
	{
		state.withdraw(amount);
	}
}
