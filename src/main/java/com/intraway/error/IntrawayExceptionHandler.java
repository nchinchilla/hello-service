package com.intraway.error;

import com.intraway.exception.MessageNotFoundException;
import com.intraway.exception.TransactionRefuseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


@ControllerAdvice
public class IntrawayExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(MessageNotFoundException.class)
    public void handleMessageNotFound(HttpServletResponse response) throws IOException{
        response.sendError(HttpStatus.NOT_FOUND.value());

    }

    @ExceptionHandler(TransactionRefuseException.class)
    public void handleBadInput(HttpServletResponse response) throws IOException{
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
