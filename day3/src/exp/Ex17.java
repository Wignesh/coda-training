package exp;

class Base {
}

class Sub extends Base {
}

class Sub2 extends Base {
}

public class Ex17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base b = new Base();
		// base class can't be cast to Sub class
		Sub s = (Sub) b;

	}

}
