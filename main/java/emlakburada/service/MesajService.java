package emlakburada.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import emlakburada.dto.MessageRequest;
import emlakburada.dto.response.MessageResponse;
import emlakburada.model.Message;
import emlakburada.repository.MessageRepository;

@Service
public class MesajService {

	@Autowired
	MessageRepository messageRepository;
	
	
	public List<MessageResponse> getAllMessages() {
		List<MessageResponse> messageList = new ArrayList<>();
		for (Message message : MessageRepository.fetchAllMessages()) {
			messageList.add(convertToMessageResponse(message));
		}
		return messageList;
	}
	
	public MessageResponse saveMessage(MessageRequest request) {
		Message saveMessage = messageRepository.saveMessage(convertToMessage(request));
		

		return convertToMessageResponse(saveMessage);
	}
	
	
	private Message convertToMessage(MessageRequest request) {
		Message message = new Message();
		message.setBaslik(request.getTitle());
		message.setIcerigi(request.getContent());
		message.setGonderici(request.getSendUser());
		message.setAlici(request.getReceiveUser());
		
		return message;
	}
	
	
	private MessageResponse convertToMessageResponse(Message saveMessage) {
		MessageResponse response = new MessageResponse();
		response.setTitle(saveMessage.getBaslik());
		response.setContent(saveMessage.getIcerigi());
		response.setSendUser(saveMessage.getGonderici());
		response.setReceiveUser(saveMessage.getAlici());
		return response;
	}
	
	public MessageResponse getMessageById(int messageId) {
		Message message = messageRepository.findMessageById(messageId);
		return convertToMessageResponse(message);
	}
	
}
