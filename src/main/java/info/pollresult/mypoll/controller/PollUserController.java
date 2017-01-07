package info.pollresult.mypoll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import info.pollresult.mypoll.model.PollUser;
import info.pollresult.mypoll.service.PollUserServiceImpl;

@RestController
public class PollUserController {
	
	@Autowired
	private PollUserServiceImpl pollUserServiceImpl;
	
	@PostMapping(value="/signup")
	public ResponseEntity createUser(@RequestBody PollUser pollUser){
		pollUserServiceImpl.signup(pollUser);
		return new ResponseEntity(pollUser, HttpStatus.OK);
	}
}
