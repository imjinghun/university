package first;
public class Manager extends Leader
{
	public Manager(String name)
	{
		super(name);
	}
	public void handleRequest(LeaveRequest request)
	{
		if(request.getLeaveMoney()<=5)
		{
			System.out.println("部门经理" + name + "审批"+request.getLeaveName()+"的采购单，金额 " + request.getLeaveMoney() + "万元。");
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