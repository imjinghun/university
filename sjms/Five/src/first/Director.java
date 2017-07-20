package first;

public class Director {

	private ComputerBuilder cb;
	public void setComputerBuilder(ComputerBuilder cb)
	{
		this.cb=cb;
	}
	public Computer construct()
	{
		cb.buildCPU();
		cb.buildOther();
		return cb.getComputer();
	}
}
