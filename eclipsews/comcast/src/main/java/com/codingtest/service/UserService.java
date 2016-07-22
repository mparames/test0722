package com.codingtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codingtest.dao.IUserDAO;
import com.codingtest.exception.UserAlreadyExistsException;
import com.codingtest.exception.UserDoesNotExistException;
import com.codingtest.model.User;

@Service("userService")
public class UserService implements IUserService {
	
	@Autowired
	@Qualifier("userdao")
	IUserDAO userDAO;
	
	@Override
	public User getByName(String name) throws UserDoesNotExistException{
		return userDAO.getUserByName(name);
	}
	
	@Override
	public User save(User user) throws UserAlreadyExistsException{
		user.setUserName("user" + System.currentTimeMillis());
		return userDAO.createUser(user);
	}

	@Override
	public void remove(String userName) throws UserDoesNotExistException {		
		userDAO.removeUser(userName);
	}

}
