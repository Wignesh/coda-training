//12. Which of the following signatures are valid for the main() method entry point of an application?
//      a. public static void main()
//      b. public static void main(String arg[])
//      c. public void main(String  [] arg)
//      d. public static void main(Stering[] arg)
//      e. public static int main(String [] arg)
//      ANS : b
package Ex.Lab1;

public class Ex12 {
//    public static void main() {} -> Arguments should be defined

    // Works fine
    public static void main(String[] args) {

    }

//    public void main(String  [] arg) {} -> should be static

//    public static void main(Stering[] arg){} -> Typo in String

//    public static int main(String [] arg){} -> should be void
}
