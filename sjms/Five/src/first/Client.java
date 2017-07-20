package first;
public class Client
{
	public static void main(String args[])
	{
		//动态确定电脑类型
	    ComputerBuilder mb=(ComputerBuilder)XMLUtil.getBean();
		//指挥者
		Director d=new Director();
	    //准备电脑
	    d.setComputerBuilder(mb);
	    //客户获得电脑
	    Computer computer=d.construct();
        
        System.out.println("不同电脑类型组成：");
        System.out.println(computer.getCPU());
        System.out.println(computer.getOther());
	}
}
