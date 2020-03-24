package com.intraway.controller;


import com.intraway.domain.Message;
import com.intraway.dto.MessageDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.util.Date;
import java.util.Random;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class HelloControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void contextLoad(){
    }

    @Test
    public void savedMessage_with_correctMessageLength(){


        //Mock Payload
        Message message = new Message();
        message.setText("Prueba");
        message.setCreatedAt(new Date());
        message.setMessageId(1);

        ResponseEntity<MessageDTO> response = testRestTemplate.postForEntity("/intraway/messages/status", message, MessageDTO.class);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));

        MessageDTO messageDTO = response.getBody();
        assertThat(messageDTO.getId(), is(message.getMessageId()));

    }

    @Test
    public void savedMessage_with_incorrectMessageLength(){


        //Mock Payload
        String text = new Random().ints(160, 65, 101)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());

        Message message = new Message();
        message.setText(text);

        ResponseEntity<MessageDTO> response = testRestTemplate.postForEntity("/intraway/messages/status", message, MessageDTO.class);

        assertThat(response.getStatusCode(), is(HttpStatus.BAD_REQUEST));

    }

    @Test
    @Sql({ "classpath:import.sql" })
    public void getMessage_with_existingId(){

        //Mock
        String idMessage = "1";

        ResponseEntity<MessageDTO> response = testRestTemplate.getForEntity("/intraway/messages/{idMessage}", MessageDTO.class, idMessage);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));

    }

    @Test
    public void getMessage_with_nonexistenceId(){

        //Mock
        String idMessage = "2";

        ResponseEntity<MessageDTO> response = testRestTemplate.getForEntity("/intraway/messages/{idMessage}", MessageDTO.class, idMessage);

        assertThat(response.getStatusCode(), is(HttpStatus.NOT_FOUND));

    }


}
