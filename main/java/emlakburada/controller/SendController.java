package emlakburada.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import emlakburada.queue.ActiveMqService;

@RestController
public class SendController {
	
	private ActiveMqService activeMqService;
	
	@GetMapping("/sends")
	public String sendMessage(@PathVariable("content") String content) {
		activeMqService.send(content);
		return content;
		
		
	}

}
