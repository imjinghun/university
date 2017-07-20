package first;

public class CaculatorForm {

	private AbstractCommand command;
	public void setCommand(AbstractCommand command)
	{
		this.command=command;
		
	}
	
	public void compute(int v[])
	{
		int i=command.execute(v);
		System.out.println("执行运算，结果为"+i);
	}
	public void undo()
	{
		int i=command.undo();
		System.out.println("执行撤销，结果为"+i);
	}
	public void redo()
	{
		int i=command.redo();
		System.out.println("执行重做，结果为"+i);
	}
}
