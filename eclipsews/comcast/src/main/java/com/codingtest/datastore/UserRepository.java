package com.codingtest.datastore;

import com.codingtest.exception.UserAlreadyExistsException;
import com.codingtest.exception.UserDoesNotExistException;
import com.codingtest.model.User;

public interface UserRepository {

	 User getByName(String name) throws UserDoesNotExistException;
	 User create(User user) throws UserAlreadyExistsException;
	 void remove(String name) throws UserDoesNotExistException;
	 
}
