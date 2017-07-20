package first;
import java.util.*;
public class ColorFactory {
	private ArrayList words = new ArrayList();
	private int totalcolor=0;
	
	public ColorFactory()
	{
		Color c1=new red(" 红色");
		words.add(c1);
		Color c2=new green(" 绿色");
		words.add(c2);
		Color c3=new blue(" 蓝色");
		words.add(c3);
	}
	
	public Color getWordColor(String type)
	{
		if(type.equalsIgnoreCase("red"))
		{
			totalcolor++;
			return (Color)words.get(0);
		}
		else if(type.equalsIgnoreCase("green"))
		{
			totalcolor++;
			return (Color)words.get(1);
		}
		else if(type.equalsIgnoreCase("blue"))
		{
			totalcolor++;
			return (Color)words.get(2);
		}
		else
		{
			return null;
		}
	}
	
	public int getTotalWord()
	{
		return words.size();
	}
	
	public int getTotalColor()
	{
		return totalcolor;
	}
}
