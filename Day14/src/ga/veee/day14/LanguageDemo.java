package ga.veee.day14;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageDemo {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();

        System.out.println(locale);

        Locale.setDefault(new Locale("ta"));

        System.out.println(Locale.getDefault());
        locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle("dictionary", locale);
        System.out.println(rb.getString("hello"));

        ResourceBundle rbD = ResourceBundle.getBundle("ga.veee.day14.Dictionary", locale);
        System.out.println(rbD.getString("hello"));
    }
}
