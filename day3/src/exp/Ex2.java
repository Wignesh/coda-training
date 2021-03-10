package exp;

public class Ex2 {

	// error Can't make static reference to void amethod. 
	public static void main(String arguments[]) {
		amethod(arguments);
	}
	
	// the following method should be static

	public static void amethod(String[] arguments) {
		System.out.println(arguments);
		// if no argument it should failed with index out of bounce
		System.out.println(arguments[1]);
	}

}
