package first;

public class Yellow implements SkinColorFactory {

	public Men men(){
		
		return new YellowMen();
	}

	public Women women() {
		
		return new YellowWomen();
	}
}
