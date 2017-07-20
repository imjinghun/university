package first;

public class Mainframe {
	CPU cpu=new CPU();
	HardDisk hardDisk=new HardDisk();
	Memory memory=new Memory();
	OS os=new OS();
	
	public void on()
	{
		memory.check();
		cpu.run();
		hardDisk.read();
		os.load();
	}
}

