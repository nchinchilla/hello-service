package com.intraway.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Entity
@ApiModel(description = "Representation of message")
@Table(name="Messages")
public class Message {

    @Id
    @ApiModelProperty(value = "Identifier", hidden = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "message_Id")
    private Integer messageId;

    @NotNull
    @ApiModelProperty(value = "Text of message")
    @Size(max = 120, message = "INTRAWAY: El maximo de caracteres ingresados es de 120")
    @Column(name="text")
    private String text;

    @ApiModelProperty(value = "Day of creation", hidden = true)
    @CreationTimestamp
    @Column(name="created_At")
    private Date createdAt;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
