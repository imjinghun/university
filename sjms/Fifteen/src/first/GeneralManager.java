package first;
public class GeneralManager extends Leader
{
	public GeneralManager(String name)
	{
		super(name);
	}
	
	public void handleRequest(LeaveRequest request)
	{
		if(request.getLeaveMoney()<=20)
		{
			System.out.println("总经理" + name + "审批"+request.getLeaveName()+"的采购单，金额 " + request.getLeaveMoney() + "万元。");
		}
		else
		{
			System.out.println("需要开职工大会确定" + request.getLeaveName() + "的" + request.getLeaveMoney() + "万元的采购单");
		}
	}
}