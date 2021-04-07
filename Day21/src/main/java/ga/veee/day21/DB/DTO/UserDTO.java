package ga.veee.day21.DB.DTO;

import java.io.Serializable;

public class UserDTO implements Serializable, Cloneable {
    private static UserDTO userDTO;
    private int USER_ID;
    private String USER_NAME;
    private String USER_PASSWORD;
    private int FLAG;

    synchronized public static UserDTO getUserDTO() {
        if (userDTO == null) {
            userDTO = new UserDTO();
        }
        return userDTO.getCloneUserDTO();
    }

    private UserDTO getCloneUserDTO() {
        try {
            return (UserDTO) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private UserDTO() {

    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getUSER_PASSWORD() {
        return USER_PASSWORD;
    }

    public void setUSER_PASSWORD(String USER_PASSWORD) {
        this.USER_PASSWORD = USER_PASSWORD;
    }

    public int getFLAG() {
        return FLAG;
    }

    public void setFLAG(int FLAG) {
        this.FLAG = FLAG;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "USER_ID=" + USER_ID +
                ", USER_NAME='" + USER_NAME + '\'' +
                ", USER_PASSWORD='" + USER_PASSWORD + '\'' +
                ", FLAG=" + FLAG +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (USER_ID != userDTO.USER_ID) return false;
        if (FLAG != userDTO.FLAG) return false;
        if (USER_NAME != null ? !USER_NAME.equals(userDTO.USER_NAME) : userDTO.USER_NAME != null) return false;
        return USER_PASSWORD != null ? USER_PASSWORD.equals(userDTO.USER_PASSWORD) : userDTO.USER_PASSWORD == null;
    }

    @Override
    public int hashCode() {
        int result = USER_ID;
        result = 31 * result + (USER_NAME != null ? USER_NAME.hashCode() : 0);
        result = 31 * result + (USER_PASSWORD != null ? USER_PASSWORD.hashCode() : 0);
        result = 31 * result + FLAG;
        return result;
    }
}
