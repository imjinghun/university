package first;

public class red implements Color{

	private String color;
	
	public red(String color)
	{
		this.color=color;
	}
	public String getColor() {
		return this.color;
	}

	public void use(Word word) {
		System.out.println("文字是  "+word.getWord()+" 颜色是 "+this.color);
	}
	
}