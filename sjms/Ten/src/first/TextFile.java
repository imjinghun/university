package first;


public class TextFile extends AbstractFile{

	private String fileName;
	public TextFile(String fileName)
	{
		this.fileName=fileName;
	}
	
	public void add(AbstractFile element) {
		
	}
	public void remove(AbstractFile element) {
		
	}
	public void display() {
		System.out.println(fileName);
	}
 
}
