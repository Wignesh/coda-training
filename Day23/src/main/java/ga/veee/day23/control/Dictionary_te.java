package ga.veee.day23.control;

import java.util.ListResourceBundle;

public class Dictionary_te extends ListResourceBundle {
    Object obj[][] = {
            {"username", "వినియోగదారు పేరు"},
            {"password", "పాస్వర్డ్"},
            {"hero1", "తాజాది"},
            {"hero2", "కిరాణా"},
            {"hero3", "షాపింగ్"}
    };

    @Override
    protected Object[][] getContents() {
        // TODO Auto-generated method stub
        return obj;
    }

}
