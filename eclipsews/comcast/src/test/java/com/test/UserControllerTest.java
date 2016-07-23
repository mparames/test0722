package com.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.codingtest.controller.UserController;
import com.codingtest.dao.IUserDAO;
import com.codingtest.dao.UserDAO;
import com.codingtest.model.User;
import com.codingtest.service.IUserService;
import com.codingtest.service.UserService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest {
	
	@Mock
    private IUserService userService;
 
	@Mock
    private IUserDAO userDAO;
 
    @InjectMocks
    private UserController userController;
    
    MockMvc mockMvc;
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);	 
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();	 
    }	 
	 
	@Test
    public void testGetUser() throws Exception {
		User user = new User("johndoe", "jdoe@test.com", "04/07/2016");
		when(userService.save(user)).thenReturn(user); 
		when(userService.getByName("johndoe")).thenReturn(user);
		
		mockMvc.perform(get("/users/johndoe"))
		.andExpect(status().isOk())
		   .andExpect(jsonPath("userName").value("johndoe"))
		   .andExpect(jsonPath("emailAddress").value("jdoe@test.com"));
	
    }
}
