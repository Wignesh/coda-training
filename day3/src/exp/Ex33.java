package exp;

public class Ex33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Background implements Runnable {
	int i = 0;

	// run should be void cant return
	public void run() {
		while (true) {
			i++;
			System.out.println("i=" + i);
		} // End while

//		return 1;
	}// End run
}// End class
