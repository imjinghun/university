package first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NewCollection implements MyCollection
{
	   public MyIterator createIterator()
	   {
	  	  return new NewIterator();
	   }
	   
	   private class NewIterator implements MyIterator
	   {
		   Student std=new Student();
		   ArrayList<Student> list=std.sSortup();
		
	   	private int currentIndex=0;
	   	
	   	public void first()
	   	{
	   	  	currentIndex=0;
	   	}
	   	public void last()
	   	{
	   	  	currentIndex=list.size()-1;
	   	}
		public void next()
		{
			if(currentIndex<list.size())
			{
				currentIndex++;
			}
		}
		
		public void previous()
		{
			if(currentIndex>0)
			{
				currentIndex--;
			}
		}	
		
		public boolean isLast()
		{
			return currentIndex==list.size();
		}
		
		public boolean isFirst()
		{
			return currentIndex==0;
		}
		
		public Student currentItem()
		{
			return list.get(currentIndex);
	    }
	}
}