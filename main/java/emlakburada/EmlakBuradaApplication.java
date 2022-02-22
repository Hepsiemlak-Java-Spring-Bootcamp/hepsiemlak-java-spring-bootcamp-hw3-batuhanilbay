package emlakburada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;



@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableJms
@ComponentScan(basePackages = "com.emlakburada.*")
public class EmlakBuradaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmlakBuradaApplication.class, args);

		/*Singleton singleton = Singleton.getSingletonInstance();
		
		System.out.println(singleton.toString());
		
		
		Singleton singleton1 = Singleton.getSingletonInstance();
		
		System.out.println(singleton1.toString());*/
		
		
	}

}
