package ga.veee.day23.daopack;

import java.util.Set;

public interface InvoiceTransactionDAO {
    public InvoiceTransactionDTO findById(int id);

    public Set<InvoiceTransactionDTO> findAll();

    public int insertInvoiceTransaction(InvoiceTransactionDTO invoiceTransactionDTO);

    public int deleteInvoiceTransaction(int id);

    public int updateInvoiceTransaction(InvoiceTransactionDTO invoiceTransactionDTO);
}
