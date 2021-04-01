package ga.veee.day19.DB.Table;

import ga.veee.day19.DB.DAO.CustomerDAO;
import ga.veee.day19.DB.DTO.CustomerDTO;
import ga.veee.day19.DB.Util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Customer implements CustomerDAO {

    @Override
    public CustomerDTO findByID(Integer customerId) {
        CustomerDTO customer = CustomerDTO.getCustomerDTO();
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM CUSTOMER WHERE CUSTOMER_ID=?");
            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                customer.setCUSTOMER_ID(resultSet.getInt(1));
                customer.setCUSTOMER_NAME(resultSet.getString(2));
                customer.setCUSTOMER_ADDRESS(resultSet.getString(3));
                customer.setCUSTOMER_PHONE(resultSet.getString(4));
                customer.setCUSTOMER_EMAIL(resultSet.getString(5));
                customer.setCUSTOMER_GST_NNO(resultSet.getString(6));
                ConnectionManager.closeConnection(null, null);
            }

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return customer;
    }

    @Override
    public List<CustomerDTO> findAll() {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM CUSTOMER");
            List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CustomerDTO customer = CustomerDTO.getCustomerDTO();
                customer.setCUSTOMER_ID(resultSet.getInt(1));
                customer.setCUSTOMER_NAME(resultSet.getString(2));
                customer.setCUSTOMER_ADDRESS(resultSet.getString(3));
                customer.setCUSTOMER_PHONE(resultSet.getString(4));
                customer.setCUSTOMER_EMAIL(resultSet.getString(5));
                customer.setCUSTOMER_GST_NNO(resultSet.getString(6));
                customers.add(customer);
            }
            return customers;

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return null;
    }

    @Override
    public int insertCustomer(CustomerDTO customerDTO) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO CUSTOMER VALUES (?,?,?,?,?,?)");
            statement.setInt(1, customerDTO.getCUSTOMER_ID());
            statement.setString(2, customerDTO.getCUSTOMER_NAME());
            statement.setString(3, customerDTO.getCUSTOMER_ADDRESS());
            statement.setString(4, customerDTO.getCUSTOMER_PHONE());
            statement.setString(5, customerDTO.getCUSTOMER_EMAIL());
            statement.setString(6, customerDTO.getCUSTOMER_GST_NNO());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public int updateCustomer(CustomerDTO customerDTO) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE CUSTOMER SET CUSTOMER_NAME = ?, CUSTOMER_ADDRESS = ?, CUSTOMER_PHONE = ?, CUSTOMER_EMAIL = ?, CUSTOMER_GST_NNO = ? WHERE CUSTOMER_ID = ?");
            statement.setString(1, customerDTO.getCUSTOMER_NAME());
            statement.setString(2, customerDTO.getCUSTOMER_ADDRESS());
            statement.setString(3, customerDTO.getCUSTOMER_PHONE());
            statement.setString(4, customerDTO.getCUSTOMER_EMAIL());
            statement.setString(5, customerDTO.getCUSTOMER_GST_NNO());
            statement.setInt(6, customerDTO.getCUSTOMER_ID());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public int deleteCustomerByID(Integer customerId) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM CUSTOMER WHERE CUSTOMER_ID=?");
            statement.setInt(1, customerId);
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public int deleteCustomerByDTO(CustomerDTO customerDTO) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM CUSTOMER WHERE CUSTOMER_ID = ? AND CUSTOMER_NAME = ? AND CUSTOMER_ADDRESS = ? AND CUSTOMER_PHONE = ? AND CUSTOMER_EMAIL = ? AND CUSTOMER_GST_NNO = ?");
            statement.setInt(1, customerDTO.getCUSTOMER_ID());
            statement.setString(2, customerDTO.getCUSTOMER_NAME());
            statement.setString(3, customerDTO.getCUSTOMER_ADDRESS());
            statement.setString(4, customerDTO.getCUSTOMER_PHONE());
            statement.setString(5, customerDTO.getCUSTOMER_EMAIL());
            statement.setString(6, customerDTO.getCUSTOMER_GST_NNO());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }
}
