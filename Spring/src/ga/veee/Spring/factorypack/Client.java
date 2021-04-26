package ga.veee.Spring.factorypack;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("ga/veee/Spring/spring-config.xml");
		
		ShoeSeller shop=(ShoeSeller)ctx.getBean("advisedShop");
		Customer customer=new Customer();
		customer.setName("ramu");
		Shoe shoe=shop.sellShoe(customer);
		System.out.println(shoe);
		shop.sellShoe(customer);
		ctx.close();
	}
}
