package first;
public class Client
{
	public static void main(String args[])
	{
	   Person p=new Person();
	   
	   TravelStrategy strategy;
	   strategy=(TravelStrategy)XMLUtil.getBean();
      
       p.setStrategy(strategy);//设置具体策略
       p.travel();
	}
}