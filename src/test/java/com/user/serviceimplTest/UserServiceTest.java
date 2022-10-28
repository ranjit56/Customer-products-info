package com.user.serviceimplTest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.user.entity.Role;
import com.user.entity.User;
import com.user.repository.RoleRepository;
import com.user.repository.UserRepository;
import com.user.service.UserServiceImpl;

@SpringBootTest(classes= {UserServiceTest.class})
//@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@Mock
	UserRepository userRepository;
	@Mock
	RoleRepository roleRepository;
	
	@Mock
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Test
	public void saveTest() {
		User user = new User();
		user.setId((long) 1);
		user.setFirstName("Ranjith");
		user.setLastName("Indluru");
		user.setUsername("ranjith56@gmail.com");
		user.setPassword("ranjith5666");
		Role role = new Role();
		role.setId((long) 1);
		role.setName("USER");

		Set<Role> roles = new HashSet<Role>(roleRepository.findAll());
		user.setRoles(roles);
		roles.add(role);
		when(userRepository.save(user)).thenReturn(user);
		userServiceImpl.save(user);
	}
	@Test
	public void findByUsernameTest() {
		User user = new User();
		user.setId((long) 1);
		user.setFirstName("Ranjith");
		user.setLastName("Indluru");
		user.setUsername("ranjith56@gmail.com");
		user.setPassword("ranjith5666");
		String username="ranjith56@gmail.com";
		when(userRepository.findByUsername(username)).thenReturn(user);
		userServiceImpl.findByUsername(username);
	}
}
