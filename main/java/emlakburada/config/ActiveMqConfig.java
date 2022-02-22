package emlakburada.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;


import com.rabbitmq.client.ConnectionFactory;

@Configuration
@EnableJms
public class ActiveMqConfig {
	
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
		
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		
		factory.setConnectionFactory((javax.jms.ConnectionFactory) connectionFactory);
		factory.setConcurrency("1-1");
		
		return factory;
		
	}

}
