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
import emlakburada.dto.UserRequest;
import emlakburada.dto.response.UserResponse;
import emlakburada.service.KullaniciService;

@RestController
public class UserController {

	@Autowired
	KullaniciService userService;
	
	//FIND ALL USERS
	@GetMapping(value = "/users")
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
	}
	
	//CREATE A USER
	@PostMapping(value = "/users")
	public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
		return new ResponseEntity<>(userService.saveUser(request), HttpStatus.CREATED);
	}

	//FIND ONE A USER
	@GetMapping(value = "/users/{userId}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable(required = false) int userId) {
		return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
	}
	

	
	
}
