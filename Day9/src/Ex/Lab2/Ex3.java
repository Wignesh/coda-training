package Ex.Lab2;

public class Ex3 {
    public void mth1() {
        mth2();
        System.out.println("caller");
    }

    public void mth2() {
        try {// line 1 return;
//            int a = 5/(1-1);
            System.exit(0);
        } catch (Exception e) {
            System.out.println("catch-mth2");
        } finally {
            // won't execute at all
            System.out.println("finally-mth2");
        }
    }

    public static void main(String p[]) {
        Ex3 s = new Ex3();
        s.mth1();
    }
}
