package ga.veee.springbootweb.component;

import ga.veee.springbootweb.model.UserEntity;
import ga.veee.springbootweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserComponent {

    @Autowired
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    public void addUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUid(100);
        userEntity.setUname("ramu");
        userEntity.setUpass("spider");
        userService.createUser(userEntity);
    }
}
