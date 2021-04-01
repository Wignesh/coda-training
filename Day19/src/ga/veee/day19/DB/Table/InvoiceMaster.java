package ga.veee.day19.DB.Table;

import ga.veee.day19.DB.DAO.InvoiceMasterDAO;
import ga.veee.day19.DB.DTO.InvoiceMasterDTO;
import ga.veee.day19.DB.DTO.InvoiceTransactionDTO;
import ga.veee.day19.DB.Util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InvoiceMaster implements InvoiceMasterDAO {
    @Override
    public InvoiceMasterDTO findByID(Integer invoiceId) {
        InvoiceMasterDTO invoiceMaster = InvoiceMasterDTO.getInvoiceMasterDTO();
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM INVOICE_MASTER WHERE INVOICE_ID=?");
            statement.setInt(1, invoiceId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                invoiceMaster.setINVOICE_ID(resultSet.getInt(1));
                invoiceMaster.setINVOICE_DATE(resultSet.getDate(2));
                invoiceMaster.setCUSTOMER_ID(resultSet.getInt(3));
                ConnectionManager.closeConnection(null, null);
            }

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return invoiceMaster;
    }

    @Override
    public List<InvoiceMasterDTO> findAll() {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM INVOICE_MASTER");
            List<InvoiceMasterDTO> invoiceMasters = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                InvoiceMasterDTO invoiceMaster = InvoiceMasterDTO.getInvoiceMasterDTO();
                invoiceMaster.setINVOICE_ID(resultSet.getInt(1));
                invoiceMaster.setINVOICE_DATE(resultSet.getDate(2));
                invoiceMaster.setCUSTOMER_ID(resultSet.getInt(3));
                invoiceMasters.add(invoiceMaster);
            }
            return invoiceMasters;

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return null;
    }

    @Override
    public int insertInvoiceMaster(InvoiceMasterDTO invoiceMasterDTO) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO INVOICE_MASTER VALUES (?,?,?)");
            statement.setInt(1, invoiceMasterDTO.getINVOICE_ID());
            statement.setDate(2, invoiceMasterDTO.getINVOICE_DATE());
            statement.setInt(3, invoiceMasterDTO.getCUSTOMER_ID());
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
    public int updateInvoiceMaster(InvoiceMasterDTO invoiceMasterDTO) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE INVOICE_MASTER SET INVOICE_DATE = ?, CUSTOMER_ID = ? WHERE INVOICE_ID = ?");
            statement.setDate(1, invoiceMasterDTO.getINVOICE_DATE());
            statement.setInt(2, invoiceMasterDTO.getCUSTOMER_ID());
            statement.setInt(3, invoiceMasterDTO.getINVOICE_ID());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public int deleteInvoiceMasterByID(Integer invoiceId) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM INVOICE_MASTER WHERE INVOICE_ID=?");
            statement.setInt(1, invoiceId);
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public int deleteInvoiceMasterByDTO(InvoiceMasterDTO invoiceMasterDTO) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM INVOICE_MASTER WHERE INVOICE_ID = ? AND INVOICE_DATE = ? AND CUSTOMER_ID = ?");
            statement.setInt(1, invoiceMasterDTO.getINVOICE_ID());
            statement.setDate(2, invoiceMasterDTO.getINVOICE_DATE());
            statement.setInt(3, invoiceMasterDTO.getCUSTOMER_ID());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }
}
