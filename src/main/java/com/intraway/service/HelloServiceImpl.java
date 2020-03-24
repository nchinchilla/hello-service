package com.intraway.service;

import com.intraway.domain.Message;
import com.intraway.exception.MessageNotFoundException;
import com.intraway.exception.TransactionRefuseException;
import com.intraway.repository.MessageRepository;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;


@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message saveMessage(Message message) {

        try {
          return   messageRepository.save(message);
        }catch (ConstraintViolationException e){
            throw new TransactionRefuseException(e);
        }catch (Exception e){
            throw  e;
        }
    }

    @Override
    public Message getMessage(Integer id) {

        return messageRepository.findById(id).orElseThrow(()-> new MessageNotFoundException(id));
    }
}
