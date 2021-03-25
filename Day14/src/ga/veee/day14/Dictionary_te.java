package ga.veee.day14;

import java.util.ListResourceBundle;

public class Dictionary_te extends ListResourceBundle {

    Object obj[][] = {
            {"hello", "namaskaramlu"},
            {"name", "mi peru"}
    };

    @Override
    protected Object[][] getContents() {
        return obj;
    }
}
