package first;

public class Computer {

	private String cpu,other;
	
	public void setCPU(String cpuname)
	{
		this.cpu=cpuname;
	}
	public void setOther(String othername)
	{
		this.other=othername;
	}
	public String getCPU()
	{
		return (this.cpu);
	}
	public String getOther()
	{
		return (this.other);
	}
}
