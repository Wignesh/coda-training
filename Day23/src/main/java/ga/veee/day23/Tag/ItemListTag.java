package ga.veee.day23.Tag;

import ga.veee.day23.daopack.ItemDAOImpl;
import ga.veee.day23.daopack.ItemDTO;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ItemListTag extends TagSupport {
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    private String category;

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    private String limit;


    @Override
    public int doEndTag() throws JspException {
        Properties dbConfigProp = (Properties) pageContext.getServletContext().getAttribute("dbConfigProp");
        ItemDAOImpl itemDAOImpl = ItemDAOImpl.getItemDaoImpl(dbConfigProp);
        Set<ItemDTO> items;
        if (category.equals("*")) {
            items = itemDAOImpl.findAll(Integer.parseInt(limit));
        } else {
            items = itemDAOImpl.findAllByCat(category,Integer.parseInt(limit));
        }
        JspWriter out = pageContext.getOut();
        for (ItemDTO item : items) {
            try {
                String itemCategory = item.getCategory();
                out.println(String.format("<div class=\"product-item\">\n" +
                        "            <input type=\"checkbox\" name=\"%s\" id=\"%s\" />\n" +
                        "\n" +
                        "            <div class=\"product-selection\">\n" +
                        "\n" +
                        "                <div class=\"product-deselect\"\n" +
                        "                     onclick=\"this.parentNode.parentNode.querySelector('input[type=checkbox]').checked ^= 1;\">\n" +
                        "                    <i class=\"fa fa-times\" aria-hidden=\"true\"></i>\n" +
                        "\n" +
                        "                </div>\n" +
                        "                <div class=\"product-select\">\n" +
                        "                    <i class=\"fa fa-check\" aria-hidden=\"true\"></i>\n" +
                        "\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <div class=\"product-image-container\">\n" +
                        "                <img class=\"product-image\" src=\"%s\" alt=\"\">\n" +
                        "                <button onclick=\"this.parentNode.parentNode.querySelector('input[type=checkbox]').checked ^= 1;\"\n" +
                        "                        class=\"product-add-button\">+ Add to Cart</button>\n" +
                        "            </div>\n" +
                        "\n" +
                        "            <h2>%s</h2>\n" +
                        "            <div class=\"product-rating\">\n" +
                        "                <span class=\"fa fa-star product-rating-checked product-rating-star\"></span>\n" +
                        "                <span class=\"fa fa-star product-rating-checked product-rating-star\"></span>\n" +
                        "                <span class=\"fa fa-star product-rating-checked product-rating-star\"></span>\n" +
                        "                <span class=\"fa fa-star product-rating-star\"></span>\n" +
                        "                <span class=\"fa fa-star product-rating-star\"></span>\n" +
                        "            </div>\n" +
                        "            <div class=\"product-price\">\n" +
                        "                &#8377; %s / %s\n" +
                        "            </div>\n" +
                        "        </div>", item.getItemId(), item.getItemId(), item.getImageUrl(), item.getDescription(), item.getPrice(), item.getUnit()));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.doEndTag();
    }
}
