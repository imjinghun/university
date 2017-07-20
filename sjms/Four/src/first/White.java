package first;

public class White implements SkinColorFactory {

	public Men men(){
		
		return new WhiteMen();
	}

	public Women women() {
		
		return new WhiteWomen();
	}
}
