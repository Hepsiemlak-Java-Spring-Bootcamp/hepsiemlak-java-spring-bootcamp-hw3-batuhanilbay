package emlakburada.dto.response;

import emlakburada.model.User;
import lombok.Data;

@Data
public class MessageResponse {
	
	
	private String title;
	private String content;
	private User sendUser;
	private User receiveUser;
	

}
