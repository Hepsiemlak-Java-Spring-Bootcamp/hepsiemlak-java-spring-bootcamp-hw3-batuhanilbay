package emlakburada.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import emlakburada.dto.MessageRequest;
import emlakburada.dto.response.MessageResponse;
import emlakburada.service.MesajService;

@RestController
public class MessageController {

	@Autowired
	MesajService messageService;
	
	//FIND ALL MESSAGES
	@GetMapping(value = "/messages")
	public ResponseEntity<List<MessageResponse>> getAllMessage() {
		return new ResponseEntity<>(messageService.getAllMessages(), HttpStatus.OK);
	}
	

	//FIND ONE A MESSAGE
	@GetMapping(value = "/messages/{messageId}")
	public ResponseEntity<MessageResponse> getMessageById(@PathVariable(required = false) int messageId) {
		return new ResponseEntity<>(messageService.getMessageById(messageId), HttpStatus.OK);
	}
	
	
	//CREATE A MESSAGE
	@PostMapping(value = "/messages")
	public ResponseEntity<MessageResponse> createMessage(@RequestBody MessageRequest request) {
		return new ResponseEntity<>(messageService.saveMessage(request), HttpStatus.CREATED);
	}
	
	
}
