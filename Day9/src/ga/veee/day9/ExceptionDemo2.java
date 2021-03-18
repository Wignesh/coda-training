package ga.veee.day9;

import java.lang.reflect.Field;

public class ExceptionDemo2 {
    public static void main(String[] args) throws Exception {
        String s = "Hello World";
        boolean yes = false;
        String name = "str";
        Field[] f = s.getClass().getFields();
        for (Field field : f) {
            if (field.getName().equals(name)) ;
            {
                yes = true;
            }
        }
        if (yes) {
            Field fields = s.getClass().getField("str");
        } else {
            System.out.println("Field not there");
        }
    }
}
