package ga.veee.day19.DB.Table;

import ga.veee.day19.DB.DAO.InvoiceTransactionDAO;
import ga.veee.day19.DB.DTO.InvoiceTransactionDTO;
import ga.veee.day19.DB.Util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InvoiceTransaction implements InvoiceTransactionDAO {
    @Override
    public InvoiceTransactionDTO findByID(Integer invoiceId) {
        InvoiceTransactionDTO invoiceTransaction = InvoiceTransactionDTO.getInvoiceTransactionDTO();
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM INVOICE_TRANSACTION WHERE INVOICE_ID=?");
            statement.setInt(1, invoiceId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                invoiceTransaction.setINVOICE_ID(resultSet.getInt(1));
                invoiceTransaction.setITEM_ID(resultSet.getInt(2));
                invoiceTransaction.setQTY(resultSet.getInt(3));
                ConnectionManager.closeConnection(null, null);
            }

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return invoiceTransaction;
    }

    @Override
    public List<InvoiceTransactionDTO> findAll() {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM INVOICE_TRANSACTION");
            List<InvoiceTransactionDTO> invoiceTransactions = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                InvoiceTransactionDTO invoiceTransaction = InvoiceTransactionDTO.getInvoiceTransactionDTO();
                invoiceTransaction.setINVOICE_ID(resultSet.getInt(1));
                invoiceTransaction.setITEM_ID(resultSet.getInt(2));
                invoiceTransaction.setQTY(resultSet.getInt(3));
                invoiceTransactions.add(invoiceTransaction);
            }
            return invoiceTransactions;

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return null;
    }

    @Override
    public int insertInvoiceTransaction(InvoiceTransactionDTO invoiceTransactionDTO) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO INVOICE_TRANSACTION VALUES (?,?,?)");
            statement.setInt(1, invoiceTransactionDTO.getINVOICE_ID());
            statement.setInt(2, invoiceTransactionDTO.getITEM_ID());
            statement.setInt(3, invoiceTransactionDTO.getQTY());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public int updateInvoiceTransaction(InvoiceTransactionDTO invoiceTransactionDTO) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE INVOICE_TRANSACTION SET INVOICE_ID = ?, ITEM_ID = ?, QTY = ?");
            statement.setInt(1, invoiceTransactionDTO.getINVOICE_ID());
            statement.setInt(2, invoiceTransactionDTO.getITEM_ID());
            statement.setInt(3, invoiceTransactionDTO.getQTY());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public int deleteInvoiceTransactionByID(Integer invoiceId) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM INVOICE_TRANSACTION WHERE INVOICE_ID=?");
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
    public int deleteInvoiceTransactionByDTO(InvoiceTransactionDTO invoiceTransactionDTO) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM INVOICE_TRANSACTION WHERE INVOICE_ID = ? AND ITEM_ID = ? AND QTY = ?");
            statement.setInt(1, invoiceTransactionDTO.getINVOICE_ID());
            statement.setInt(2, invoiceTransactionDTO.getITEM_ID());
            statement.setInt(3, invoiceTransactionDTO.getQTY());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }
}
