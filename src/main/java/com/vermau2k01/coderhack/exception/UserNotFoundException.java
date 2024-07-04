package com.vermau2k01.coderhack.exception;


public class UserNotFoundException extends RuntimeException{

    String id;

    public UserNotFoundException(String id)
    {
        super(String.format("User not found with id : %s",id));
    }

}
