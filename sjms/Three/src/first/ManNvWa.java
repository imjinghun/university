package first;

public class ManNvWa implements NvWa{
	public Human MakePeople()
	{
		System.out.println("女娲制造男人");
		return new Man();
	}
}
