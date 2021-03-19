package Ex.Lab2;

/**
 * 2.Try the following and observe the result. Also try it with a statement throwing some exception in line 1
 */
public class Ex2 {
    public void mth1() {
        mth2();
        System.out.println("caller");
    }

    public void mth2() {
        try {// line 1 return;
            int a = 5/(1-1);
        } catch (Exception e) {
            System.out.println("catch-mth2");
        } finally {
            // executes always
            System.out.println("finally-mth2");
        }
    }

    public static void main(String p[]) {
        Ex2 s = new Ex2();
        s.mth1();
    }
}