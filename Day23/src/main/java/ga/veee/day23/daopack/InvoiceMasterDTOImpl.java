package ga.veee.day23.daopack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class InvoiceMasterDTOImpl implements InvoiceMasterDAO, Cloneable {
    private static InvoiceMasterDTOImpl invoiceMasterDTOImpl;
    private static Properties dbConfigProp;

    public static InvoiceMasterDTOImpl getInvoiceMasterDTOImpl(Properties dbConfigProp) {
        if (invoiceMasterDTOImpl == null) {
            InvoiceMasterDTOImpl.dbConfigProp = dbConfigProp;
            invoiceMasterDTOImpl = new InvoiceMasterDTOImpl();
        }
        return invoiceMasterDTOImpl.getClone();
    }

    public InvoiceMasterDTOImpl getClone() {
        try {
            return (InvoiceMasterDTOImpl) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public InvoiceMasterDTOImpl() {
    }

    @Override
    public InvoiceMasterDTO findById(int id) {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            InvoiceMasterDTO invoiceMaster = new InvoiceMasterDTO();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM INVOICE_MASTER WHERE INVOICE_ID=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                invoiceMaster.setINVOICE_ID(resultSet.getInt(1));
                invoiceMaster.setINVOICE_DATE(resultSet.getString(2));
                invoiceMaster.setCUSTOMER_ID(resultSet.getInt(3));
                invoiceMaster.setBILLING_ADDRESS(resultSet.getInt(4));
                ConnectionManager.closeConnection(null, null);
                return invoiceMaster;
            }

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return null;
    }

    @Override
    public Set<InvoiceMasterDTO> findByCustomerId(int id) {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM INVOICE_MASTER WHERE CUSTOMER_ID=?");
            statement.setInt(1, id);
            Set<InvoiceMasterDTO> invoiceMasters = new HashSet<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                InvoiceMasterDTO invoiceMaster = new InvoiceMasterDTO();
                invoiceMaster.setINVOICE_ID(resultSet.getInt(1));
                invoiceMaster.setINVOICE_DATE(resultSet.getString(2));
                invoiceMaster.setCUSTOMER_ID(resultSet.getInt(3));
                invoiceMaster.setBILLING_ADDRESS(resultSet.getInt(4));
                invoiceMasters.add(invoiceMaster);
            }
            ConnectionManager.closeConnection(null, null);
            return invoiceMasters;

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return null;
    }

    @Override
    public Set<InvoiceMasterDTO> findAll() {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM INVOICE_MASTER");
            Set<InvoiceMasterDTO> invoiceMasters = new HashSet<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                InvoiceMasterDTO invoiceMaster = new InvoiceMasterDTO();
                invoiceMaster.setINVOICE_ID(resultSet.getInt(1));
                invoiceMaster.setINVOICE_DATE(resultSet.getString(2));
                invoiceMaster.setCUSTOMER_ID(resultSet.getInt(3));
                invoiceMaster.setBILLING_ADDRESS(resultSet.getInt(4));
                invoiceMasters.add(invoiceMaster);
            }
            ConnectionManager.closeConnection(null, null);
            return invoiceMasters;

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return null;
    }

    @Override
    public int insertInvoiceMaster(InvoiceMasterDTO invoiceMasterDTO) {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO INVOICE_MASTER VALUES (?,?,?,?)");
            statement.setInt(1, invoiceMasterDTO.getINVOICE_ID());
            statement.setString(2, invoiceMasterDTO.getINVOICE_DATE());
            statement.setInt(3, invoiceMasterDTO.getCUSTOMER_ID());
            statement.setInt(4, invoiceMasterDTO.getBILLING_ADDRESS());
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
    public int deleteInvoiceMaster(int id) {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("DELETE FROM INVOICE_MASTER WHERE INVOICE_ID=?");
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
    public int getLastInvoiceId() {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("SELECT INVOICE_ID FROM INVOICE_MASTER ORDER BY INVOICE_ID DESC LIMIT 1");
            ResultSet resultSet = statement.executeQuery();
            int id = 0;
            while (resultSet.next()){
                id=resultSet.getInt(1);
            }
            ConnectionManager.closeConnection(null, null);
            return id;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateInvoiceMaster(InvoiceMasterDTO invoiceMasterDTO) {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("UPDATE INVOICE_MASTER SET INVOICE_DATE = ?, CUSTOMER_ID = ?, BILLING_ADDRESS = ? WHERE INVOICE_ID = ?");
            statement.setString(1, invoiceMasterDTO.getINVOICE_DATE());
            statement.setInt(2, invoiceMasterDTO.getCUSTOMER_ID());
            statement.setInt(2, invoiceMasterDTO.getBILLING_ADDRESS());
            statement.setInt(3, invoiceMasterDTO.getINVOICE_ID());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }
}
