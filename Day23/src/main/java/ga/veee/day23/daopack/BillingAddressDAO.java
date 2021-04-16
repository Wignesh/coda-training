package ga.veee.day23.daopack;

import java.util.Set;

public interface BillingAddressDAO {
    public BillingAddressDTO findById(int id);

    public Set<BillingAddressDTO> findByCustomerId(int id);

    public Set<BillingAddressDTO> findAll();

    public int insertBillingAddress(BillingAddressDTO billingAddressDTO);

    public int deleteBillingAddress(int id);

    public int updateBillingAddress(BillingAddressDTO billingAddressDTO);
}
