package first;
public class ViceGeneralManager extends Leader
{
	public ViceGeneralManager(String name)
	{
		super(name);
	}
	public void handleRequest(LeaveRequest request)
	{
		if(request.getLeaveMoney()<=10)
		{
			System.out.println("副总经理" + name + "审批"+request.getLeaveName()+"的采购单，金额 " + request.getLeaveMoney() + "万元。");
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