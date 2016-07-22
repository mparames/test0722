package com.codingtest.exception;

public class UserAlreadyExistsException extends Exception {
	public UserAlreadyExistsException(String name) {
		 super("User " + name + " already exists");
    }
}

