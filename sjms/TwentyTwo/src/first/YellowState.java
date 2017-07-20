package first;

public class YellowState extends AccountState{

	public YellowState(AccountState state)
	{
		this.acc=state.acc;
		this.balance=state.balance;
	}
	public void stateCheck() {
		if(balance<-1000)
		{
			acc.setState(new RedState(this));
		}
		else if(balance>0)
		{
			acc.setState(new GreenState(this));
		}
	}

}
