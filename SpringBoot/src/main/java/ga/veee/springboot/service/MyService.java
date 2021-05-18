package ga.veee.springboot.service;

import ga.veee.springboot.dao.MyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {
    @Autowired
    private MyDAO myDAO;

    public MyDAO getMyDAO() {
        return myDAO;
    }

    public void setMyDAO(MyDAO myDAO) {
        this.myDAO = myDAO;
    }

    public void doService() {
        System.out.println("Service logic called");
        myDAO.doDataLogic();
    }
}
