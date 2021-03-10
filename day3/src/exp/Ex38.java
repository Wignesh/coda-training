package exp;

class Basees {
	Basees(int i) {
		System.out.println("base constructor");
	}

	Basees() {
	}
}

public class Ex38 extends Basees {
	public static void main(String argv[]) {
		Ex38 s = new Ex38();
		// One

	}

	Ex38() {
		// Two
		super(10);

	}

	public void derived() {
		// Three

	}
}
