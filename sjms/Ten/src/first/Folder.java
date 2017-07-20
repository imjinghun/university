package first;

import java.util.ArrayList;

public class Folder extends AbstractFile{

	private ArrayList fileList=new ArrayList();
	private String fileName;
	public Folder(String fileName)
	{
		this.fileName=fileName;
	}
	
	public void add(AbstractFile element) {
		fileList.add(element);
	}
	public void remove(AbstractFile element) {
		fileList.remove(element);
	}
	public void display() {
		System.out.println(fileName);
		for(Object object:fileList)
		{
			((AbstractFile)object).display();
		}
	}
 
}
