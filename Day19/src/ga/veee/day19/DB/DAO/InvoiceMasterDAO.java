package ga.veee.day19.DB.DAO;

import ga.veee.day19.DB.DTO.InvoiceMasterDTO;

import java.util.List;

public interface InvoiceMasterDAO {
    public InvoiceMasterDTO findByID(Integer invoiceId);

    public List<InvoiceMasterDTO> findAll();

    public int insertInvoiceMaster(InvoiceMasterDTO invoiceMasterDTO);

    public int updateInvoiceMaster(InvoiceMasterDTO invoiceMasterDTO);

    public int deleteInvoiceMasterByID(Integer invoiceId);

    public int deleteInvoiceMasterByDTO(InvoiceMasterDTO invoiceMasterDTO);
}
