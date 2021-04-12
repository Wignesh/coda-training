package ga.veee.day23.daopack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Set;

public class UserDAOImpl implements UserDAO, Cloneable {

    private UserDAOImpl() {
        // TODO Auto-generated constructor stub
    }

    private static UserDAOImpl userDaoImpl;
    private static Properties dbConfigProp;

    public static UserDAOImpl getUserDaoImpl(Properties dbConfigProp) {
        if (userDaoImpl == null) {
            UserDAOImpl.dbConfigProp = dbConfigProp;
            userDaoImpl = new UserDAOImpl();
        }
        return userDaoImpl.getClone();
    }

    public UserDAOImpl getClone() {
        try {
            return (UserDAOImpl) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public UserDTO findById(int uid) {
        return null;
    }

    @Override
    public Set<UserDTO> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insertUser(UserDTO userDTO) {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("INSERT INTO USER VALUES (?,?,?,?)");
            statement.setInt(1, userDTO.getUid());
            statement.setString(2, userDTO.getUname());
            statement.setString(3, userDTO.getUpass());
            statement.setInt(4, userDTO.getFlag());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public int deleteUser(int uid) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateUser(UserDTO userDTO) {
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("UPDATE USER SET USER_NAME=?, USER_PASSWORD=?, FLAG=? WHERE USER_ID=?");
            statement.setString(1, userDTO.getUname());
            statement.setString(2, userDTO.getUpass());
            statement.setInt(3, userDTO.getFlag());
            statement.setInt(4, userDTO.getUid());
            int result = statement.executeUpdate();
            ConnectionManager.closeConnection(null, null);
            return result;
        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return 0;
    }

    @Override
    public UserDTO findByName(String uname) {
        UserDTO user = new UserDTO();
        try {
            Connection connection = ConnectionManager.getConnection(dbConfigProp);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM USER WHERE USER_NAME=?");
            statement.setString(1, uname);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user.setUid(resultSet.getInt("USER_ID"));
                user.setUname(resultSet.getString("USER_NAME"));
                user.setUpass(resultSet.getString("USER_PASSWORD"));
                user.setFlag(resultSet.getInt("FLAG"));
                ConnectionManager.closeConnection(null, null);
                return user;
            }

        } catch (Exception e) {
            ConnectionManager.closeConnection(e, null);
        }
        return null;
    }

}
