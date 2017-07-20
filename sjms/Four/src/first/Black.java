package first;

public class Black implements SkinColorFactory {

	public Men men(){
		
		return new BlackMen();
	}

	public Women women() {
		
		return new BlackWomen();
	}
}
