package exp;

public class Ex25 {

	public static void main(String[] args) {
		
		// no need new type()
		Integer ten = new Integer(10);
		Long nine = new Long(9);
		System.out.println(ten + nine);
		int i = 1;
		System.out.println(i + ten);
		// => 19 followed by 11
	}

}
