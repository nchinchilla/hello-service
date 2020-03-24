package com.intraway.dto;


import com.intraway.domain.Message;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "Representation of a message")
public class MessageDTO {

    @ApiModelProperty(value = "Text of message")
    private String text;
    private Date createdAt;
    private Integer id;

    public MessageDTO(){
    }

    public MessageDTO(Message message){
        super();
        this.text = message.getText();
        this.createdAt= message.getCreatedAt();
        this.id = message.getMessageId();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
