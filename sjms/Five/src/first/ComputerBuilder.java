package first;

public abstract class ComputerBuilder {

	protected Computer computer = new Computer();
	
	public abstract void buildCPU();
	public abstract void buildOther();
	public Computer getComputer()
	{
		return computer;
	}
 	
}
