package first;


public class VideoFile extends AbstractFile{

	private String fileName;
	public VideoFile(String fileName)
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
