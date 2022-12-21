package com.ma.orgtransportmanagement.dto.response;

import java.io.Serializable;

public class MetaDataDto implements Serializable {
    private String message;

    public MetaDataDto(){

    }
    public MetaDataDto(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
