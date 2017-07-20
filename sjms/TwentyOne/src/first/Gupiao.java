package first;
import java.util.*;

public abstract class Gupiao
{
	protected ArrayList observers = new ArrayList();
	
	//添加股民
	public void attach(Gumin gm)
	{
		observers.add(gm);
	} 
	
	//移除股民
	public void detach(Gumin gm)
	{
		observers.remove(gm);
	}
	
	public abstract void fudong(); //股票浮动
}