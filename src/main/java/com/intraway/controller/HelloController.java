package com.intraway.controller;


import com.intraway.domain.Message;
import com.intraway.dto.MessageDTO;
import com.intraway.service.HelloService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api("/intraway")
@Validated
public class HelloController {

    @Autowired
    private HelloService helloService;

    @ApiOperation(value = "Register a new message", response = MessageDTO.class)
    @ApiResponses({@ApiResponse(code=200, message = "Success", response = MessageDTO.class),
                    @ApiResponse(code=500, message = "Error")})
    @PostMapping("/intraway/messages")
    public ResponseEntity<MessageDTO> saveMessage(@RequestBody  Message message) {

        Message response = helloService.saveMessage(message);

        return ResponseEntity.ok().body(new MessageDTO(response));

    }

    @ApiOperation(value="Find a message by Id", response = MessageDTO.class)
    @ApiResponses({@ApiResponse(code=200, message = "Success", response = MessageDTO.class),
                    @ApiResponse(code=500, message = "Error")})
    @GetMapping(value = "/intraway/messages/{idMessage}")
    public ResponseEntity<MessageDTO> getMessage(@PathVariable("idMessage") Integer idMessage){

        Message response = helloService.getMessage(idMessage);

        return ResponseEntity.ok().body(new MessageDTO(response));
    }

}
