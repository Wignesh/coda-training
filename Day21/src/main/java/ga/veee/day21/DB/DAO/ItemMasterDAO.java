package ga.veee.day21.DB.DAO;

import ga.veee.day21.DB.DTO.ItemMasterDTO;

import java.util.List;


public interface ItemMasterDAO {
    public ItemMasterDTO findByID(Integer itemId);

    public List<ItemMasterDTO> findAll();

    public int insertItem(ItemMasterDTO itemMasterDTO);

    public int updateItem(ItemMasterDTO itemMasterDTO);

    public int deleteItemByID(Integer itemId);

    public int deleteItemByDTO(ItemMasterDTO itemMasterDTO);
}
