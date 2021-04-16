package ga.veee.day23.Tag;

import ga.veee.day23.daopack.ItemDAOImpl;
import ga.veee.day23.daopack.ItemDTO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.*;

public class CartListTag extends TagSupport {
    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        try {
            Enumeration<String> e = pageContext.getSession().getAttributeNames();
            ArrayList<Integer> ids = new ArrayList<>();
            ArrayList<String> whiteList = new ArrayList<String>(){{
                add("uname");
                add("lang");
                add("rb");
                add("limit");
                add("category");
                add("userId");
            }};
            while (e.hasMoreElements()) {
                String name = e.nextElement();
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

                    for (ItemDTO item : items) {
                        int qty = Integer.parseInt((String) pageContext.getSession().getAttribute(String.valueOf(item.getItemId())));
                        subTotal += qty * item.getPrice();
                        itemCounts += 1;
                        out.println(String.format(" <div class=\"cart-body\">\n" +
                                "                <div class=\"cart-div-image\">\n" +
                                "                    <img src=\"%s\"\n" +
                                "                        alt=\"\" />\n" +
                                "                </div>\n" +
                                "                <div class=\"cart-div-description\">\n" +
                                "                    <h6>%s</h6>\n" +
                                "                </div>\n" +
                                "                <div class=\"cart-div-unit-price\">\n" +
                                "                    <h6>&#8377; %s / %s</h6>\n" +
                                "                </div>\n" +
                                "                <div class=\"cart-div-quantity\">\n" +
                                "                    <div class=\"number-input\">\n" +
                                "                        <button type=\"button\"\n" +
                                "                            onclick=\"this.parentNode.querySelector('input[type=number]').stepDown()\">-</button>\n" +
                                "                        <input class=\"quantity\" maxlength=\"2\" min=\"0\" max=\"10\" name=\"%s\" value=\"%s\" type=\"number\"\n" +
                                "                            form=\"main-form\" />\n" +
                                "                        <button type=\"button\" onclick=\"this.parentNode.querySelector('input[type=number]').stepUp()\"\n" +
                                "                            class=\"plus\">+</button>\n" +
                                "                    </div>\n" +
                                "                </div>\n" +
                                "                <div class=\"cart-div-sub-total\">\n" +
                                "                    <h6>&#8377; %s</h6>\n" +
                                "                </div>\n" +
                                "                <div class=\"cart-div-action\">\n" +
                                "                    <a href=\"clear-cart.jsp?Id=%s\" class=\"cart-delete-action\">\n" +
                                "                        <i class=\"fa fa-trash-o\" aria-hidden=\"true\"></i>\n" +
                                "                    </a>\n" +
                                "                </div>\n" +
                                "            </div>", item.getImageUrl(), item.getDescription(), item.getPrice(), item.getUnit(), item.getItemId(), qty, item.getPrice() * qty, item.getItemId()));
                    }
                    out.println(String.format("            <div class=\"cart-body\">\n" +
                            "                <div class=\"cart-div-image\"></div>\n" +
                            "                <div class=\"cart-div-description\"></div>\n" +
                            "                <div class=\"cart-div-unit-price cart-color-reset\"></div>\n" +
                            "                <div class=\"cart-div-quantity border-bottom border-top\">Subtotal</div>\n" +
                            "                <div class=\"cart-div-sub-total cart-color-reset border-bottom border-top\">&#8377; %s</div>\n" +
                            "                <div class=\"cart-div-action\"></div>\n" +
                            "            </div>", subTotal));

                    out.println(String.format("<div class=\"cart-body clear-shadow\">\n" +
                            "                <div class=\"cart-div-image\"></div>\n" +
                            "                <div class=\"cart-div-unit-price cart-color-reset\">                    <a href=\"welcome.jsp#products \" class=\"cart-button\"><i class=\"fa fa-plus\" aria-hidden=\"true\"></i> Add More Items</a>\n</div>\n" +
                            "                <div class=\"cart-div-quantity\">\n" +
                            "    <form action=\"shop.do\" method=\"POST\" id=\"main-form\">\n" +
                            "\n" +
                            "        <input type=\"hidden\" name=\"formId\" value=\"Shop\"/>\n" +
                            "        <input type=\"hidden\" name=\"shopId\" value=\"shop1\"/>" +
                            "                    <button type=\"submit\" class=\"cart-button\"><i class=\"fa fa-refresh\" aria-hidden=\"true\"></i> Update Cart</button>\n" +
                            "                </div>\n" +
                            "    </form>\n" +
                            "                <div class=\"cart-div-sub-total cart-color-reset \">\n" +
                            "                    <a href=\"clear-cart.jsp?Id=*\" class=\"cart-button\"><i class=\"fa fa-times\" aria-hidden=\"true\"></i> Clear Cart</a>\n" +
                            "                </div>\n" +
                            "\n" +
                            "                <div class=\"cart-div-description cart-button-right\">\n" +
                            "                    <a href=\"checkout.jsp\" class=\"cart-button cart-button-checkout\"><i class=\"fa fa-check\" aria-hidden=\"true\"></i>\n" +
                            "                        %s</a>\n" +
                            "                </div>\n" +
                            "\n" +
                            "\n" +
                            "                <div class=\"cart-div-action\"></div>\n" +
                            "            </div>",pageContext.getSession().getAttribute("uname") == null ? "Login To Checkout" : "Proceed To Checkout"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doEndTag();
    }
}
