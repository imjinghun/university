package first;


public class ImageFile extends AbstractFile{

	private String fileName;
	public ImageFile(String fileName)
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
