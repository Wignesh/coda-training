package ga.veee.day23.Tag;

import ga.veee.day23.daopack.ItemDAOImpl;
import ga.veee.day23.daopack.ItemDTO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class OrderListTag extends TagSupport {
    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            Enumeration<String> e = pageContext.getSession().getAttributeNames();
            ArrayList<Integer> ids = new ArrayList<>();
            while (e.hasMoreElements()) {
                String name = e.nextElement();
                ArrayList<String> whiteList = new ArrayList<String>(){{
                    add("uname");
                    add("lang");
                    add("rb");
                }};
                if (!whiteList.contains(name)) {
                    String value = (String) pageContext.getSession().getAttribute(name);
                    ids.add(Integer.parseInt(name));
                }
            }
            Properties dbConfigProp = (Properties) pageContext.getServletContext().getAttribute("dbConfigProp");
            ItemDAOImpl itemDAOImpl = ItemDAOImpl.getItemDaoImpl(dbConfigProp);
            if (!ids.isEmpty()) {
                Set<ItemDTO> items = itemDAOImpl.findInIds(ids);
                if (items != null) {
                    int itemCounts = 0;
                    float subTotal = 0.0F;
                    out.println("                <div class=\"ckeckout-right-products checkout-border-bottom \">\n");
                    for (ItemDTO item : items) {
                        int qty = Integer.parseInt((String) pageContext.getSession().getAttribute(String.valueOf(item.getItemId())));
                        subTotal += qty * item.getPrice();
                        itemCounts += 1;
                        out.println(String.format("                    <div class=\"checkout-product-items\">\n" +
                                "                        <h4>%s x %s</h4>\n" +
                                "                        <h4>%s</h4>\n" +
                                "                    </div>", item.getDescription(), qty, qty * item.getPrice()));

                    }
                    out.println("</div>\n");
                    out.println("                <div class=\"ckeckout-right-header checkout-border-bottom \">\n" +
                            "                    <div>\n" +
                            "                        <h3>Shipping</h3>\n" +
                            "                    </div>\n" +
                            "                    <div>\n" +
                            "                        <h3>Free Shipping</h3>\n" +
                            "                    </div>\n" +
                            "                </div>");
                    out.println(String.format("                <div class=\"ckeckout-right-header checkout-border-bottom \">\n" +
                            "                    <div>\n" +
                            "                        <h2>Total</h2>\n" +
                            "                    </div>\n" +
                            "                    <div>\n" +
                            "                        <h2>&#8377; %s</h2>\n" +
                            "                    </div>\n" +
                            "                </div>", subTotal));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doEndTag();
    }
}
