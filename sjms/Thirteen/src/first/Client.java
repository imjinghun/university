package first;

public class Client
{
	public static void main(String args[])
	{
		Color c1,c2,c3,c4;
		ColorFactory cf=new ColorFactory();
		
		c1=cf.getWordColor("red");
		c1.use(new Word("Hello World"));
		
		c2=cf.getWordColor("green");
		c2.use(new Word("Hello World"));
		
		c3=cf.getWordColor("blue");
		c3.use(new Word("Hello World"));
		
		
		System.out.println("文字个数:" + cf.getTotalColor());
		System.out.println("颜色个数:" + cf.getTotalWord());
		
	}
}