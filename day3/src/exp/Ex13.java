//Question 13)
//What will be printed out if you attempt to compile and run the following code? 
//int i=9; 
//switch (i) { 
//        default: 
//        System.out.println("default"); 
//                case 0: 
//        System.out.println("zero"); 
//                break; 
//        case 1: 
//                System.out.println("one"); 
//        case 2: 
//        System.out.println("two"); 
//}
//1) default 
//2) default, zero 
//3) error default clause not defined 
//4) no output displayed 

package exp;

public class Ex13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 9;
		switch (i) {

		case 0:
			System.out.println("zero");
			break;
		case 1:
			System.out.println("one");
		case 2:
			System.out.println("two");
		default:
			System.out.println("default");
		}

		// order of the default should be matter
	}

}
