package ga.veee.hibernate.CompKey;

import ga.veee.hibernate.Utility.HibernateUtility;
import org.hibernate.Session;


public class ReadClient {
    public static void main(String[] args) {
        Session session = HibernateUtility.getSession();

        CompKey ck = new CompKey();
        ck.setInv_id(1001);
        ck.setItem_id(200);

        ItemTrans it = (ItemTrans) session.get(ItemTrans.class, ck);

        System.out.println(it.getQty());

    }
}
