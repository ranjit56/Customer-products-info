package com.user.serviceimplTest;

import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.user.entity.Role;
import com.user.entity.User;
import com.user.repository.UserRepository;
import com.user.service.UserDetailsServiceImpl;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)

public class UserDetailsServiceImplTest {
	
	@InjectMocks
	UserDetailsServiceImpl userDetailsServiceImpl;
	@Mock
	UserRepository userRepository;
	
	
	@Test
	public void loadUserByUsernameTest() {
		
		User user = new User();
		user.setId((long) 1);
		user.setFirstName("Ranjith");
		user.setLastName("Indluru");
		user.setUsername("ranjit@gmail.com");
		user.setPassword("wertyu");
		
		Role role = new Role();
		role.setId((long) 1);
		role.setName("user");
	
		
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRoles(roles);
		
		String username = "ranjith@gmail.com";
		when(userRepository.findByUsername(username)).thenReturn(user);
		userDetailsServiceImpl.loadUserByUsername(username);
	}
	
	@Test
	public void loadUserByUsernameTest_Exception() {
		
		User user = new User();
		user.setId((long) 1);
		user.setFirstName("Ranjith");
		user.setLastName("Indluru");
		user.setUsername("ranjit@gmail.com");
		user.setPassword("wertyu");
		
		Role role = new Role();
		role.setId((long) 1);
		role.setName("user");
	
		
		Set<Role> roles = new HashSet<>();
		roles.add(role);
		user.setRoles(roles);
		
		String username = "ranjith@gmail.com";
		when(userRepository.findByUsername(username)).thenReturn(user);
		userDetailsServiceImpl.loadUserByUsername(null);
	}

}
