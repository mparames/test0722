package com.codingtest.exception;

public class UserDoesNotExistException extends Exception{
	public UserDoesNotExistException(String name) {
        super("User " + name + " does not exist");
    }

}
