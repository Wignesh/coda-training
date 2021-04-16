package ga.veee.day23.daopack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class InvoiceTransactionDTOImpl implements InvoiceTransactionDAO, Cloneable {

    private static InvoiceTransactionDTOImpl invoiceTransactionDTOImpl;
    private static Properties dbConfigProp;

    public static InvoiceTransactionDTOImpl getInvoiceTransactionDTOImpl(Properties dbConfigProp) {
        if (invoiceTransactionDTOImpl == null) {
            InvoiceTransactionDTOImpl.dbConfigProp = dbConfigProp;
            invoiceTransactionDTOImpl = new InvoiceTransactionDTOImpl();
        }
        return invoiceTransactionDTOImpl.getClone();
    }

    public InvoiceTransactionDTOImpl getClone() {
        try {
            return (InvoiceTransactionDTOImpl) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public InvoiceTransactionDTOImpl() {
    }

    @Override
    public InvoiceTransactionDTO findById(int id) {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM INVOICE_TRANSACTION WHERE INVOICE_ID=?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            InvoiceTransactionDTO invoiceTransaction = new InvoiceTransactionDTO();
            if (resultSet.next()) {
                invoiceTransaction.setINVOICE_ID(resultSet.getInt(1));
                invoiceTransaction.setITEM_ID(resultSet.getInt(2));
                invoiceTransaction.setQTY(resultSet.getInt(3));
                ConnectionManager.closeConnection(null, null);
                return invoiceTransaction;
            }

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return null;
    }

    @Override
    public Set<InvoiceTransactionDTO> findAll() {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM INVOICE_TRANSACTION");
            Set<InvoiceTransactionDTO> invoiceTransactions = new HashSet<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                InvoiceTransactionDTO invoiceTransaction = new InvoiceTransactionDTO();
                invoiceTransaction.setINVOICE_ID(resultSet.getInt(1));
                invoiceTransaction.setITEM_ID(resultSet.getInt(2));
                invoiceTransaction.setQTY(resultSet.getInt(3));
                invoiceTransaction.setPRICE(resultSet.getFloat(4));
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
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO INVOICE_TRANSACTION VALUES (?,?,?,?)");
            statement.setInt(1, invoiceTransactionDTO.getINVOICE_ID());
            statement.setInt(2, invoiceTransactionDTO.getITEM_ID());
            statement.setInt(3, invoiceTransactionDTO.getQTY());
            statement.setFloat(4, invoiceTransactionDTO.getPRICE());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public int deleteInvoiceTransaction(int id) {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("DELETE FROM INVOICE_TRANSACTION WHERE INVOICE_ID=?");
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
    public int updateInvoiceTransaction(InvoiceTransactionDTO invoiceTransactionDTO) {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("UPDATE INVOICE_TRANSACTION SET INVOICE_ID = ?, ITEM_ID = ?, QTY = ?, PRICE = ?");
            statement.setInt(1, invoiceTransactionDTO.getINVOICE_ID());
            statement.setInt(2, invoiceTransactionDTO.getITEM_ID());
            statement.setInt(3, invoiceTransactionDTO.getQTY());
            statement.setFloat(4, invoiceTransactionDTO.getPRICE());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }
}
