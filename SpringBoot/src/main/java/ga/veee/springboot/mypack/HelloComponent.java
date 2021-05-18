package ga.veee.springboot.mypack;

import org.springframework.stereotype.Component;

@Component
public class HelloComponent {
    public void sayHello() {
        System.out.println("Hello from Spring");
    }
}
