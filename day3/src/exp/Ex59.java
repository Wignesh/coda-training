package exp;

class Basem {
	private void amethod(int iBase) {
		System.out.println("Base.amethod");
	}
}

class Ex59 extends Basem {

	public static void main(String argv[]) {
		Ex59 o = new Ex59();
		int iBase = 0;
		o.amethod(iBase);
	}

	public void amethod(int iOver) {
		System.out.println("Over.amethod");
	}

}
