package ga.veee.day21.DB.Table;

import ga.veee.day21.DB.DAO.UserDAO;
import ga.veee.day21.DB.DTO.UserDTO;
import ga.veee.day21.DB.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class User implements UserDAO {
    private User() {
    }

    @Override
    public UserDTO findByID(Integer userId) {
        UserDTO user = UserDTO.getUserDTO();
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USER WHERE USER_ID=?");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setUSER_ID(resultSet.getInt("USER_ID"));
                user.setUSER_NAME(resultSet.getString("USER_NAME"));
                user.setUSER_PASSWORD(resultSet.getString("USER_PASSWORD"));
                user.setFLAG(resultSet.getInt("FLAG"));
                ConnectionManager.closeConnection(null, null);
            }

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return user;
    }

    @Override
    public List<UserDTO> findAll() {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USER");
            List<UserDTO> users = new ArrayList<UserDTO>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                UserDTO user = UserDTO.getUserDTO();
                user.setUSER_ID(resultSet.getInt("USER_ID"));
                user.setUSER_NAME(resultSet.getString("USER_NAME"));
                user.setUSER_PASSWORD(resultSet.getString("USER_PASSWORD"));
                user.setFLAG(resultSet.getInt("FLAG"));
                users.add(user);
            }
            return users;

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return null;
    }

    @Override
    public int insertUser(UserDTO userDTO) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO USER VALUES (?,?,?,?)");
            statement.setInt(1, userDTO.getUSER_ID());
            statement.setString(2, userDTO.getUSER_NAME());
            statement.setString(3, userDTO.getUSER_PASSWORD());
            statement.setInt(4, userDTO.getFLAG());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public int updateUser(UserDTO userDTO) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("UPDATE USER SET USER_NAME=?, USER_PASSWORD=?, FLAG=? WHERE USER_ID=?");
            statement.setString(1, userDTO.getUSER_NAME());
            statement.setString(2, userDTO.getUSER_PASSWORD());
            statement.setInt(3, userDTO.getFLAG());
            statement.setInt(4, userDTO.getUSER_ID());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public int deleteUserByID(Integer userId) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE FROM USER WHERE USER_ID=?");
            statement.setInt(1, userId);
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public int deleteUserByDTO(UserDTO userDTO) {
        try {
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement statement = connection.prepareStatement("DELETE\n" +
                    "FROM USER\n" +
                    "WHERE USER_ID = ?\n" +
                    "  AND USER_NAME = ?\n" +
                    "  AND USER_PASSWORD = ?\n" +
                    "  AND FLAG = ?");
            statement.setInt(1, userDTO.getUSER_ID());
            statement.setString(2, userDTO.getUSER_NAME());
            statement.setString(3, userDTO.getUSER_PASSWORD());
            statement.setInt(4, userDTO.getFLAG());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }
}
