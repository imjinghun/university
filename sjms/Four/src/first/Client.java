package first;

public class Client
{
	public static void main(String args[])
	{
         try
         {
         	SkinColorFactory factory;
         	Men m;
         	Women w;
         	factory=(SkinColorFactory)XMLUtil.getBean();
         	m=factory.men();
         	m.play();
         	w=factory.women();
         	w.play();
         }
         catch(Exception e)
         {
         	System.out.println(e.getMessage());
         }
	}
}
