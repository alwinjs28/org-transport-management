package com.ma.orgtransportmanagement.dto.response;

import com.ma.orgtransportmanagement.dto.PassengerDto;

import java.io.Serializable;

public class PassengerResponseWrapperDto implements Serializable {
    private PassengerDto passengerDto;
    private MetaDataDto metaDataDto;

    public PassengerResponseWrapperDto(){

    }
    public PassengerResponseWrapperDto(PassengerDto passengerDto,MetaDataDto metaDataDto){
        this.passengerDto = passengerDto;
        this.metaDataDto = metaDataDto;
    }

    public PassengerDto getPassengerDto() {
        return passengerDto;
    }

    public void setPassengerDto(PassengerDto passengerDto) {
        this.passengerDto = passengerDto;
    }

    public MetaDataDto getMetaDataDto() {
        return metaDataDto;
    }

    public void setMetaDataDto(MetaDataDto metaDataDto) {
        this.metaDataDto = metaDataDto;
    }
}
