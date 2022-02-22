package emlakburada.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import emlakburada.model.Message;
import emlakburada.model.User;





@Repository
public class MessageRepository {

	private static List<Message> messageList = new ArrayList<>();
	
	
	
	static {
		
		User user1 = new User("batuhan","bbb@gmail.com");
		User user2 = new User("emre","patika@devmmm");
		User user3 = new User("ayse","ayse@gsd.com");
		User user4 = new User("veli","kime@gmail.com");
		user1.getEmail();
		user2.getEmail();
		user3.getEmail();
		user4.getEmail();
		
	
		String send1 = user2.getEmail();
		String send2 = user4.getEmail();
		String receive1 = user1.getEmail().toString();
		String receive2 = user3.getEmail().toString();
		
		
		messageList.add(initMessage("Satilik İlan İçin", "Nereden ulasabilirim?",send1,receive1 ));
		messageList.add(initMessage("Kiralik İlan İçin", "Aidat ne kadar",send2,receive2 ));
	}


	public Message saveMessage(Message message) {
		messageList.add(message);
		System.out.println(message.toString());
		return message;
	}
	
	public static List<Message> fetchAllMessages(){
		return messageList;
		
	}
	
	
	//Mesaj için istenen özellikleri ekledim. Buraya daha farklı yapılar oluşturulabilir.
	private static Message initMessage(String title,String content,String sendUser,String receiveUser) {
		User user1 = new User();
		User user2 = new User();
		
		Message message = new Message();
		user1.setEmail(sendUser);
		user2.setEmail(receiveUser);
		message.setBaslik(title);
		message.setIcerigi(content);
		return message;
	}
	
	public Message findMessageById(int messageId) {
		return messageList.stream().filter(message -> message.getMessageId() == messageId).findAny().orElse(new Message());
	}
	
	
	
}
