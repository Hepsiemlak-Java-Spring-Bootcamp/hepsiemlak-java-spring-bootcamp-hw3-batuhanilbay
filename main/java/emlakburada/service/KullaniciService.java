package emlakburada.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import emlakburada.dto.UserRequest;
import emlakburada.dto.response.UserResponse;
import emlakburada.model.User;
import emlakburada.repository.DbConnectionRepository;
import emlakburada.repository.UserRepository;

@Service
public class KullaniciService {

	@Autowired
	@Qualifier(value = "mongoConnectionRepository")
	private DbConnectionRepository dbConn;

	@Autowired
	private UserRepository userRepository;


	
	public UserResponse saveUser(UserRequest request) {
		User saveUser = userRepository.saveUser(convertToUser(request));
		return convertToUserResponse(saveUser);
	}


	
	public List<UserResponse> getAllUsers() {
		List<UserResponse> userList = new ArrayList<>();
		for (User user : UserRepository.fetchAllUsers()) {
			userList.add(convertToUserResponse(user));
		}
		return userList;
	}
	
	
	private UserResponse convertToUserResponse(User saveUser) {
		UserResponse response = new UserResponse();
		response.setEmail(saveUser.getEmail());
		response.setIsim(saveUser.getIsim());
		response.setFavoriIlanlar(saveUser.getFavoriIlanlar());
		return response;
	}
	
	public UserResponse getUserById(int userId) {
		User user = userRepository.findUserById(userId);
		return convertToUserResponse(user);
	}
	
	private User convertToUser(UserRequest request) {
		User user = new User();
		user.setEmail(request.getMail());
		user.setIsim(request.getName());
		user.setFavoriIlanlar(request.getFavoriIlanlar());
		return user;
	}
	
	
}
