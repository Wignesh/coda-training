package exp;

public class Ex51 {

//	private int i;
	private static int i;

	public static void main(String argv[]) {
		Ex51 s = new Ex51();
		s.amethod();
	}// End of main

	public static void amethod() {
		// A compile time error complaining of the scope of the variable i 
		System.out.println(i);
	}// end of amethod
}
