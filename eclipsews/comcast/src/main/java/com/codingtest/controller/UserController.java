package com.codingtest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.codingtest.exception.UserAlreadyExistsException;
import com.codingtest.exception.UserDoesNotExistException;
import com.codingtest.model.User;
import com.codingtest.service.IUserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
    IUserService userService; 
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("name") String name) throws UserDoesNotExistException {
        User user = userService.getByName(name);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder) throws UserAlreadyExistsException { 
        User newUser = userService.save(user); 
        HttpHeaders header = new HttpHeaders();
        //keeping things simple here, can use link rel
        header.setLocation(builder.path("/users/{name}").buildAndExpand(newUser.getUserName()).toUri());
        return new ResponseEntity<Void>(header, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<Void>  removeUser(@PathVariable("name") String name) throws UserDoesNotExistException {
        userService.remove(name);        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
	@ExceptionHandler({UserAlreadyExistsException.class})
	 public ResponseEntity<String> handleDuplicate(Exception e) {        
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
    }
	
	@ExceptionHandler({UserDoesNotExistException.class})
	 public ResponseEntity<String> handleNotFound(Exception e) {        
       return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
   }
	
	//TODO add more exception handlers
}
