package ga.veee.day23.control;

import ga.veee.day23.daopack.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Properties;

public class AddressAction extends Action {
    private static Properties dbConfigProp;

    public AddressAction(Properties dbConfigProp) {
        AddressAction.dbConfigProp = dbConfigProp;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String formId = request.getParameter("formId");
        String actionId = request.getParameter("actionId");

        UserDAOImpl userDaoImpl = UserDAOImpl.getUserDaoImpl(dbConfigProp);
        BillingAddressDAOImpl billingAddressDAOImpl = BillingAddressDAOImpl.getBillingAddressDAOImpl(dbConfigProp);
        HttpSession session = request.getSession();
        if (request.getSession().getAttribute("uname") != null) {
            switch (actionId) {
                case "add":
                    addAddress(request, userDaoImpl, billingAddressDAOImpl, session);
                    return "checkout";
                case "update":
                    updateAddress(request, userDaoImpl, billingAddressDAOImpl, session);
                    return "cart";
            }
        }
        return "cart";
    }

    private int updateAddress(HttpServletRequest request, UserDAOImpl userDaoImpl, BillingAddressDAOImpl billingAddressDAOImpl, HttpSession session) {
        int id = Integer.parseInt(request.getParameter("addressId"));
        String fname = request.getParameter("firstName").toString();
        String lname = request.getParameter("lastName").toString();
        String address1 = request.getParameter("streetAddress1").toString();
        String address2 = request.getParameter("streetAddress2").toString();
        String region = request.getParameter("region").toString();
        String town = request.getParameter("district").toString();
        String zip = request.getParameter("zip").toString();
        String phone = request.getParameter("phone").toString();
        String email = request.getParameter("email").toString();
        BillingAddressDTO billingAddressDTO = new BillingAddressDTO(id, 0, fname, lname, address1, address2, region, town, zip, phone, email);
        int result = billingAddressDAOImpl.updateBillingAddress(billingAddressDTO);
        return result;
    }

    private int addAddress(HttpServletRequest request, UserDAOImpl userDaoImpl, BillingAddressDAOImpl billingAddressDAOImpl, HttpSession session) {
        String uname = request.getSession().getAttribute("uname").toString();
        UserDTO userDTO = userDaoImpl.findByName(uname);
        int cutId = userDTO.getUid();
        String fname = request.getParameter("firstName").toString();
        String lname = request.getParameter("lastName").toString();
        String address1 = request.getParameter("streetAddress1").toString();
        String address2 = request.getParameter("streetAddress2").toString();
        String region = request.getParameter("region").toString();
        String town = request.getParameter("district").toString();
        String zip = request.getParameter("zip").toString();
        String phone = request.getParameter("phone").toString();
        String email = request.getParameter("email").toString();
        BillingAddressDTO billingAddressDTO = new BillingAddressDTO(0, cutId, fname, lname, address1, address2, region, town, zip, phone, email);
        int result = billingAddressDAOImpl.insertBillingAddress(billingAddressDTO);
        return result;
    }

}
