package ga.veee.springboot.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MyDAO {
    public void doDataLogic() {
        System.out.println("Data Logic called");
    }
}
