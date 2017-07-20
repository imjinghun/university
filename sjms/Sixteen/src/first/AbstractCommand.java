package first;

public abstract class AbstractCommand {

	public abstract int execute(int v[]);
	public abstract int undo();
	public abstract int redo();
}
