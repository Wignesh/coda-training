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


    @Override
    public int doEndTag() throws JspException {
        Properties dbConfigProp = (Properties) pageContext.getServletContext().getAttribute("dbConfigProp");
        ItemDAOImpl itemDAOImpl = ItemDAOImpl.getItemDaoImpl(dbConfigProp);
        Set<ItemDTO> items;
        if (category.equals("*")) {
            items = itemDAOImpl.findAll();
        } else {
            items = itemDAOImpl.findAllByCat(category);
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
                        "        </div>",item.getItemId(),item.getItemId(),item.getImageUrl(),item.getDescription(),item.getPrice(),item.getUnit()));

//                out.println(String.format("<div class=\"item %s\">\n" +
//                        "          <div class=\"item-image\">\n" +
//                        "            <img class=\"image\" src=\"%s\" alt=\"%s\" />\n" +
//                        "          </div>\n" +
//                        "          <div class=\"item-info\">\n" +
//                        "            <h4 class=\"item-title\">%s</h4>\n" +
//                        "            <h5 class=\"item-price\">&#8377; %s / %s</h5>\n" +
//                        "            <div class=\"rating\">\n" +
//                        "              <span class=\"fa fa-star checked\"></span>\n" +
//                        "              <span class=\"fa fa-star checked\"></span>\n" +
//                        "              <span class=\"fa fa-star checked\"></span>\n" +
//                        "              <span class=\"fa fa-star\"></span>\n" +
//                        "              <span class=\"fa fa-star\"></span>\n" +
//                        "              <span>330</span>\n" +
//                        "            </div>\n" +
//                        "            <div class=\"qty\">\n" +
//                        "              <form action=\"shop.do\" method=\"POST\">\n" +
//                        "                <div class=\"number-input\">\n" +
//                        "                  <button type=\"button\" onclick=\"this.parentNode.querySelector('input[type=number]').stepDown()\"></button>\n" +
//                        "                  <input class=\"quantity\" min=\"0\" max=\"10\" name=\"%s\" value=\"0\" type=\"number\" form=\"main-form\" />\n" +
//                        "                  <button type=\"button\" onclick=\"this.parentNode.querySelector('input[type=number]').stepUp()\" class=\"plus\"></button>\n" +
//                        "                </div>\n" +
//                        "                <input type=\"hidden\" name=\"formId\" value=\"Shop\" />\n" +
//                        "                <input type=\"hidden\" name=\"shopId\" value=\"shop3\" />\n" +
//                        "                <button type=\"submit\" class=\"add\">+ ADD</button>\n" +
//                        "              </form>\n" +
//                        "            </div>\n" +
//                        "          </div>\n" +
//                        "        </div>", itemCategory.equals("VEGETABLE") ? "vegetable" : itemCategory.equals("FRUIT") ? "fruit" : "grocery", item.getImageUrl(), item.getDescription(), item.getDescription(), item.getPrice(), item.getUnit(), item.getItemId()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.doEndTag();
    }
}
