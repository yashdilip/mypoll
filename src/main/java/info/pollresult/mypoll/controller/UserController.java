package info.pollresult.mypoll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import info.pollresult.mypoll.model.User;
import info.pollresult.mypoll.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping(value="/signup")
	public ResponseEntity createUser(@RequestBody User user){
		userServiceImpl.signup(user);
		return new ResponseEntity(user, HttpStatus.OK);
	}
}
