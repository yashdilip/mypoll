package info.pollresult.mypoll.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.pollresult.mypoll.model.PollUser;
import info.pollresult.mypoll.model.User;
import info.pollresult.mypoll.service.PollUserServiceImpl;
import info.pollresult.mypoll.service.SecurityServiceImpl;
import info.pollresult.mypoll.service.UserServiceImpl;
import info.pollresult.mypoll.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private SecurityServiceImpl securityService;
	
	@Autowired
	private PollUserServiceImpl pollUserService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") @Validated User userForm, BindingResult bindingResult,
			Model model) {

		// userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		} else {
			userService.save(userForm);
			PollUser pollUser = new PollUser();
			pollUser.setUserName(userForm.getUsername());
			pollUserService.createPollUser(pollUser);

			securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

			return "redirect:/welcome";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {				
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	
	@RequestMapping(value="/update-profile", method = RequestMethod.GET)
	public String updateProfileForm(Model model, Principal principal){
		//org.springframework.security.core.userdetails.User usr = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//String username = usr.getUsername();
		
		PollUser pollUser = pollUserService.findByUsername(principal.getName());

		model.addAttribute("pollUser", pollUser);
		/*
		if(pollUser!=null){
			model.addAttribute("pollUser", pollUser);
		}*/
		return "update-profile";
	}
	
	/*@RequestMapping(value = "/update-profile", method = RequestMethod.POST)
	public String updateProfileFormProcess(@ModelAttribute("pollUserForm") @Validated PollUser pollUserForm, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			return "update-profile";
		}
		
		return "redirect:/welcome";
	}*/
	
	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(Model model) {
		return "welcome";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}
}
