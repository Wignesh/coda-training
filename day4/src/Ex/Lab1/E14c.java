// 14.
// c) Try to execute java program by defining main
// i) Without public specifier
// ii) Without static modifier
// iii) Without function parameter
package Ex.Lab1;

public class E14c {
    // (i) static void main(String[] args) {
    // JVM won't allow to start

    // (ii) public  void main(String[] args) {
    // can't be called main without static

    // (iii) public static void main() {
    // main method should have args for passing arguments
    // won't visible to JVM

    public static void main(String[] args) {

    }
}
