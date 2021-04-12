package ga.veee.day23.control;

import java.util.ListResourceBundle;

public class Dictionary_en extends ListResourceBundle {
    Object obj[][] = {
            {"username", "Username"},
            {"password", "Password"},
            {"hero1", "Fresh"},
            {"hero2", "Grocery"},
            {"hero3", "Shopping"}
    };

    @Override
    protected Object[][] getContents() {
        // TODO Auto-generated method stub
        return obj;
    }

}
