package com.dvir.spring.test.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dvir.spring.test.web.dao.User;
import com.dvir.spring.test.web.service.UsersService;

@Controller
public class LoginController {
	private UsersService userService;

	@RequestMapping("/login")
	public String showLogin() {
		return "login";

	}

	@RequestMapping("/newAccount")
	public String showNewAccount(Model model) {

		model.addAttribute("user", new User());

		return "NewAccount";

	}

	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			return "NewAccount";
		}
		user.setEnabled(true);
		user.setAuthority("admin");

		if (userService.exits(user.getUsername())) {
			System.out.println("Found DuplicateKey for username <" + user.getUsername() + ">");
			result.rejectValue("username", "DuplicateKey.user.username", "this user already exits in the DB");
			return "NewAccount";
		}

		userService.create(user);

		return "AccountCreated";
	}

	@Autowired
	public void setUserService(UsersService userService) {
		this.userService = userService;
	}

}
