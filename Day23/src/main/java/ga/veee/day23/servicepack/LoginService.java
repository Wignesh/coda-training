package ga.veee.day23.servicepack;

import ga.veee.day23.daopack.UserDTO;

public interface LoginService {
	public boolean checkUser(String uname,String upass);
	public boolean checkFlag(String uname);
	public int updateFlag(String uname,int flag);
	public int registerUser(int uid,String uname,String upass,int flag);
	public UserDTO getUserByUP(String u, String p);
}
