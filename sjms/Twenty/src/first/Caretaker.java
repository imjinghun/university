package first;

public class Caretaker
{
	private Memento memento4[]=new Memento[4];
	public static int c=0;
	public Memento getMemento()
	{
		return memento4[c];
	}
	public void setMemento(Memento memento)
	{
		memento4[c]=memento;
	}
}