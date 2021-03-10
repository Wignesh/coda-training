package exp;

import java.io.*;

public class Ex15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex15 m = new Ex15();
		System.out.println(m.amethod());
	}

	public int amethod() {
		try {
			FileInputStream dis = new FileInputStream("Hello.txt");
		} catch (FileNotFoundException fne) {
			System.out.println("No such file found");
			return -1;
		} catch (IOException ioe) {
		} finally {
			System.out.println("Doing finally");
		}
		return 0;
	}
	
	// try to open  file in current dir
	// if no file found catch works and return -1
	// finally finally works
}
