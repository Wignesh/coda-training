package ga.veee.springboot;

import ga.veee.springboot.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    @Autowired
    private MyService myService;

    public void doBusiness() {
        System.out.println(
                "Do business"
        );
        myService.doService();
    }

    public MyService getMyService() {
        return myService;
    }

    public void setMyService(MyService myService) {
        this.myService = myService;
    }
}
