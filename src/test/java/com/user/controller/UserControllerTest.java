package com.user.controller;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import com.user.entity.User;
import com.user.securiry.service.SecurityService;
import com.user.service.UserService;
import com.user.validator.UserValidator;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {
	
	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;

	@Mock
	Model model;
	
	@Mock
	User user;
	
	@Mock
	UserValidator userValidator;
	
	@Mock
	SecurityService securityService;
	
	@Mock
	Errors error;
	
	@Mock
	BindingResult bindingResult;
	
	@Test
	public void registrationTest(){
		
		User user = new User();
		user.setId((long) 1);
		user.setFirstName("Ranjith");
		user.setLastName("Indluru");
		user.setUsername("ranjith@gmail.com");
		user.setPassword("dfgh");
		userController.registration(model);
		
	}
	@Test
	public void registrationTest1() {
		
		
		user.setId((long) 1);
		user.setFirstName("Ranjith");
		user.setLastName("Indluru");
		user.setUsername("ranjith@gmail.com");
		user.setPassword("dfs");
		
		String username ="ranjith@gmail.com";
		String password ="ghd";
		userValidator.validate(user, bindingResult);
		
		
		userService.save(user);
		
		securityService.autoLogin(username, password);
		userController.registration(user, bindingResult);
	}
	
	@Test
	public void registrationTest2() {
		
		
		user.setId(null);
		user.setFirstName(null);
		user.setLastName(null);
		user.setUsername(null);
		user.setPassword(null);
		
		String username =null;
		String password =null;
		userValidator.validate(user, bindingResult);
		
		
		userService.save(user);
		
		securityService.autoLogin(username, password);
		userController.registration(user, bindingResult);
	}
	
	@Test
	public void login() {
		String error = "Your username and password is invalid.";
		String logout = "You have been logged out successfully.";
		userController.login(model, error, logout);
	}
}
