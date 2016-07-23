package com.codingtest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.codingtest.datastore.UserDB;
import com.codingtest.datastore.UserRepository;
import com.codingtest.exception.UserAlreadyExistsException;
import com.codingtest.exception.UserDoesNotExistException;
import com.codingtest.model.User;

@Component(value="userdao")
public class UserDAO implements IUserDAO{

	@Autowired
	@Qualifier("userdb")
	UserRepository userDB;
	
	@Override
	public User getUserByName(String name) throws UserDoesNotExistException{
		return userDB.getByName(name);
	}

	@Override
	public User createUser(User user) throws UserAlreadyExistsException {
		return userDB.create(user);
	}

	@Override
	public void removeUser(String name) throws UserDoesNotExistException {
		userDB.remove(name);
		
	}	

}
