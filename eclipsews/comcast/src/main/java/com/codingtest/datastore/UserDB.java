package com.codingtest.datastore;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.codingtest.exception.UserAlreadyExistsException;
import com.codingtest.exception.UserDoesNotExistException;
import com.codingtest.model.User;

@Component(value="userdb")
public class UserDB implements UserRepository {
	
	private Map<String,User> userMap;
	
	private UserDB(){
		userMap = new HashMap<String,User>();
	}
	
	@Override
	public User getByName(String name) throws UserDoesNotExistException{
		if (userMap.containsKey(name)) {
            return userMap.get(name);
        }
		throw new UserDoesNotExistException(name);
	}
	
	@Override
	public User create(User user) throws UserAlreadyExistsException{
		String name = user.getUserName();
		if(userMap.containsKey(name)){
			throw new UserAlreadyExistsException("User " + name + " already exists");
		}
		userMap.put(name, user);
		return user;
	}
	
	@Override
	public void remove(String name) throws UserDoesNotExistException{
	    User user = userMap.remove(name);
	    if(user == null){
	    	throw new UserDoesNotExistException("User " + name + " does not exist");
	    }
	}	
}
