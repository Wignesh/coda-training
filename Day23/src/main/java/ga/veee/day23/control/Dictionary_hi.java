package ga.veee.day23.control;

import java.util.ListResourceBundle;

public class Dictionary_hi extends ListResourceBundle {
    Object obj[][] = {
            {"username", "उपयोगकर्ता नाम"},
            {"password", "पारण शब्द"},
            {"hero1", "ताज़ा"},
            {"hero2", "किराना"},
            {"hero3", "खरीदारी"}
    };

    @Override
    protected Object[][] getContents() {
        // TODO Auto-generated method stub
        return obj;
    }

}
