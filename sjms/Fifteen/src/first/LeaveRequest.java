package first;
public class LeaveRequest
{
	private String leaveName;
	private int leaveMoney;
	
	public LeaveRequest(String leaveName,int leaveMoney)
	{
		this.leaveName=leaveName;
		this.leaveMoney=leaveMoney;
	}
	
	public void setLeaveName(String leaveName) {
		this.leaveName = leaveName; 
	}

	public void setLeaveMoney(int leaveMoney) {
		this.leaveMoney = leaveMoney; 
	}

	public String getLeaveName() {
		return (this.leaveName); 
	}

	public int getLeaveMoney() {
		return (this.leaveMoney); 
	}	
}