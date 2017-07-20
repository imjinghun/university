package first;

public abstract class AccountState {
	Account acc;
	double balance=0;
	public abstract void stateCheck();
	
	public void deposit(double amount)
	{
		balance+=amount;
		System.out.println(acc.getowner()+" 存款 "+amount+" 元，余额为 "+balance+" 元");
		stateCheck();
	}
	public void withdraw(double amount)
	{
		balance-=amount;
		System.out.println(acc.getowner()+" 取款 "+amount+" 元，余额为 "+balance+" 元");
		stateCheck();
	}
}
