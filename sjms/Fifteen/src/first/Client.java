package first;
public class Client
{
	public static void main(String args[])
	{
		Leader objDirector,objManager,objGeneralManager,objViceGeneralManager;
		
		objDirector=new Director("王明");
		objManager=new Manager("赵强");
		objGeneralManager=new GeneralManager("李波");
		objViceGeneralManager=new ViceGeneralManager("肖红");
		
		objDirector.setSuccessor(objManager);
		objManager.setSuccessor(objViceGeneralManager);
		objViceGeneralManager.setSuccessor(objGeneralManager);
			
		LeaveRequest lr1=new LeaveRequest("张三",1);
		objDirector.handleRequest(lr1);
			
		LeaveRequest lr2=new LeaveRequest("李四",5);
		objDirector.handleRequest(lr2);
		
		LeaveRequest lr3=new LeaveRequest("王五",10);
		objDirector.handleRequest(lr3);
						
		LeaveRequest lr4=new LeaveRequest("赵六",20);
		objDirector.handleRequest(lr4);			
		
		LeaveRequest lr5=new LeaveRequest("周七",30);
		objDirector.handleRequest(lr5);	
	}
}