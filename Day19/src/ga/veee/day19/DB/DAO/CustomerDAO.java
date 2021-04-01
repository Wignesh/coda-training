package ga.veee.day19.DB.DAO;

import ga.veee.day19.DB.DTO.CustomerDTO;

import java.util.List;

public interface CustomerDAO {
    public CustomerDTO findByID(Integer customerId);

    public List<CustomerDTO> findAll();

    public int insertCustomer(CustomerDTO customerDTO);

    public int updateCustomer(CustomerDTO customerDTO);

    public int deleteCustomerByID(Integer customerId);

    public int deleteCustomerByDTO(CustomerDTO customerDTO);
}
