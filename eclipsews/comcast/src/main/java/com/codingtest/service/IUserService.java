package com.codingtest.service;

import com.codingtest.exception.UserAlreadyExistsException;
import com.codingtest.exception.UserDoesNotExistException;
import com.codingtest.model.User;

public interface IUserService {
	
	 User getByName(String userName) throws UserDoesNotExistException;	
	 User save(User user) throws UserAlreadyExistsException;	 
	 void remove(String userName) throws UserDoesNotExistException;

}
