package ga.veee.day23.daopack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface ItemDAO {
    public ItemDTO findById(int itemId);

    public Set<ItemDTO> findAll();
    public Set<ItemDTO> findAll(int limit);

    public Set<ItemDTO> findAllByCat(String category);

    public Set<ItemDTO> findAllByCat(String category,int limit);

    public Set<ItemDTO> findInIds(List<Integer> ids);

    public int insertItem(ItemDTO itemDTO);

    public int deleteItem(int itemId);

    public int updateItem(ItemDTO itemDTO);

    public ItemDTO findByName(String itemName);
}
