package first;

public class Client {

	public static void main(String[] args) {

		AbstractFile obj1,obj2,obj3;
		Folder f1,f2; 
		
		obj1=new VideoFile("视频文件");
		obj2=new ImageFile("图片文件");
		obj3=new TextFile("文本文件");
		
		f1=new Folder("文件夹1");
		f2=new Folder("文件夹2");
		
		f1.add(obj1);
		f1.add(obj2);
		f1.add(obj3);
		
		f1.add(f2);
		
		f1.display();
	}
}
