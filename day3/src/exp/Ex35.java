package exp;

public class Ex35 {

	public static void main(String argv[]) {
		Ex35 c = new Ex35();
		String s = new String("ello");
		c.amethod(s);
	}

	public void amethod(String s) {
		char c = 'H';
		// operation not permitted can't compile;
//		c += s;
		System.out.println(c);
	}

}
