package com.spangles.orgtransportmanagement.dto.response;

import com.spangles.orgtransportmanagement.dto.PassengerDto;

import java.io.Serializable;

public class PassengerResponseWrapperDto implements Serializable {
    private PassengerDto passengerDto;
    private AdditionalHeaderDto additionalHeaderDto;

    public PassengerResponseWrapperDto(){

    }
    public PassengerResponseWrapperDto(PassengerDto passengerDto, AdditionalHeaderDto additionalHeaderDto){
        this.passengerDto = passengerDto;
        this.additionalHeaderDto = additionalHeaderDto;
    }

    public PassengerDto getPassengerDto() {
        return passengerDto;
    }

    public void setPassengerDto(PassengerDto passengerDto) {
        this.passengerDto = passengerDto;
    }

    public AdditionalHeaderDto getMetaDataDto() {
        return additionalHeaderDto;
    }

    public void setMetaDataDto(AdditionalHeaderDto additionalHeaderDto) {
        this.additionalHeaderDto = additionalHeaderDto;
    }
}
