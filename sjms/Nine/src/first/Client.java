package first;

public class Client
{
	public static void main(String a[])
	{
		Road road;
		Vehicle vechile;
		
		road=(Road)XMLUtilPen.getBean("road");
		vechile=(Vehicle)XMLUtilPen.getBean("vehicle");
		
		vechile.setRoad(road);
		vechile.type("б╥ио");
	}
}