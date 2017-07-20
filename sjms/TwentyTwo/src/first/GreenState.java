package first;

public class GreenState extends AccountState{

	public GreenState(AccountState state)
	{
		this.acc=state.acc;
		this.balance=state.balance;
	}
	public GreenState(double balance,Account acc)
	{
		this.acc=acc;
		this.balance=balance;
	}
	public void stateCheck() {
		if(balance<-1000)
		{
			acc.setState(new RedState(this));
		}
		else if(balance<=0)
		{
			acc.setState(new YellowState(this));
		}
	}

}
