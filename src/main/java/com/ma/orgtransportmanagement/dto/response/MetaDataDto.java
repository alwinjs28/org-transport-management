package com.ma.orgtransportmanagement.dto.response;

import java.io.Serializable;

public class MetaDataDto implements Serializable {
    private String message;

    private String messageLevel;

    public MetaDataDto(){

    }
    public MetaDataDto(String message, String messageLevel){
        this.message = message;
        this.messageLevel = messageLevel;
    }

    public String getMessageLevel() {
        return messageLevel;
    }

    public void setMessageLevel(String messageLevel) {
        this.messageLevel = messageLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
