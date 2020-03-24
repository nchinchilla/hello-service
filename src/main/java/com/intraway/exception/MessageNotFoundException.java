package com.intraway.exception;


@SuppressWarnings("serial")
public class MessageNotFoundException extends RuntimeException {


    public MessageNotFoundException(Integer id){
        super("Message with Id " + id + " not found", new IntrawayException());
    }


}
