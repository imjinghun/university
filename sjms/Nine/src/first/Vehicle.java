package first;
public abstract class Vehicle
{
	protected Road road;
	public void setRoad(Road road)
	{
		this.road=road;
	}
	public abstract void type(String name);
} 