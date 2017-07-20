package first;

public class RobotNvWa implements NvWa{
	public Human MakePeople()
	{
		System.out.println("女娲制造机器人");
		return new Robot();
	}
}
