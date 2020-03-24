package com.intraway.service;

import com.intraway.domain.Message;
import com.intraway.dto.MessageDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class HelloServiceTest {

    @Autowired
    private HelloService helloService;

    @Test
    public void givenText_thenSaveMessage(){

        //Mock
        //Mock Payload
        Message message = new Message();
        message.setText("Prueba");
        message.setCreatedAt(new Date());
        message.setMessageId(1);

        Message result = helloService.saveMessage(message);

        assertThat(result, is(not(nullValue())));

    }

    @Test
    public void givenId_thenShowMessage(){

        //Mock
        Integer messageId = 1;

        Message result = helloService.getMessage(1);

        assertThat(result, is(not(nullValue())));

    }



}
