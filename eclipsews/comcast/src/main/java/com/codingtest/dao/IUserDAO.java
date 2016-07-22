package com.codingtest.dao;

import com.codingtest.exception.UserAlreadyExistsException;
import com.codingtest.exception.UserDoesNotExistException;
import com.codingtest.model.User;

public interface IUserDAO {
	
	User getUserByName(String name) throws UserDoesNotExistException;
	User createUser(User user) throws UserAlreadyExistsException;
	void removeUser(String name) throws UserDoesNotExistException;

}
