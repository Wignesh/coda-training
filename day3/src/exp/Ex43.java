package exp;

/*
 * Error at compile time 
 * This is a slightly sneaky one as it looks like a question about constructors,
 * but it is attempting to test knowledge of the use of the private modifier.
 * A top level class cannot be defined as private. If you didn't notice the modifier private, remember in the exam to be real careful to read every part of the question. 
*/
//private class Baser
class Baser {
	Baser() {
		int i = 100;
		System.out.println(i);
	}
}

public class Ex43 extends Baser {
	static int i = 200;

	public static void main(String[] args) {
		Ex43 p = new Ex43();
		System.out.println(i);
	}


}