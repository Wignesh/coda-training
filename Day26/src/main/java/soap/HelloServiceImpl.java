package soap;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

//@HandlerChain(file = "soap/handler.xml")
@WebService(endpointInterface = "soap.HelloService")
public class HelloServiceImpl implements HelloService {
	
@WebMethod
@Override
public String sayHello(String name) {
	// TODO Auto-generated method stub
	return "Welcome to SOAP based Web Services....:"+name;
}
}
