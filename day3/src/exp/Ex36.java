package exp;

public class Ex36 {
	public static void main(String argv[]) {
		Ex36 e = new Ex36();
	}

	Ex36() {
		String s = "Java";
		String s2 = "java";
		if (s.equals(s2) || (s == s2)) {
			System.out.println("Equal");
		} else

		{
			System.out.println("Not equal");
		}
	}
}