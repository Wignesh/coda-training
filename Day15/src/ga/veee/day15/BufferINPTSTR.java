package ga.veee.day15;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BufferINPTSTR {
    public static void main(String[] args) throws IOException {
        String s = "00% is $approx; equal to 100 but this &approx not.";
        byte[] buff = s.getBytes();
        ByteArrayInputStream in = new ByteArrayInputStream(buff);
        BufferedInputStream f = new BufferedInputStream(in);
        int c;
        char a = 247;
        boolean marked = false;
        while ((c = f.read()) != -1) {
            switch (c) {
                case '&':
                    if (!marked) {
                        f.mark(32);
                        marked = true;
                    } else {
                        marked = false;
                    }
                    break;
                case ';':
                    if (marked) {
                        marked = false;
                        System.out.println(a);
                    } else {
                        System.out.println((char) c);
                    }
                    break;
                case ' ':
                    if (marked) {
                        marked = false;
                        f.reset();
                        System.out.println("$");
                    } else {
                        System.out.println((char) c);
                    }
                    break;
                default:
                    if (!marked)
                        System.out.println((char) c);
                    break;

            }
        }
    }
}
