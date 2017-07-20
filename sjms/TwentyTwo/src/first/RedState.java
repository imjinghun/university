package first;

public class RedState extends AccountState{

	double amount;
	public RedState(AccountState state)
	{
		this.acc=state.acc;
		this.balance=state.balance;
	}
	public void withdraw(double amount)
	{
		this.amount=amount;
		//balance-=amount;
		System.out.println(acc.getowner()+" 打算取款  "+amount+" 元");
		stateCheck();
	}
	public void stateCheck() {
		if(balance>=0)
		{
			acc.setState(new GreenState(this));
		}
		else if(balance<-1000)
		{
			System.out.println("透支，只能存款！余额为 "+balance+" 元");
			//this.balance+=amount;
			System.out.println("--------------------------------------");
		}
		else if(balance<=0)
		{
			acc.setState(new YellowState(this));
		}
	}

}
