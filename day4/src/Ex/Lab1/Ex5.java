package Ex.Lab1;

public class Ex5 {
    public static void main(String[] args) {
        System.out.println(calcAverage(new int[] {1,2,3}));
    }

    static float calcAverage(int a[]) {
        float sum = 0;
        for(int i:a){
            sum += i;
        }
        return sum / a.length;
    }
}
