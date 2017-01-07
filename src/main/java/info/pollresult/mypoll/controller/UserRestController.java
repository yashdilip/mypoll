package info.pollresult.mypoll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.pollresult.mypoll.model.User;
import info.pollresult.mypoll.service.SecurityServiceImpl;
import info.pollresult.mypoll.service.UserServiceImpl;
import info.pollresult.mypoll.validator.UserValidator;

@RestController
@RequestMapping(value = "/rest")
public class UserRestController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private SecurityServiceImpl securityService;

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private BCryptPasswordEncoder encode;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ResponseEntity registration(@RequestBody @Validated User user, BindingResult bindingResult) {

		userValidator.validate(user, bindingResult);

		if (bindingResult.hasErrors()) {
			return new ResponseEntity("error occurred", HttpStatus.BAD_REQUEST);
		}

		userService.save(user);
		securityService.autologin(user.getUsername(), user.getPasswordConfirm());
		return new ResponseEntity(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/loginuser", method = RequestMethod.GET)
	public ResponseEntity login(@RequestHeader(value = "username") String username,
			@RequestHeader(value = "password") String password) {

		User user = userService.findByUsername(username);
	
		if (user != null) {
			if (!username.equals(user.getUsername())) {
				return new ResponseEntity("Username not matched!", HttpStatus.NOT_FOUND);
			} else if(!encode.matches(password, user.getPassword())){
				return new ResponseEntity("Password wrong!", HttpStatus.FORBIDDEN);
			}
			securityService.autologin(username, password);
			return new ResponseEntity("success"+" "+user.getUsername(), HttpStatus.OK);
		}
		return new ResponseEntity("User does not exist!", HttpStatus.FORBIDDEN);
		
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}
}
