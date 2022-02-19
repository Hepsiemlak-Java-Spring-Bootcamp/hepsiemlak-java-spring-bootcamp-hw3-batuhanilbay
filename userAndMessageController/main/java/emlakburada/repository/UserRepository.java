package emlakburada.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import emlakburada.model.User;

@Repository
public class UserRepository {

	
	private static List<User> userList = new ArrayList<>();
	
	
	static {
		userList.add(initUser("bbbb@gmail.com", "Batuhan"));
		userList.add(initUser("cemmdrmn@patika.com", "Cem"));
		userList.add(initUser("hepsiemlak@gmail.com", "Hepsi Emlak"));
		
		
	}
	

	
	public static List<User> fetchAllUsers() {
		return userList;
	}
	
	public User saveUser(User user) {
		userList.add(user);
		System.out.println(user.toString());
		return user;
	}
	
	private static User initUser(String mail, String name) {
		User user = new User();
		user.setEmail(mail);
		user.setIsim(name);
		
		return user;
		
	}
	
	public User findUserById(int userId) {
		return userList.stream().filter(user -> user.getUserId() == userId).findAny().orElse(new User());
	}	


}
