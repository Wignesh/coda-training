package ga.veee.day19.DB.Table;

import ga.veee.day19.DB.DAO.ItemMasterDAO;
import ga.veee.day19.DB.DTO.ItemMasterDTO;
import ga.veee.day19.DB.Util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemMaster implements ItemMasterDAO {

    @Override
    public ItemMasterDTO findByID(Integer itemId) {
        ItemMasterDTO item = ItemMasterDTO.getItemDTO();
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ITEM_MASTER WHERE ITEM_ID=?");
            statement.setInt(1, itemId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                item.setITEM_ID(resultSet.getInt(1));
                item.setDESCRIPTION(resultSet.getString(2));
                item.setPRICE(resultSet.getFloat(3));
                ConnectionManager.closeConnection(null, null);
            }

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return item;
    }

    @Override
    public List<ItemMasterDTO> findAll() {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ITEM_MASTER");
            List<ItemMasterDTO> items = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ItemMasterDTO item = ItemMasterDTO.getItemDTO();
                item.setITEM_ID(resultSet.getInt(1));
                item.setDESCRIPTION(resultSet.getString(2));
                item.setPRICE(resultSet.getFloat(3));
                items.add(item);
            }
            return items;

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return null;
    }

    @Override
    public int deleteItemByID(Integer itemId) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM ITEM_MASTER WHERE ITEM_ID=?");
            statement.setInt(1, itemId);
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public int deleteItemByDTO(ItemMasterDTO itemMasterDTO) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM ITEM_MASTER WHERE ITEM_ID = ? AND DESCRIPTION = ? AND PRICE = ?");
            statement.setInt(1, itemMasterDTO.getITEM_ID());
            statement.setString(2, itemMasterDTO.getDESCRIPTION());
            statement.setFloat(3, itemMasterDTO.getPRICE());
            System.out.println(statement.toString());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public int updateItem(ItemMasterDTO itemMasterDTO) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE ITEM_MASTER SET DESCRIPTION = ?, PRICE = ? WHERE ITEM_ID = ?");
            statement.setString(1, itemMasterDTO.getDESCRIPTION());
            statement.setFloat(2, itemMasterDTO.getPRICE());
            statement.setInt(3, itemMasterDTO.getITEM_ID());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public int insertItem(ItemMasterDTO itemMasterDTO) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO ITEM_MASTER VALUES (?,?,?)");
            statement.setInt(1, itemMasterDTO.getITEM_ID());
            statement.setString(2, itemMasterDTO.getDESCRIPTION());
            statement.setFloat(3, itemMasterDTO.getPRICE());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }
}
