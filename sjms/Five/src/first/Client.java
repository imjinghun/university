package first;
public class Client
{
	public static void main(String args[])
	{
		//��̬ȷ����������
	    ComputerBuilder mb=(ComputerBuilder)XMLUtil.getBean();
		//ָ����
		Director d=new Director();
	    //׼������
	    d.setComputerBuilder(mb);
	    //�ͻ���õ���
	    Computer computer=d.construct();
        
        System.out.println("��ͬ����������ɣ�");
        System.out.println(computer.getCPU());
        System.out.println(computer.getOther());
	}
}
