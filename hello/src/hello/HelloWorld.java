/**
 * First program in Eclipse IDE 
 */
package hello;

/**
 * @author VIGNESH J 3:38 PM 3/9/2021
 */
public class HelloWorld {

	public static void main(String[] args) {
		if (args.length > 0) {
			System.out.println("Hello," + args[0]);
		} else {
			System.out.println("Hello whoever");
		}
		System.out.println("Hello, World!");

	}

}
