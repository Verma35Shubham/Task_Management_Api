package com.taskmanagement.taskmanagementapi.Exceptions;

public class WrongUserActionException extends Exception{
    public WrongUserActionException(String message){
        super(message);
    }
}
