package first;

public class WomanNvWa implements NvWa{
	public Human MakePeople()
	{
		System.out.println("女娲制造女人");
		return new Woman();
	}
}
