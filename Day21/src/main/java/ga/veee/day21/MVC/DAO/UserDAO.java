package ga.veee.day21.MVC.DAO;

import ga.veee.day21.MVC.DTO.UserDTO;

import java.util.List;

public interface UserDAO {
    public UserDTO findByID(Integer userId);

    public List<UserDTO> findAll();

    public int insertUser(UserDTO userDTO);

    public int updateUser(UserDTO userDTO);

    public int deleteUserByID(Integer userId);

    public int deleteUserByDTO(UserDTO userDTO);
}
