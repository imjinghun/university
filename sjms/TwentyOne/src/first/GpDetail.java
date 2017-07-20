package first;
public class GpDetail extends Gupiao
{
	public void fudong()
	{
		System.out.println("股票的价格上涨5%");
		for(Object obs:observers)
		{
			((Gumin)obs).response("买股票");
		}
		System.out.println("----------------------------");
		
		System.out.println("股票的价格下降5%");
		for(Object obs:observers)
		{
			((Gumin)obs).response("大哭");
		}
	}	   	
}