package com.ahmetsenel.universitymanagementapi.exception;

import lombok.Data;

@Data
public class BaseException extends RuntimeException{

    private MessageType messageType;

    public BaseException(MessageType messageType) {
        super(messageType.getMessage());
        this.messageType = messageType;
    }

    public BaseException(MessageType messageType, Object args) {
        super(String.format(messageType.getMessage(), args));
        this.messageType = messageType;
    }
}
