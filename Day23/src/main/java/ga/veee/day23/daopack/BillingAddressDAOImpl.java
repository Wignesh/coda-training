package ga.veee.day23.daopack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class BillingAddressDAOImpl implements BillingAddressDAO, Cloneable {
    private static BillingAddressDAOImpl billingAddressDAOImpl;
    private static Properties dbConfigProp;

    public static BillingAddressDAOImpl getBillingAddressDAOImpl(Properties dbConfigProp) {
        if (billingAddressDAOImpl == null) {
            BillingAddressDAOImpl.dbConfigProp = dbConfigProp;
            billingAddressDAOImpl = new BillingAddressDAOImpl();
        }
        return billingAddressDAOImpl.getClone();
    }

    public BillingAddressDAOImpl getClone() {
        try {
            return (BillingAddressDAOImpl) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public BillingAddressDAOImpl() {
    }

    @Override
    public BillingAddressDTO findById(int id) {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM BILLING_ADDRESS WHERE id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                BillingAddressDTO billingAddress = new BillingAddressDTO();
                billingAddress.setId(resultSet.getInt(1));
                billingAddress.setCutId(resultSet.getInt(2));
                billingAddress.setFname(resultSet.getString(3));
                billingAddress.setLaname(resultSet.getString(4));
                billingAddress.setAddress1(resultSet.getString(5));
                billingAddress.setAddress2(resultSet.getString(6));
                billingAddress.setRegion(resultSet.getString(7));
                billingAddress.setTown(resultSet.getString(8));
                billingAddress.setZip(resultSet.getString(9));
                billingAddress.setPhone(resultSet.getString(10));
                billingAddress.setEmail(resultSet.getString(11));
                ConnectionManager.closeConnection(null, null);
                return billingAddress;
            }
            ConnectionManager.closeConnection(null, null);

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return null;
    }

    @Override
    public Set<BillingAddressDTO> findByCustomerId(int id) {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM BILLING_ADDRESS WHERE customer_id = ?");
            statement.setInt(1, id);
            Set<BillingAddressDTO> billingAddresses = new HashSet<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BillingAddressDTO billingAddress = new BillingAddressDTO();
                billingAddress.setId(resultSet.getInt(1));
                billingAddress.setCutId(resultSet.getInt(2));
                billingAddress.setFname(resultSet.getString(3));
                billingAddress.setLaname(resultSet.getString(4));
                billingAddress.setAddress1(resultSet.getString(5));
                billingAddress.setAddress2(resultSet.getString(6));
                billingAddress.setRegion(resultSet.getString(7));
                billingAddress.setTown(resultSet.getString(8));
                billingAddress.setZip(resultSet.getString(9));
                billingAddress.setPhone(resultSet.getString(10));
                billingAddress.setEmail(resultSet.getString(11));
                billingAddresses.add(billingAddress);
            }
            ConnectionManager.closeConnection(null, null);
            return billingAddresses;

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return null;
    }

    @Override
    public Set<BillingAddressDTO> findAll() {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM BILLING_ADDRESS");
            Set<BillingAddressDTO> billingAddresses = new HashSet<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                BillingAddressDTO billingAddress = new BillingAddressDTO();
                billingAddress.setId(resultSet.getInt(1));
                billingAddress.setCutId(resultSet.getInt(2));
                billingAddress.setFname(resultSet.getString(3));
                billingAddress.setLaname(resultSet.getString(4));
                billingAddress.setAddress1(resultSet.getString(5));
                billingAddress.setAddress2(resultSet.getString(6));
                billingAddress.setRegion(resultSet.getString(7));
                billingAddress.setTown(resultSet.getString(8));
                billingAddress.setZip(resultSet.getString(9));
                billingAddress.setPhone(resultSet.getString(10));
                billingAddress.setEmail(resultSet.getString(11));
                billingAddresses.add(billingAddress);
            }
            ConnectionManager.closeConnection(null, null);
            return billingAddresses;

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return null;
    }

    @Override
    public int insertBillingAddress(BillingAddressDTO billingAddressDTO) {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO BILLING_ADDRESS VALUES (?,?,?,?,?,?,?,?,?,?,?)");

            statement.setInt(1, 0);
            statement.setInt(2, billingAddressDTO.getCutId());
            statement.setString(3, billingAddressDTO.getFname());
            statement.setString(4, billingAddressDTO.getLaname());
            statement.setString(5, billingAddressDTO.getAddress1());
            statement.setString(6, billingAddressDTO.getAddress2());
            statement.setString(7, billingAddressDTO.getRegion());
            statement.setString(8, billingAddressDTO.getTown());
            statement.setString(9, billingAddressDTO.getZip());
            statement.setString(10, billingAddressDTO.getPhone());
            statement.setString(11, billingAddressDTO.getEmail());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteBillingAddress(int id) {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("DELETE FROM BILLING_ADDRESS WHERE id = ?;");
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public int updateBillingAddress(BillingAddressDTO billingAddressDTO) {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("UPDATE BILLING_ADDRESS SET fname = ?, lname = ?, address1 = ?, address2 = ?, region = ?, town = ?, zip = ?, phone = ?, email = ? WHERE id = ?");
            statement.setString(1, billingAddressDTO.getFname());
            statement.setString(2, billingAddressDTO.getLaname());
            statement.setString(3, billingAddressDTO.getAddress1());
            statement.setString(4, billingAddressDTO.getAddress2());
            statement.setString(5, billingAddressDTO.getRegion());
            statement.setString(6, billingAddressDTO.getTown());
            statement.setString(7, billingAddressDTO.getZip());
            statement.setString(8, billingAddressDTO.getPhone());
            statement.setString(9, billingAddressDTO.getEmail());
            statement.setInt(10, billingAddressDTO.getId());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
            e.printStackTrace();
        }
        return 0;
    }
}
