package com.taskmanagement.taskmanagementapi.Exceptions;

public class InvalidTaskException extends Exception{
    public InvalidTaskException(String message){
        super(message);
    }
}
