package first;

public class Desktop extends ComputerBuilder{

	public void buildCPU()
	{
		computer.setCPU("台式机的CPU");
	}
	public void buildOther()
	{
		computer.setOther("台式机的硬盘，内存，显示器等");
	}
}
