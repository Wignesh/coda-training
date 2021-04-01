package ga.veee.day19.DB.DAO;

import ga.veee.day19.DB.DTO.InvoiceTransactionDTO;

import java.util.List;

public interface InvoiceTransactionDAO {
    public InvoiceTransactionDTO findByID(Integer invoiceId);

    public List<InvoiceTransactionDTO> findAll();

    public int insertInvoiceTransaction(InvoiceTransactionDTO invoiceTransactionDTO);

    public int updateInvoiceTransaction(InvoiceTransactionDTO invoiceTransactionDTO);

    public int deleteInvoiceTransactionByID(Integer invoiceId);

    public int deleteInvoiceTransactionByDTO(InvoiceTransactionDTO invoiceTransactionDTO);
}
