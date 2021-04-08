package ga.veee.day21.MVC;

import ga.veee.day21.MVC.DTO.UserDTO;
import ga.veee.day21.MVC.Table.User;


public class AuthService {
    public UserDTO checkUser(String username, String password) {
        return new User().findUser(username, password);
    }

    public int updateFlag(UserDTO userDTO){
        return new User().updateUser(userDTO);
    }
}
