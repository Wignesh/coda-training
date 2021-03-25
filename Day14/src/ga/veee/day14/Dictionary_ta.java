package ga.veee.day14;

import java.util.ListResourceBundle;

public class Dictionary_ta extends ListResourceBundle {

    Object obj[][] = {
            {"hello", "vanakkam!"},
            {"name", "ungal peyar"}
    };

    @Override
    protected Object[][] getContents() {
        return obj;
    }
}
