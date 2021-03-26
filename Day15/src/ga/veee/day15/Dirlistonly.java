package ga.veee.day15;

import java.io.*;

class Onlyext implements FilenameFilter {
    String ext;

    public Onlyext(String e) {
        ext = "." + e;
    }

    public boolean accept(File dir, String name) {
        return name.endsWith(ext);
    }
}

class Dirlistonly {
    public static void main(String args[]) {
        // change in to package name
        String dirname = "./src/ga/veee/day15";
        File f1 = new File(dirname);
        FilenameFilter only = new Onlyext("java");
        String s[] = f1.list(only);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}
