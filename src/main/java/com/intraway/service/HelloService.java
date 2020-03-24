package com.intraway.service;

import com.intraway.domain.Message;
import com.intraway.dto.MessageDTO;

public interface HelloService {

    Message saveMessage(Message message);

    Message getMessage(Integer id);
}
