package ga.veee.day23.servicepack;


import ga.veee.day23.daopack.UserDAO;
import ga.veee.day23.daopack.UserDTO;

public class LoginServiceImpl implements LoginService, Cloneable {

    private LoginServiceImpl() {

    }

    private static LoginServiceImpl loginService;

    synchronized public static LoginServiceImpl getLoginService() {
        if (loginService == null) {
            loginService = new LoginServiceImpl();
        }
        return loginService.getClone();
    }

    public final UserDAO getUserDAO() {
        return userDAO;
    }

    public final void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public LoginServiceImpl getClone() {
        try {
            return (LoginServiceImpl) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private UserDAO userDAO;

    public LoginServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    public boolean checkUser(String uname, String upass) {
        UserDTO userDTO = userDAO.findByName(uname);
        if (userDTO != null) {
            if (userDTO.getUpass().equals(upass)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkFlag(String uname) {
        UserDTO userDTO = userDAO.findByName(uname);
        if (userDTO != null) {
            if (userDTO.getFlag() == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int updateFlag(String uname, int flag) {
        int n = 0;
        UserDTO userDTO = userDAO.findByName(uname);
        if (userDTO != null) {
            userDTO.setFlag(flag);
            n = userDAO.updateUser(userDTO);
        }

        return n;
    }

    @Override
    public int registerUser(int uid, String uname, String upass, int flag) {
        // TODO Auto-generated method stub
        UserDTO userDTO = new UserDTO(uid, uname, upass, flag);
        int n = userDAO.insertUser(userDTO);
        return n;
    }

    @Override
    public UserDTO getUserByUP(String u, String p) {
        return userDAO.getUserByUP(u, p);
    }

}
