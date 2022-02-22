package emlakburada.queue;


import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import emlakburada.service.EmailMessage;

@Component
public class ActiveMqService implements QueueService{

	@Autowired
	private JmsTemplate jmsTemplate;
	
	
	public void send(String content) {
		jmsTemplate.convertAndSend("Helloo",content);
	}
	
	@Override
	public void sendMessage(EmailMessage email,String message) {

		jmsTemplate.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage();
			
				return message;
			}
		});
		
	}



	@Override
	public void sendMessage(EmailMessage email) {
		
		
	}

}
