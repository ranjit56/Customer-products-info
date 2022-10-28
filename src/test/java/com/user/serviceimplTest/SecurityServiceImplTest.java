package com.user.serviceimplTest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.user.entity.User;
import com.user.securiry.service.SecurityServiceImpl;

@SpringBootTest(classes= {SecurityServiceImplTest.class})
public class SecurityServiceImplTest {
	
	@InjectMocks
	SecurityServiceImpl securityServiceImpl;
	
	@Mock
	UserDetailsService userDetailsService;
	
	@Mock
	AuthenticationManager authenticationManager;
	
	@Mock
	UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken;
	
	@Mock
	UserDetails userDetails;
	
	@Test
	public void findLoggedInUsernameTest() {
		
	}
	
	@Test
	public void autoLogin() {
		
		String username = "ran";
		String password = "fgh";
		userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, password, userDetails.getAuthorities());
		

		authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		securityServiceImpl.autoLogin(username, password);
	}

}
