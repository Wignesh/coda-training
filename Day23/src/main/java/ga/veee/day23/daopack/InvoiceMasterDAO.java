package ga.veee.day23.daopack;

import java.util.Set;

public interface InvoiceMasterDAO {
    public InvoiceMasterDTO findById(int id);

    public Set<InvoiceMasterDTO> findByCustomerId(int id);

    public Set<InvoiceMasterDTO> findAll();

    public int insertInvoiceMaster(InvoiceMasterDTO invoiceMasterDTO);

    public int deleteInvoiceMaster(int id);

    public int getLastInvoiceId();

    public int updateInvoiceMaster(InvoiceMasterDTO invoiceMasterDTO);
}
