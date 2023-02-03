package com.spangles.orgtransportmanagement.dto.response;

import java.io.Serializable;

public class AdditionalHeaderDto implements Serializable {
    private String message;

    private String messageLevel;
    private int httpStatus;//400,401,402,403

    public AdditionalHeaderDto(){

    }
    public AdditionalHeaderDto(String message, String messageLevel, int httpStatus){
        this.message = message;
        this.messageLevel = messageLevel;
        this.httpStatus = httpStatus;
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

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }
}
