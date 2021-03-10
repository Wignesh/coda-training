package exp;

public class Ex21 {

	public static void main(String argv[]) {
		int i;
		int j;
		outer: for (i = 1; i < 3; i++)
			inner: for (j = 1; j < 3; j++) {
				if (j == 2)
					continue outer; // continue to label outer
				System.out.println("Value for i=" + i + " Value for j=" + j);
			}
	}

}
