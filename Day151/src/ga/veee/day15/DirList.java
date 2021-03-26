package ga.veee.day15;

import java.io.File;

public class DirList {
    public static void main(String[] args) {
        String dirname = "./java";
        File f1 = new File(dirname);
        if (!f1.exists()){
            f1.mkdirs();
        }

        File f2 = new File("./java/home/bin");
        if (!f2.exists()){
            f2.mkdirs();
        }
        if (f1.isDirectory()) {
            String s[] = f1.list();
            for (int I = 0; I < s.length; I++) {
                System.out.println(s[I]);
            }
        }
    }
}