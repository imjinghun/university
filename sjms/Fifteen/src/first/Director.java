package first;
public class Director extends Leader
{
	public Director(String name)
	{
		super(name);
	}
	public void handleRequest(LeaveRequest request)
	{
		if(request.getLeaveMoney()<=1)
		{
			System.out.println("主任" + name + "审批"+request.getLeaveName()+"的采购单，金额 " + request.getLeaveMoney() + "万元。");
		}
		else
		{
			if(this.successor!=null)
			{
				this.successor.handleRequest(request);
			}
		}
	}
}