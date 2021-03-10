package exp;

abstract class Ex11 {
	abstract void amethod();

	static int i;
}

// abstract class extend abstract class
abstract class Mine extends Ex11 {
	public static void main(String argv[]) {
		int[] ar = new int[5];
		for (i = 0; i < ar.length; i++)
			System.out.println(ar[i]);
	}
}