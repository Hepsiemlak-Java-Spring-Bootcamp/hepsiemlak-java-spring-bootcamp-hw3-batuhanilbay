package emlakburada.dto;

import java.util.HashSet;
import java.util.Set;

import emlakburada.model.Advert;
import lombok.Data;

@Data
public class UserRequest {


	private String mail;
	private String name;
	private Set<Advert> favoriIlanlar = new HashSet<>();
	private int userId;
	
	
}
