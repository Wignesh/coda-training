package ga.veee.day15;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteAOUPTSTR {
    public static void main(String args[]) throws IOException {
        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String s = "Hello World";
        byte buf[] = s.getBytes();
        f.write(buf);
        byte b[] = f.toByteArray();
        for (int I = 0; I < b.length; I++) {
            System.out.print((char) b[I]);
        }
    }
}
