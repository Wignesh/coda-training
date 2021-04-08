package ga.veee.day22.daopack;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class ItemDAOImpl implements ItemDAO, Cloneable {
    private static ItemDAOImpl itemDAOImpl;
    private static Properties dbConfigProp;

    public static ItemDAOImpl getItemDaoImpl(Properties dbConfigProp) {
        if (itemDAOImpl == null) {
            ItemDAOImpl.dbConfigProp = dbConfigProp;
            itemDAOImpl = new ItemDAOImpl();
        }
        return itemDAOImpl.getClone();
    }

    public ItemDAOImpl getClone() {
        try {
            return (ItemDAOImpl) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ItemDAOImpl() {
    }

    @Override
    public ItemDTO findById(int itemId) {
        return null;
    }

    @Override
    public Set<ItemDTO> findAll() {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ITEM_MASTER");
            Set<ItemDTO> items = new HashSet<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ItemDTO item = new ItemDTO();
                item.setItemId(resultSet.getInt(1));
                item.setDescription(resultSet.getString(2));
                item.setPrice(resultSet.getFloat(3));
                item.setCategory(resultSet.getString(4));
                item.setUnit(resultSet.getString(5));
                item.setImageUrl(resultSet.getString(6));
                items.add(item);
            }
            return items;

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return null;
    }

    @Override
    public Set<ItemDTO> findAllByCat(String category) {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ITEM_MASTER WHERE CATEGORY = ?");
            statement.setString(1, category);
            Set<ItemDTO> items = new HashSet<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ItemDTO item = new ItemDTO();
                item.setItemId(resultSet.getInt(1));
                item.setDescription(resultSet.getString(2));
                item.setPrice(resultSet.getFloat(3));
                item.setCategory(resultSet.getString(4));
                item.setUnit(resultSet.getString(5));
                item.setImageUrl(resultSet.getString(6));
                items.add(item);
            }
            return items;

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return null;
    }

    @Override
    public Set<ItemDTO> findInIds(ArrayList<Integer> ids) {
        try {
            System.out.println(ids);
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ITEM_MASTER WHERE ID IN = (?)");
            statement.setArray(1, (Array) ids);
            Set<ItemDTO> items = new HashSet<>();
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet.getFetchSize());
            while (resultSet.next()) {
                ItemDTO item = new ItemDTO();
                item.setItemId(resultSet.getInt(1));
                item.setDescription(resultSet.getString(2));
                item.setPrice(resultSet.getFloat(3));
                item.setCategory(resultSet.getString(4));
                item.setUnit(resultSet.getString(5));
                item.setImageUrl(resultSet.getString(6));
                items.add(item);
            }
            return items;

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return null;
    }

    @Override
    public int insertItem(ItemDTO itemDTO) {
        return 0;
    }

    @Override
    public int deleteItem(int itemId) {
        return 0;
    }

    @Override
    public int updateItem(ItemDTO itemDTO) {
        return 0;
    }

    @Override
    public ItemDTO findByName(String itemName) {
        return null;
    }
}
