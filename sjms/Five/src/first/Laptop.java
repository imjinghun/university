package first;

public class Laptop extends ComputerBuilder{

	public void buildCPU()
	{
		computer.setCPU("笔记本的CPU");
	}
	public void buildOther()
	{
		computer.setOther("笔记本的硬盘，内存，显示器等");
	}
}
