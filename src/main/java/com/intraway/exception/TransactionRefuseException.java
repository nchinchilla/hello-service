package com.intraway.exception;

import javax.validation.ConstraintViolationException;

public class TransactionRefuseException extends RuntimeException {

    public  TransactionRefuseException(ConstraintViolationException e){
        super(e.getMessage());
    }
}
