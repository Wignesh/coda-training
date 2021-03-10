//Question 14)
//Which of the following lines of code will compile without error 
//1) int can't compared with bool
//int i=0; 
//if(i) { 
//        System.out.println("Hello"); 
//        }
//2) it will run
//boolean b=true; 
//boolean b2=true; 
//if(b==b2) { 
//        System.out.println("So true"); 
//        }
//3) it will run
//int i=1; 
//int j=2; 
//if(i==1|| j==2) 
//        System.out.println("OK");
//4) token error or invalid operator
//int i=1; 
//int j=2; 
//if(i==1 &| j==2) 
//        System.out.println("OK");


package exp;

public class Ex14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean b = true;
		boolean b2 = true;
		if (b == b2) {
			System.out.println("So true");
		}
		
		int i = 1;
		int j = 2;
		if (i == 1 || j == 2)
			System.out.println("OK");
		
	}

}
