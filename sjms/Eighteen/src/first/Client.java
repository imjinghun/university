package first;

public class Client
{
	public static void process(MyCollection collection)
	{
		MyIterator i=collection.createIterator();
		i.first();
		System.out.println("按学号升序排列");
		while(!i.isLast())
		{
			System.out.println(i.currentItem().getName()+" "+i.currentItem().getId()+" "+i.currentItem().getAge());
			i.next();
		}

		System.out.println("-----------------------------------------------------");
	}
	
	public static void process1(MyCollection collection)
	{
		MyIterator i=collection.createIterator();
		i.last();
		System.out.println("按学号降序排列");
		while(!i.isFirst())
		{
			System.out.println(i.currentItem().getName()+" "+i.currentItem().getId()+" "+i.currentItem().getAge());
			i.previous();
		}
		System.out.println(i.currentItem().getName()+" "+i.currentItem().getId()+" "+i.currentItem().getAge());
		System.out.println("-----------------------------------------------------");
	}
	
	public static void main(String a[])
	{
		MyCollection collection=new NewCollection();
		process(collection);
		process1(collection);
	}
}
