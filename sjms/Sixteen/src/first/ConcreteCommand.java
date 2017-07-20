package first;

public class ConcreteCommand extends AbstractCommand{

	private Adder adder=new Adder();
	int v[];
	int length=0; 
	private int value=0;
	static int unnum=0; //撤销次数 
	static int renum=0; //重做次数
	public int execute(int v[]) {
		this.v=v;
		length=v.length;
		for(int i=0;i<length;i++)
		{
			value=adder.add(v[i]);
		}
		return value;
	}

	public int undo() {
		unnum+=1;
		if(unnum<=length)
		{
			value=adder.add(-v[length-unnum]);
		}
		return value;
	}
	
	public int redo()
	{
		renum+=1;
		if(renum<=length)
		{
			value=adder.add(v[length-renum]);
		}
		return value;
	}

}
