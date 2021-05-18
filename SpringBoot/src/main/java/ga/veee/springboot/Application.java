package ga.veee.springboot;

import ga.veee.springboot.mypack.HelloComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        MyComponent myComponent = ctx.getBean("myComponent", MyComponent.class);

        myComponent.doBusiness();

        HelloComponent helloComponent = ctx.getBean("helloComponent", HelloComponent.class);

        helloComponent.sayHello();
    }

}
